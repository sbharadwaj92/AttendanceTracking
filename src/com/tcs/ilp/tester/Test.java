package com.tcs.ilp.tester;

import java.text.ParseException;
import com.tcs.ilp.bean.User;
import com.tcs.ilp.bean.UserType;
import com.tcs.ilp.dao.UserDAO;

public class Test
{
	public static void main(String[] args) throws ParseException
	{
		UserDAO uDao = new UserDAO();
		User u = new User();
		UserType ut = new UserType();
		ut.setUserTypeId(1);
		u.setEmpId(834002l);
		u.setPassword("password");
		u.setUserType(ut);
		uDao.insertUser(u);
	}
}