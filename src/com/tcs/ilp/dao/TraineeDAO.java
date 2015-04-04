package com.tcs.ilp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.tcs.ilp.bean.Day;
import com.tcs.ilp.bean.Trainee;
import com.tcs.ilp.bean.TraineeDay;
import com.tcs.ilp.util.HibernateUtil;

public class TraineeDAO
{
	public void insertTrainee(Trainee t)
	{
        try
        {
            HibernateUtil.beginTransaction();
            HibernateUtil.getSession().save(t);
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
	}
	
	public void insertDay(Day d)
	{
        try
        {
            HibernateUtil.beginTransaction();
            HibernateUtil.getSession().save(d);
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
	}

	public void insertTraineeDay(TraineeDay td)
	{
        try
        {
            HibernateUtil.beginTransaction();
            HibernateUtil.getSession().save(td);
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
	}

	public boolean checkIfTraineeExists(Long empId)
	{
        Trainee t=null;
        try
        {
            HibernateUtil.beginTransaction();
            t=(Trainee) HibernateUtil.getSession().get(Trainee.class, empId);
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
        if(t==null)
		{
        	return false;
		}
        else
        {
        	return true;
        }    
	}
	
	public List<Trainee> dailyAbsenteeTailgaters(String status, Date date)
	{
		List<Trainee> aList = new ArrayList<Trainee>();
        try
        {
            HibernateUtil.beginTransaction();
            Query query = HibernateUtil.getSession().createQuery(
            		"SELECT TR.empId, TR.empName, DA.curDate, TR.lgName, TR.batchName, TR.project, TR.location"
            		+ " FROM Trainee TR JOIN TR.tSet TRD JOIN TRD.day DA WHERE TRD.status = ? AND DA.curDate = ?");
            query.setParameter(0, status);
            query.setParameter(1, date);
            List<?> l = query.list();
            HibernateUtil.commitTransaction();
            Iterator<?> it=l.iterator();
            while(it.hasNext())
    		{
    			Object rows[] = (Object[])it.next();
    			Trainee t = new Trainee((Long)rows[0],(String)rows[1],(String)rows[3],(String)rows[4],(String)rows[5],(String)rows[6]);
    			aList.add(t);
    		}
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
        }
        finally
        {
            HibernateUtil.closeSession();
        }
        return aList;
	}

	public Map<List<Long>, List<Trainee>> absenteesMoreThanTwo()
	{
		List<Long> count = new ArrayList<Long>();
		List<Trainee> aList = new ArrayList<Trainee>();
		Map<List<Long>, List<Trainee>> traineeCountMap = new HashMap<List<Long>, List<Trainee>>();
        try
        {
            HibernateUtil.beginTransaction();
            Query query = HibernateUtil.getSession().createQuery(
            		"SELECT TR.empId, TR.empName, TR.lgName, TR.batchName, TR.project, COUNT(TRD.status)"
            		+ " FROM Trainee TR JOIN TR.tSet TRD JOIN TRD.day DA WHERE TRD.status=?"
            		+ " GROUP BY TR.empId, TR.empName, TR.lgName, TR.batchName, TR.project"
            		+ " HAVING count(TRD.status)>2 ORDER BY TR.empId");
            query.setParameter(0, "A");
            List<?> l = query.list();
            HibernateUtil.commitTransaction();
            Iterator<?> it=l.iterator();
            while(it.hasNext())
    		{
    			Object rows[] = (Object[])it.next();
    			Trainee t = new Trainee((Long)rows[0],(String)rows[1],(String)rows[2],(String)rows[3],(String)rows[4]);
    			aList.add(t);
    			count.add((Long)rows[5]);
    		}
            traineeCountMap.put(count, aList);
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
        }
        finally
        {
            HibernateUtil.closeSession();
        }
        return traineeCountMap;
	}

	public List<Day> getOneAbsenteeDates(Long empId)
	{
		List<Day> dList = new ArrayList<Day>();
		List<Date> dateList = new ArrayList<Date>();
        try
        {
            HibernateUtil.beginTransaction();
            Query query = HibernateUtil.getSession().createQuery(
            		"SELECT DA.curDate FROM Trainee TR JOIN TR.tSet TRD JOIN TRD.day DA"
            		+ " WHERE TR.empId = ? AND TRD.status = ? ORDER BY DA.curDate");
            query.setParameter(0, empId);
            query.setParameter(1, "A");
            dateList = (ArrayList<Date>) query.list();
            HibernateUtil.commitTransaction();
            for(int i=0;i<dateList.size();i++)
            {
            	Day d = new Day();
            	d.setCurDate(dateList.get(i));
            	dList.add(d);
            }
        }
        catch(HibernateException e)
        {
            e.printStackTrace();
        }
        finally
        {
            HibernateUtil.closeSession();
        }
        return dList;
	}
}