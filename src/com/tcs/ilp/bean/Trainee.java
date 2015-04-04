package com.tcs.ilp.bean;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
public class Trainee
{
	private Long empId;
	private String empName;
	private String lgName;
	private String batchName;
	private String project;
	private String city;
	private String location;
	
	private Date dor;
	
	private Set<TraineeDay> tSet;

	public Trainee()
	{
		tSet = new HashSet<TraineeDay>();
	}
	public Trainee(Long empId, String empName, String lgName, String batchName, String project, String location)
	{
		this.empId = empId;
		this.empName = empName;
		this.lgName = lgName;
		this.batchName = batchName;
		this.project = project;
		this.location = location;
	}
	public Trainee(Long empId, String empName, String lgName, String batchName, String project)
	{
		this.empId = empId;
		this.empName = empName;
		this.lgName = lgName;
		this.batchName = batchName;
		this.project = project;
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
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getLocation()
	{
		return location;
	}
	public void setLocation(String location)
	{
		this.location = location;
	}
	public Date getDor()
	{
		return dor;
	}
	public void setDor(Date dor)
	{
		this.dor = dor;
	}
	public Set<TraineeDay> gettSet()
	{
		return tSet;
	}
	public void settSet(Set<TraineeDay> tSet)
	{
		this.tSet = tSet;
	}
}