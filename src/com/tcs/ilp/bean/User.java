package com.tcs.ilp.bean;

public class User
{
	private Long empId;
	private String userName;
	private String password;
	
	private Employee employee;
	private UserType userType;
	
	public Long getEmpId()
	{
		return empId;
	}
	public void setEmpId(Long empId)
	{
		this.empId = empId;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public Employee getEmployee()
	{
		return employee;
	}
	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}
	public UserType getUserType()
	{
		return userType;
	}
	public void setUserType(UserType userType)
	{
		this.userType = userType;
	}
}