package com.tcs.ilp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.tcs.ilp.bean.Employee;
import com.tcs.ilp.bean.User;
import com.tcs.ilp.util.HibernateUtil;
import com.tcs.ilp.util.PasswordGeneratorAndEncryptor;

public class UserDAO
{
	public boolean checkIfUserExists(Long empId)
	{
        User u=null;
        try
        {
            HibernateUtil.beginTransaction();
            u=(User) HibernateUtil.getSession().get(User.class, empId);
            HibernateUtil.commitTransaction();
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
        }
        finally
        {
            HibernateUtil.closeSession();
        }
        if(u==null)
		{
        	return false;
		}
        else
        {
        	return true;
        } 
	}

	public void insertUser(User user)
	{
		user.setPassword(PasswordGeneratorAndEncryptor.cryptWithMD5(user.getPassword()));
		Employee e = new Employee();
		e.setEmpId(user.getEmpId());
		e.setUser(user);
        try
        {
            HibernateUtil.beginTransaction();
            HibernateUtil.getSession().save(user);
            HibernateUtil.getSession().save(e);
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

	public boolean checkUserIdPassword(User user)
	{
		List<User> u = new ArrayList<User>();
        try
        {
            HibernateUtil.beginTransaction();
            Query query = HibernateUtil.getSession().createQuery(
            		"SELECT u.empId from User u where u.empId = :empId AND u.password = :password");
            query.setParameter("empId", user.getEmpId());
            query.setParameter("password", PasswordGeneratorAndEncryptor.cryptWithMD5(user.getPassword()));
            u = query.list();
            System.out.println(u);
            HibernateUtil.commitTransaction();
            
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
        }
        finally
        {
            HibernateUtil.closeSession();
        }
        if(!u.isEmpty())
        {
        	return true;
        }
        else
        {
        	return false;
        }
	}
	public String retrieveEmpName(Long empId)
	{
        Employee e=null;
        try
        {
            HibernateUtil.beginTransaction();
            e=(Employee) HibernateUtil.getSession().get(Employee.class, empId);
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
        return e.getEmpName();
	}

	public void updateUserLoginCount(User user)
	{
        User u=null;
        try
        {
            HibernateUtil.beginTransaction();
            u=(User) HibernateUtil.getSession().get(User.class, user.getEmpId());
            u.setLoginCount(u.getLoginCount()+1);
            HibernateUtil.getSession().update(u);
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

	public Long getUserLoginCount(Long empId)
	{
        User u=null;
        try
        {
            HibernateUtil.beginTransaction();
            u=(User) HibernateUtil.getSession().get(User.class, empId);
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
        return u.getLoginCount();
	}

	public void updateUserPassword(User user, String password)
	{
        try
        {
            HibernateUtil.beginTransaction();
            Query query =  HibernateUtil.getSession().createQuery("UPDATE User U SET U.password = :password where U.empId = :empId");
            query.setParameter("password", PasswordGeneratorAndEncryptor.cryptWithMD5(password));
            query.setParameter("empId", user.getEmpId());
            int res = query.executeUpdate();
            System.out.println("completed updation");
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