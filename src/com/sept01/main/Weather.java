/*
 * MAIN weather class
 * this class its the access point for all weather data
 * when a weather object is created it will create object for all states,area and
 * weather stations.
 * 
 */

package com.sept01.main;
import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import org.jsoup.Jsoup;
public class Weather {
//abbreviations for BOM web scraping
private String[] statesAbv = {"vic", "nsw", "tas", "wa", "sa", "nt", "qld", "ant"};
private HashMap<String, State> states = new HashMap<String, State>();
//Array of state objects
 public Weather(){
	 initialize(states);
 }
 

private boolean initialize(HashMap<String, State> states){
	 //initialize states with abbreviations as name
	int perDone;
	System.out.println("Loading classes please wait");
	//LOADING SCREEN
	JWindow window = new JWindow();
	window.getContentPane().setBackground(Color.decode("#003366"));
	JLabel Loading_label = new JLabel("LOADING", SwingConstants.CENTER);
	Loading_label.setForeground(Color.WHITE);
	window.getContentPane().add(
			Loading_label);
	window.setBounds(500, 150, 300, 200);
	window.setLocationRelativeTo(null);
	window.setVisible(true);
	//Checks if BOM is online if not quit application
	if(!checkConnection("http://www.bom.gov.au/", Loading_label)){
		System.exit(0);
	}
	// populate states
	// this will create all classes for the data
	for(int i = 0; i < statesAbv.length; i++){
		
		states.put(statesAbv[i],new State(statesAbv[i]));
		perDone = (int) (((float)i)/((float)statesAbv.length) * 100);
		System.out.println(perDone + "% done");
		Loading_label.setText("LOADING: "+perDone + "%");
	}

	
	System.out.println(100 + "% done");
	window.setVisible(false);
	window.dispose();

	 return true;
	 
	 
 }
 
 public State getStateWeather(String state){
	 return states.get(state);
	  
 }
 protected String[] getStateNames(){
	 
	 return statesAbv;
 }
 
 public boolean checkConnection(String url,JLabel Loading_label){
		try {
			Jsoup.connect(url).get();
			return true;
		} catch (IOException e) {
			Loading_label.setText("Cannot connect to "+url+" retrying");
			try {
				Thread.sleep(5000);
				try {
					Jsoup.connect(url).get();
					return true;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					Loading_label.setText("Cannot connect to "+url+" quiting");
					return false;
				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		return true;
	
	 
	 
 }
 public boolean checkConnection(String url){
		try {
			Jsoup.connect(url).get();
			return true;
		} catch (IOException e) {
	
			try {
				Thread.sleep(5000);
				try {
					Jsoup.connect(url).get();
					return true;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					return false;
				}
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		return true;
	
	 
	 
}
 
 
}
