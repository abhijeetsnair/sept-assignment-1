/*
 * MAIN weather class
 * this class its the access point for all weather data
 * when a weather object is created it will create object for all states,area and
 * weather stations.
 * 
 */

package com.sept01.main;
import java.util.HashMap;

import org.json.JSONArray;
public class Weather {
//abbreviations for BOM web scraping
private String[] statesAbv = {"vic", "nsw", "tas", "wa", "sa", "nt", "qld", "ant"};
private HashMap<String, State> states = new HashMap<String, State>();
//Array of state objects
 public Weather(){
	 initialize(states);
 }
 
 private boolean initialize(HashMap states){
	 //initialize states with abbreviations as name
	int perDone;
	System.out.println("Loading classes please wait");
	// populate states
	// this will create all classes for the data
	for(int i = 0; i < statesAbv.length; i++){
		
		states.put(statesAbv[i],new State(statesAbv[i]));
		perDone = (int) (((float)i)/((float)statesAbv.length) * 100);
		System.out.println(perDone + "% done");
	}
	System.out.println(100 + "% done");

	 return true;
	 
	 
 }
 
 public State getStateWeather(String state){
	 return states.get(state);
	  
 }
 protected String[] getStateNames(){
	 
	 return statesAbv;
 }
 
 
 
}
