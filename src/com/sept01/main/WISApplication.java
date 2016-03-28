package com.sept01.main;

import java.util.HashMap;

public class WISApplication {
static Weather weather;
 public static void main (String[] args){
    System.out.println("Hello");
    System.out.println(" :D ");
    initializeWeather();
    
    
 }
 
 public static void initializeWeather(){
	weather = new Weather();
	HashMap[] weatherD = weather.states[0].areas.get(0).weatherStations.get(0).getData();
	System.out.println(weatherD[0].get("wind_spd_kmh"));
	
//	System.out.println(weather.states[0].areas.get(1).getName());
//	for(int i = 0; i < weather.states.length ; i++){
//	   System.out.println(weather.states[i].name);
//	}
	
	 
 }
 
 public void showInfo(){
	 return;
 }
 
 public void storeFav(){
	 return;
 }
 
 public void updateView(){
	 return;
 }
 
 public void refreshView(){
	 return;
 }
 
 public void adjustWindow(){
	 return;
 }
 
 public void reportError(){
	 
 }
 
 private void getUser(){
	 return;
 }
 
 private void getInto(State state){
	 return;
 }
 
}
