package com.sept01.tests;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;

import com.sept01.model.Forecaster;
import com.sept01.model.ForecasterFactory;

public class OpenWeatherMapTest {

	@Test
	public void TestCreate() {
		Forecaster owm = ForecasterFactory.getForecaster("openweathermap");
		assertNotNull(owm);
	}
	@Test
	public void TestDownload(){
		Forecaster owm = ForecasterFactory.getForecaster("openweathermap");
		JSONObject data = owm.getForecast(10.00, 10.00);
		assertNotNull(data);
		assertNotNull(data.getJSONArray("forecast"));
	}

}
