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


/**
 * <p>
 * A test class that handles the testing of Datas such as the states and the arealoc, assessing
 * whether they conform to the standard requirements in the specifications.
 * </p>
 * 
 * @version 1.0
 *
 */
public class DataTest {

	Weather weather;
	private String[] statesAbv = { "vic", "nsw", "tas", "wa", "sa", "nt", "qld", "ant","act" };
	public DataTest(){
		WISApplication.initializeWeather();
		weather = WISApplication.weather;
	}
	@Test
	public void checkAreasNotNull(){
			State state = weather.getStateWeather("vic");
			ArrayList<Area> area = state.getAreas();
			assertNotNull(area);
	}
	@Test
	public void checkifAreaCreated() {
		
		State state = weather.getStateWeather("vic");
		ArrayList<Area> area = state.getAreas();
		area.get(1).getWeatherStations().get(1).getData();
		if(WISApplication.debug == true){
			System.out.println(area.get(1).getWeatherStations().get(1).getStateName());
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
	public void testGotStates() {
		for(String staten : statesAbv ){
			State state = weather.getStateWeather(staten);
			assertEquals(staten,state.getName());
		}
	}


}
