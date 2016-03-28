package com.sept01.main;

public class User {

	private String name;
	private String phoNo;
	private String details; //not sure what this is meant to contain
	private Area location;
	
	public User(String name, String phoNo, String details, Area location){
		this.name = name;
		this.phoNo = phoNo;
		this.details = details;
		this.location = location;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getDetails(){
		return details;
	}
	
	public Area getLocation(){
		return location;
	}
	
}
