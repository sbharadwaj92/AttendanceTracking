package com.tcs.ilp.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.tcs.ilp.bean.Day;
import com.tcs.ilp.service.TraineeService;

public class AjaxAction extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private List<Day> dList = new ArrayList<Day>();
	private TraineeService tSvc= new TraineeService();
	private String empId;
	private String dates[];
	/*This method is used to get list of days when a particular employee was absent*/
	public String getOneAbsentee()
	{
		System.out.println("Ajax Query");
		SimpleDateFormat sd = new SimpleDateFormat ("dd-MMM-yyyy");
		Long epId = Long.parseLong(empId);
		dList = tSvc.getOneAbsenteeDetails(epId);
		dates = new String[dList.size()];
		for(int i=0;i<dList.size();i++)
		{
			dates[i]=sd.format(dList.get(i).getCurDate());
		}
		return SUCCESS;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String[] getDates() {
		return dates;
	}
	public void setDates(String[] dates) {
		this.dates = dates;
	}
}