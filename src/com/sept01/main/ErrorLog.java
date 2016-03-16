package com.sept01.main;

import java.sql.Date;
import java.sql.Time;

public class ErrorLog {

	Time time;
	Date date;
	String msg;
	
	private String eToString(){
		String outString = "ERROR " + time.toString() + " " + date.toString() + " " + msg;
		return outString;
	}
	
	public void setTime(Time time){
		this.time = time;
	}
	
	private Time getTime(){
		return time;
	}
	
	private String getMsg(){
		return msg;
	}
}
