package com.tcs.ilp.action;

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
import com.tcs.ilp.report.AbsenteeReport;
import com.tcs.ilp.service.TraineeService;

public class TraineeAction extends ActionSupport implements ModelDriven<Trainee>, ServletRequestAware
{
	private Trainee trainee = new Trainee();
	private TraineeService tSvc= new TraineeService();
	private List<Trainee> aList = new ArrayList<Trainee>();
	private List<Day> dList = new ArrayList<Day>();
	private List<AbsenteeReport> abList = new ArrayList<AbsenteeReport>();
	private HttpServletRequest request;
	private static final long serialVersionUID = 1L;

	/*This method is use to insert Trainee Records into our own database 
	by comparing the Status and Date of Release of Trainee*/
	public String insertTrainee() throws ParseException
	{
		int count=0;
		Date date=null;
		String selDate = request.getParameter("date1");
		SimpleDateFormat sd = new SimpleDateFormat ("dd-MM-yyyy");
		date = sd.parse(selDate);
		Date today = new Date();
		if(date.compareTo(today)<0)
		{
			count=tSvc.retrieveTrainees(date);
		}
		request.setAttribute("count", count );
		return SUCCESS;
	}
	
	/*This method is use get daily report on the number of employees
	  who are absent on that particular day*/
	public String getDailyAbsenteesList() throws ParseException
	{
		Date date=null;
		String selDate = request.getParameter("date1");
		SimpleDateFormat sd = new SimpleDateFormat ("dd-MM-yyyy");
		date = sd.parse(selDate);
		Date today = new Date();
		if(date.compareTo(today)<0)
		{
			aList = tSvc.displayDailyAbsenteeTrailgater("A", date);
		}
        request.setAttribute("date", date);
		return SUCCESS;
	}
	
	/*This method is use get daily report on the number of employees
	  who have swapped one time on that particular day*/
	public String getDailyTailgatersList() throws ParseException
	{
		Date date=null;
		String selDate = request.getParameter("date1");
		SimpleDateFormat sd = new SimpleDateFormat ("dd-MM-yyyy");
		date = sd.parse(selDate);
		Date today = new Date();
		if(date.compareTo(today)<0)
		{
			aList = tSvc.displayDailyAbsenteeTrailgater("0.00", date);
		}
        request.setAttribute("date", date);
		return SUCCESS;
	}
	
	/*This method is use get daily report on the number of employees
	  who are absent for more than two days*/
	public String getAbsenteesMoreThanTwo()
	{
		abList=tSvc.displayAbsenteesMoreThanTwo();
		return SUCCESS;
	}

	public String getOneAbsentee()
	{
		String sEmpId = request.getParameter("empId");
		trainee.setEmpId(Long.parseLong(sEmpId));
		//List<Day> dList = new ArrayList<Day>();
		dList = tSvc.getOneAbsenteeDetails(trainee.getEmpId());
		//request.setAttribute("dList", dList);
		return SUCCESS;
	}
	
	public List<Day> getdList() {
		return dList;
	}

	public void setdList(List<Day> dList) {
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
	public List<AbsenteeReport> getAbList() {
		return abList;
	}

	public void setAbList(List<AbsenteeReport> abList) {
		this.abList = abList;
	}

	public List<Trainee> getaList() {
		return aList;
	}

	public void setaList(List<Trainee> aList) {
		this.aList = aList;
	}
}