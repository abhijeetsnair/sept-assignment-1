package com.sept01.main;

public class WISApplication {
 public static void main (String[] args){
    System.out.println("Hello");
    System.out.println(" :D ");
    initializeWeather();
    
    
 }
 
 public static void initializeWeather(){
	Weather weather = new Weather();
	System.out.println(weather.states[0].areas.get(1).getName());
	for(int i = 0; i < weather.states.length ; i++){
	   System.out.println(weather.states[i].name);
	}
	
	 
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
