package com.tcs.ilp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.tcs.ilp.bean.Day;
import com.tcs.ilp.bean.Trainee;
import com.tcs.ilp.bean.TraineeDay;
import com.tcs.ilp.report.AbsenteeReport;
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
            		+ " FROM Trainee TR JOIN TR.tSet TRD JOIN TRD.day DA WHERE TRD.status = :status AND DA.curDate = :curDate");
            query.setParameter("status", status);
            query.setParameter("curDate", date);
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

	public List<AbsenteeReport> absenteesMoreThanTwo()
	{
		List<AbsenteeReport> abList = new ArrayList<AbsenteeReport>();
        try
        {
            HibernateUtil.beginTransaction();
            Query query = HibernateUtil.getSession().createQuery(
            		"SELECT TR.empId, TR.empName, TR.lgName, TR.batchName, TR.project, COUNT(TRD.status)"
            		+ " FROM Trainee TR JOIN TR.tSet TRD JOIN TRD.day DA WHERE TRD.status = :status"
            		+ " GROUP BY TR.empId, TR.empName, TR.lgName, TR.batchName, TR.project"
            		+ " HAVING count(TRD.status)>2 ORDER BY TR.empId");
            query.setParameter("status", "A");
            List<?> l = query.list();
            HibernateUtil.commitTransaction();
            Iterator<?> it=l.iterator();
            while(it.hasNext())
    		{
    			Object rows[] = (Object[])it.next();
    			AbsenteeReport ab = new AbsenteeReport((Long)rows[0],(String)rows[1],(String)rows[2],(String)rows[3],(String)rows[4],(Long)rows[5]);
    			abList.add(ab);
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
        return abList;
	}

	@SuppressWarnings("unchecked")
	public List<Day> getOneAbsenteeDates(Long empId)
	{
		List<Day> dList = new ArrayList<Day>();
		List<Date> dateList = new ArrayList<Date>();
        try
        {
            HibernateUtil.beginTransaction();
            Query query = HibernateUtil.getSession().createQuery(
            		"SELECT DA.curDate FROM Trainee TR JOIN TR.tSet TRD JOIN TRD.day DA"
            		+ " WHERE TR.empId = :empId AND TRD.status = :status ORDER BY DA.curDate");
            query.setParameter("empId", empId);
            query.setParameter("status", "A");
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

	public boolean checkIfDayExists(Date curDate)
	{
        Day d=null;
        try
        {
            HibernateUtil.beginTransaction();
            d=(Day) HibernateUtil.getSession().get(Day.class, curDate);
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
        if(d==null)
		{
        	return false;
		}
        else
        {
        	return true;
        }   
	}
	public List<AbsenteeReport> batchNameAbsentees()
	{
		List<AbsenteeReport> abList = new ArrayList<AbsenteeReport>();
        try
        {
            HibernateUtil.beginTransaction();
            Query query = HibernateUtil.getSession().createQuery(
            		"SELECT TR.batchName, COUNT(TRD.status)"
            		+ " FROM Trainee TR JOIN TR.tSet TRD JOIN TRD.day DA WHERE TRD.status = :status"
            		+ " GROUP BY TR.batchName HAVING count(TRD.status)>0");
            query.setParameter("status", "A");
            List<?> l = query.list();
            HibernateUtil.commitTransaction();
            Iterator<?> it=l.iterator();
            while(it.hasNext())
    		{
    			Object rows[] = (Object[])it.next();
    			AbsenteeReport ab = new AbsenteeReport((String)rows[0],(Long)rows[1]);
    			abList.add(ab);
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
        return abList;
	}
	public List<AbsenteeReport> betweenAbsenteeTailgaters(String status, Date date1, Date date2)
	{
		List<AbsenteeReport> abList = new ArrayList<AbsenteeReport>();
        try
        {
            HibernateUtil.beginTransaction();
            Query query = HibernateUtil.getSession().createQuery(
            		"SELECT TR.empId, TR.empName, TR.lgName, TR.batchName, TR.project, COUNT(TRD.status)"
            		+ " FROM Trainee TR JOIN TR.tSet TRD JOIN TRD.day DA WHERE TRD.status = :status AND DA.curDate BETWEEN :date1 AND :date2"
            		+ " GROUP BY TR.empId, TR.empName, TR.lgName, TR.batchName, TR.project"
            		+ " HAVING count(TRD.status)>0 ORDER BY TR.empId");
            query.setParameter("status", "A");
            query.setParameter("date1", date1);
            query.setParameter("date2", date2);
            List<?> l = query.list();
            HibernateUtil.commitTransaction();
            Iterator<?> it=l.iterator();
            while(it.hasNext())
    		{
            	Object rows[] = (Object[])it.next();
    			AbsenteeReport ab = new AbsenteeReport((Long)rows[0],(String)rows[1],(String)rows[2],(String)rows[3],(String)rows[4],(Long)rows[5]);
    			abList.add(ab);
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
        return abList;
	}
}