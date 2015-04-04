package com.tcs.ilp.dao;

import org.hibernate.HibernateException;

import com.tcs.ilp.bean.User;
import com.tcs.ilp.util.HibernateUtil;

public class UserDAO
{
	public void insertUser(User u)
	{
        try
        {
            HibernateUtil.beginTransaction();
            HibernateUtil.getSession().save(u);
            HibernateUtil.commitTransaction();
        }
        catch(HibernateException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            HibernateUtil.closeSession();
        }
		
	}
}
