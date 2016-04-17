package com.sept01.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sept01.model.WeatherStation;

public class WeatherTest {
	@Test
	public void checkifWeatherCreated() {
	String url="https://septgroupteam.slack.com/messages/general/team/jeet/";	
	String name ="Wharton";
		WeatherStation weather = new WeatherStation(url,name);
		assertThat(name, is(equalTo(weather.getName())));
	}

}
