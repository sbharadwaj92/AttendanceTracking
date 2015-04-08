package com.tcs.ilp.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.VisitorFieldValidator;
import com.tcs.ilp.bean.User;
import com.tcs.ilp.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>, ServletRequestAware, SessionAware
{
	User user = new User();
	UserService uSvc = new UserService();
	HttpServletRequest request;
	
	private SessionMap<String,Object> sessionMap;
	
	private static final long serialVersionUID = 1L;
	
	@Validations
	public String addUser()
	{
		String result=uSvc.createUserService(user);
		request.setAttribute("result", result);
		return SUCCESS;
	}
	
	@Validations
	public String loginUser()
	{
		if(user.getEmpId()!=null || user.getPassword()!=null || !user.getEmpId().equals("") || !user.getPassword().equals(""))
		{
			if(uSvc.checkUserIdExists(user.getEmpId()))
			{
				if(uSvc.checkUserIdPassword(user))
				{
					String empName=null;
					try
					{
						empName = uSvc.retrieveEmpName(user.getEmpId());
						
					}
					catch(NullPointerException e)
					{
						e.printStackTrace();
					}
					if(empName==null)
					{
						empName="User";
					}
					uSvc.updateUserLoginCount(user);
					sessionMap.put("login","true");
				    sessionMap.put("empId",user.getEmpId());
				    sessionMap.put("empName", empName);
				    sessionMap.put("loginCount", uSvc.retrieveLoginCount(user.getEmpId()));
					return "success";
				}
			}
		}
		request.setAttribute("result", "Invalid Employee ID/Password");
		return "failure";
	}
	
	@SkipValidation
	public String changeUserPassword()
	{
		Long empId = (Long) sessionMap.get("empId");
		System.out.println(empId);
		if(uSvc.checkIfUserExists(empId))
		{
			user.setEmpId(empId);
			System.out.println(request.getParameter("password1"));
			System.out.println(request.getParameter("password2"));
			user.setPassword(request.getParameter("password1"));
			if(uSvc.checkUserIdPassword(user));
			{
				System.out.println("entering imp");
				uSvc.updateUserPassword(user, request.getParameter("password2"));
				System.out.println("after update");
				if(sessionMap!=null)
				{
					sessionMap.invalidate();
				}
				return SUCCESS;
			}
		}
		return "failure";
	}
	

	@SkipValidation
	public String logoutUser()
	{
		if(sessionMap!=null)
		{
			sessionMap.invalidate();
		}
		return SUCCESS;
	}
	
	
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	
	@Override
	@VisitorFieldValidator(appendPrefix = false)
	public User getModel()
	{
		return user;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request)
	{
		this.request=request;
	}

	@Override
	public void setSession(Map<String, Object> sessionMap)
	{
		this.sessionMap=(SessionMap<String, Object>) sessionMap;
	}
}