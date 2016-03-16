package com.sept01.main;
import org.json.JSONArray;
import com.jaunt.*;
public class Weather {
//abbreviations for BOM web scraping
String[] statesAbv = {"vic", "nsw", "tas", "wa", "sa", "nt", "qld", "ant"};
//Array of state objects
State[] states = new State[statesAbv.length];
 public Weather(){
	 initialize(states);
 }
 
 private boolean initialize(State[] state){
	 //initialize states with abbreviations as name
	 
	for(int i = 0; i < statesAbv.length; i++){
		states[i] = new State(statesAbv[i]);
	} 
	 return false;
	 
	 
 }
 
 protected State getStateWeather(String state){
	
	 
	 return null;
	  
 }
 
 
 
}
