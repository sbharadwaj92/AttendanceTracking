package com.tcs.ilp.bean;

public class TraineeDay
{
	private TraineeDayId id;
	private Day day;
	private Trainee trainee;
	private String status;
	
	public TraineeDayId getId() {
		return id;
	}
	public void setId(TraineeDayId id) {
		this.id = id;
	}
	public Day getDay() {
		return day;
	}
	public void setDay(Day day) {
		this.day = day;
	}
	public Trainee getTrainee() {
		return trainee;
	}
	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}

