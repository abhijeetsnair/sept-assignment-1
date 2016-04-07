package com.sept01.main;

public class Favourites {

	WeatherStation station;
	User user;
	
	public User getUser(){
		return user;
	}
	
	public void setUser(User user){
		this.user = user;
	}

	public WeatherStation getStation() {
		return station;
	}

	public void setStation(WeatherStation station) {
		this.station = station;
	}
	
	
}
