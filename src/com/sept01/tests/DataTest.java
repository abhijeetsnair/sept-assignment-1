/**
 * 
 */
package com.sept01.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import com.sept01.main.State;
import com.sept01.main.WISApplication;
import com.sept01.main.Weather;
import com.sept01.main.WeatherStation;
import com.sun.org.apache.xpath.internal.operations.Equals;
import com.sept01.main.Area;
import org.junit.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;


public class DataTest {

	Weather weather;
	public DataTest(){
		WISApplication.initializeWeather();
		weather = WISApplication.weather;
	}
	private String[] statesAbv = { "vic", "nsw", "tas", "wa", "sa", "nt", "qld", "ant","act" };
	@Test
	public void testGotStates() {
		for(String staten : statesAbv ){
			State state = weather.getStateWeather(staten);
			assertEquals(staten,state.getName());
		}
	}
	@Test
	public void checkWeatherStation(){
		for(String staten : statesAbv ){
			State state = weather.getStateWeather(staten);
			ArrayList<Area> area = state.getAreas();
			for( Area ar : area){
				ArrayList<WeatherStation> ws = ar.getWeatherStations();
				for(WeatherStation station : ws){
					if(station.getName().toLowerCase().compareTo("melbourne airport") == 0){
						station.getData();
						assertThat("vic", is(equalTo(station.getStateAbv().toLowerCase())));
					}
				}
			}
		}
	
	}


}
