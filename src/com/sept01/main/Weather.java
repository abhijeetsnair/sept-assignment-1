package com.sept01.main;
import org.json.JSONArray;
import com.jaunt.*;
public class Weather {
//abbreviations for BOM webscraping
String[] statesAbv = {"vic", "nsw", "tas", "wa", "sa", "nt", "qld", "ant"};
//Array of state objects
State[] states;
 public Weather(){
	 initialize(states);
 }
 
 private boolean initialize(State[] state){
	 //initialize states with abbreviations as name
	 
	for(int i = 0; i < states.length; i++){
		states[i] = new State(statesAbv[i]);
	} 
	 return false;
	 
	 
 }
 
 protected State getStateWeather(String state){
	
	 
	 return null;
	  
 }
 
 
 
}
