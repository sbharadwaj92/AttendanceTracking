package com.tcs.ilp.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tcs.ilp.bean.Day;
import com.tcs.ilp.bean.Trainee;
import com.tcs.ilp.exception.EmptyDateException;
import com.tcs.ilp.exception.InvalidDateException;
import com.tcs.ilp.report.AbsenteeReport;
import com.tcs.ilp.service.TraineeService;

public class TraineeAction extends ActionSupport implements ModelDriven<Trainee>, ServletRequestAware
{
	private Trainee trainee = new Trainee(); //Model Driven Object
	private TraineeService tSvc= new TraineeService(); //Trainee Service Object
	private List<Trainee> aList = new ArrayList<Trainee>(); //List to Store either absentees or tailgaters
	private List<Day> dList = new ArrayList<Day>(); //List to store the days where a particular employee is absent
	private List<AbsenteeReport> abList = new ArrayList<AbsenteeReport>(); //List to store absentees who are absent for more than two days
	private Day day = new Day();
	private HttpServletRequest request; //http servlet request to get non model driven variables from jsp
	
	private static final long serialVersionUID = 1L;

	/*This method is use to insert Trainee Records into our own database 
	by comparing the Status and Date of Release of Trainee*/
	public String insertTrainee() throws EmptyDateException, ParseException, IOException, InvalidDateException
	{
		int count=0;
		String selDate = request.getParameter("date1"); //getting the date parameter from datepicker in jsp
		System.out.println(selDate);
		if(selDate == null)
		{
			throw new EmptyDateException();
		}
		SimpleDateFormat sd = new SimpleDateFormat ("dd-MM-yyyy");
		day.setCurDate(sd.parse(selDate));
		Date today = new Date();
		if(day.getCurDate().compareTo(today)<0) //checking if the selected date is less than the current date
		{
				count=tSvc.retrieveTrainees(day.getCurDate());
		}
		else
		{
			throw new InvalidDateException();
		}
		request.setAttribute("count", count);
		return SUCCESS;
	}
	
	/*This method is use get daily report on the number of employees
	  who are absent on that particular day*/
	public String getDailyAbsenteesList() throws ParseException
	{
		String selDate = request.getParameter("date1");
		SimpleDateFormat sd = new SimpleDateFormat ("dd-MM-yyyy");
		day.setCurDate(sd.parse(selDate));
		Date today = new Date();
		if(day.getCurDate().compareTo(today)<0) //checking if the selected date is less than the current date
		{
			aList = tSvc.displayDailyAbsenteeTrailgater("A", day.getCurDate()); //Status "A" is considered as absent
		}
		return SUCCESS;
	}
	
	/*This method is use get daily report on the number of employees
	  who have swapped one time on that particular day*/
	public String getDailyTailgatersList() throws ParseException
	{
		String selDate = request.getParameter("date1");
		SimpleDateFormat sd = new SimpleDateFormat ("dd-MM-yyyy");
		day.setCurDate(sd.parse(selDate));
		Date today = new Date();
		if(day.getCurDate().compareTo(today)<0) //checking if the selected date is less than the current date
		{
			aList = tSvc.displayDailyAbsenteeTrailgater("0.00", day.getCurDate()); //Status "0.00" is considered as tailgating
		}
		return SUCCESS;
	}
	
	/*This method is used get daily report on the number of employees
	  who are absent for more than two days*/
	public String getAbsenteesMoreThanTwo()
	{
		abList=tSvc.displayAbsenteesMoreThanTwo();
		return SUCCESS;
	}

	/*This method is used to get list of days when a particular employee was absent*/
	public String getOneAbsentee()
	{
		String sEmpId = request.getParameter("empId");
		trainee.setEmpId(Long.parseLong(sEmpId));
		dList = tSvc.getOneAbsenteeDetails(trainee.getEmpId());
		return SUCCESS;
	}
	
	public List<Day> getdList()
	{
		return dList;
	}
	public void setdList(List<Day> dList)
	{
		this.dList = dList;
	}
	public Trainee getModel()
	{
		return trainee;
	}
	public void setServletRequest(HttpServletRequest request)
	{
		this.request=request;
	}
	public List<AbsenteeReport> getAbList()
	{
		return abList;
	}
	public void setAbList(List<AbsenteeReport> abList)
	{
		this.abList = abList;
	}
	public List<Trainee> getaList()
	{
		return aList;
	}
	public void setaList(List<Trainee> aList)
	{
		this.aList = aList;
	}
	public Day getDay()
	{
		return day;
	}
	public void setDay(Day day)
	{
		this.day = day;
	}
	
}