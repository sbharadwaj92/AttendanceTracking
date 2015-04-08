package com.tcs.ilp.report;

public class AbsenteeReport
{
	private Long empId;
	private String empName;
	private String lgName;
	private String batchName;
	private String project;
	private Long count;

	public AbsenteeReport(Long empId, String empName, String lgName, String batchName, String project, Long count)
	{
		this.empId = empId;
		this.empName = empName;
		this.lgName = lgName;
		this.batchName = batchName;
		this.project = project;
		this.count = count;
	}
	public AbsenteeReport(String batchName, Long count) 
	{
		this.batchName = batchName;
		this.count = count;
	}
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
	public String getProject()
	{
		return project;
	}
	public void setProject(String project)
	{
		this.project = project;
	}
	public Long getCount()
	{
		return count;
	}
	public void setCount(Long count)
	{
		this.count = count;
	}
}