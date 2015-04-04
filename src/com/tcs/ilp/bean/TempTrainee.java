package com.tcs.ilp.bean;

import java.util.Date;

public class TempTrainee
{
	private Long empId;
	private String empName;
	private String lgName;
	private String batchName;
	private Date doj;
	private Date dor;

	public Long getEmpId()
	{
		return empId;
	}
	public void setEmpId(Long empId)
	{
		this.empId = empId;
	}
	public String getEmpName()
	{
		return empName;
	}
	public void setEmpName(String empName)
	{
		this.empName = empName;
	}
	public String getLgName()
	{
		return lgName;
	}
	public void setLgName(String lgName)
	{
		this.lgName = lgName;
	}
	public String getBatchName()
	{
		return batchName;
	}
	public void setBatchName(String batchName)
	{
		this.batchName = batchName;
	}
	public Date getDoj()
	{
		return doj;
	}
	public void setDoj(Date doj)
	{
		this.doj = doj;
	}
	public Date getDor()
	{
		return dor;
	}
	public void setDor(Date dor)
	{
		this.dor = dor;
	}
}