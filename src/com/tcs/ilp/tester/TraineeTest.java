package com.tcs.ilp.tester;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.tcs.ilp.bean.Day;
import com.tcs.ilp.bean.Trainee;
import com.tcs.ilp.bean.TraineeDay;
import com.tcs.ilp.bean.TraineeDayId;
import com.tcs.ilp.dao.TraineeDAO;

public class TraineeTest
{
	public static void main(String[] args) throws ParseException
	{
		TraineeDAO tDao = new TraineeDAO();
		Trainee t1 = new Trainee();
		t1.setEmpId(834002l);
		tDao.insertTrainee(t1);
		Day d1 = new Day();
		SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-yyyy");
		String d = "03-03-2015";
		Date date = new Date();
		date = sdt.parse(d);
		d1.setCurDate(date);
		tDao.insertDay(d1);
		TraineeDayId tdid = new TraineeDayId();
		tdid.setEmpId(t1.getEmpId());
		tdid.setCurDate(d1.getCurDate());
		TraineeDay td = new TraineeDay();
		td.setId(tdid);
		td.setDay(d1);
		td.setTrainee(t1);
		td.setStatus("A");
		t1.gettSet().add(td);
		d1.getdSet().add(td);
		tDao.insertTraineeDay(td);		
	}
}
