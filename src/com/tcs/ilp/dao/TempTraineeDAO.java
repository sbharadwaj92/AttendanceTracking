package com.tcs.ilp.dao;

import org.hibernate.HibernateException;

import com.tcs.ilp.bean.TempTrainee;
import com.tcs.ilp.util.HibernateUtil;

public class TempTraineeDAO
{
	public TempTrainee getTraineeBatchLgDorDetails(Long empId)
	{
        TempTrainee tt=null;
        try
        {
            HibernateUtil.beginTransaction();
            tt=(TempTrainee) HibernateUtil.getSession().get(TempTrainee.class, empId);
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
        return tt;
	}
}
