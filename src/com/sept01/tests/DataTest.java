/**
 * 
 */
package com.sept01.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

import com.sept01.main.WISApplication;
import com.sept01.model.Area;
import com.sept01.model.State;
import com.sept01.model.Weather;
import com.sept01.model.WeatherStation;

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
	@Test
	public void checkAreasNotNull(){
			State state = weather.getStateWeather("vic");
			ArrayList<Area> area = state.getAreas();
			assertNotNull(area);
	}


}
