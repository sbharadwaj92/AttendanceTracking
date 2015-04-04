package com.tcs.ilp.bean;

import java.util.HashSet;
import java.util.Set;
public class UserType
{

	private int userTypeId;
	private String userTypeName;
	private Set<User> uSet;

	public UserType()
	{
		uSet = new HashSet<User>();
	}
	public int getUserTypeId()
	{
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId)
	{
		this.userTypeId = userTypeId;
	}
	public String getUserTypeName()
	{
		return userTypeName;
	}
	public void setUserTypeName(String userTypeName)
	{
		this.userTypeName = userTypeName;
	}
	public Set<User> getuSet()
	{
		return uSet;
	}
	public void setuSet(Set<User> uSet)
	{
		this.uSet = uSet;
	}
}