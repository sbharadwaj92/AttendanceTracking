package com.tcs.ilp.bean;

import java.util.Date;
public class TraineeDayId implements java.io.Serializable
{
	private static final long serialVersionUID = -9026465793685196471L;
	private Long empId;
	private Date curDate;
	public Long getEmpId()
	{
		return empId;
	}
	public void setEmpId(Long empId)
	{
		this.empId = empId;
	}
	public Date getCurDate()
	{
		return curDate;
	}
	public void setCurDate(Date curDate)
	{
		this.curDate = curDate;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curDate == null) ? 0 : curDate.hashCode());
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TraineeDayId other = (TraineeDayId) obj;
		if (curDate == null) {
			if (other.curDate != null)
				return false;
		} else if (!curDate.equals(other.curDate))
			return false;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		return true;
	}
}