package com.tcs.ilp.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
public class Day
{
	private Date curDate;
	private Set<TraineeDay> dSet;

	public Day()
	{
		dSet = new HashSet<TraineeDay>();
	}
	public Day(Date curDate)
	{
		this.curDate = curDate;
	}
	public Date getCurDate()
	{
		return curDate;
	}
	public void setCurDate(Date curDate)
	{
		this.curDate = curDate;
	}
	public Set<TraineeDay> getdSet()
	{
		return dSet;
	}
	public void setdSet(Set<TraineeDay> dSet)
	{
		this.dSet = dSet;
	}
}
