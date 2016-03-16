package com.sept01.main;

public class User {

	private String name;
	private String phoNo;
	private String details; //not sure what this is meant to contain
	//private Location location; // should we implement a location class? Location (state, area, weatherStation)?
	
	public User(String name, String phoNo, String details /*Location location*/){
		this.name = name;
		this.phoNo = phoNo;
		this.details = details;
		//this.location = location;
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
	/*
	public Location getLocation(){
		return location;
	}
	*/
}
