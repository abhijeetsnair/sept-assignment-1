package com.sept01.main;

public class Favourites {

	WeatherData[] weatherdata;
	User user;
	
	public User getUser(){
		return user;
	}
	
	public void setUser(User user){
		this.user = user;
	}
	
	public WeatherData[] getWetherData(){
		return weatherdata;
	}
	
	public void setWeatherData(WeatherData[] weatherdata){
		this.weatherdata = weatherdata;
	}
	
}
