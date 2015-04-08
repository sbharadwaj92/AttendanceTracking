package com.tcs.ilp.service;

import com.tcs.ilp.bean.User;
import com.tcs.ilp.bean.UserType;
import com.tcs.ilp.dao.UserDAO;
import com.tcs.ilp.util.PasswordGeneratorAndEncryptor;

public class UserService
{
	UserDAO uDao = new UserDAO();
	public String createUserService(User user)
	{
		if(!uDao.checkIfUserExists(user.getEmpId()))
		{
			UserType ut = new UserType();
			ut.setUserTypeId(2);
			user.setPassword(PasswordGeneratorAndEncryptor.generateRandomPassword());
			String password = user.getPassword();
			user.setUserType(ut);
			uDao.insertUser(user);
			return "The Temporary Password is "+ password;
		}
		return "User Already Exists";
	}
	public boolean checkUserIdExists(Long empId)
	{
		return uDao.checkIfUserExists(empId);
	}
	public boolean checkUserIdPassword(User user)
	{
		return uDao.checkUserIdPassword(user);
	}
	public String retrieveEmpName(Long empId)
	{
		return uDao.retrieveEmpName(empId);
	}
	public void updateUserLoginCount(User user)
	{
		uDao.updateUserLoginCount(user);
	}
	public Long retrieveLoginCount(Long empId)
	{
		return uDao.getUserLoginCount(empId);
	}
	public boolean checkIfUserExists(Long empId)
	{
		return uDao.checkIfUserExists(empId);
	}
	public void updateUserPassword(User user, String password)
	{
		uDao.updateUserPassword(user, password);
	}
}