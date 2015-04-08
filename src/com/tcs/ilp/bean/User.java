package com.tcs.ilp.bean;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;

public class User
{
	private Long empId;
	private String userName;
	private String password;
	private long loginCount;
	
	private Employee employee;
	private UserType userType;
	
	public Long getEmpId()
	{
		return empId;
	}
	
	@RequiredFieldValidator(message="Please Enter Valid Employee ID")
	public void setEmpId(Long empId)
	{
		this.empId = empId;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public Employee getEmployee()
	{
		return employee;
	}
	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}
	public UserType getUserType()
	{
		return userType;
	}
	public void setUserType(UserType userType)
	{
		this.userType = userType;
	}
	public long getLoginCount()
	{
		return loginCount;
	}
	public void setLoginCount(long loginCount)
	{
		this.loginCount = loginCount;
	}
}