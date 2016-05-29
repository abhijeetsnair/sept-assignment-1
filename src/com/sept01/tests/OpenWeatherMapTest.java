package com.sept01.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import com.sept01.model.Forecaster;
import com.sept01.model.ForecasterFactory;

public class OpenWeatherMapTest {
	/*
	 * COMPREHENSIVE TESTING FOR OPENWEATHER API TESTS 
	 * THE API CALLS FOR DIFFERENT INSTANTIATIONS
	 * 
	 */
	// CREATES AN INSTANCE TO CHECK IF CORRECTLY INSTANTIATED
	@Test
	public void TestCreate() {
		Forecaster owm = ForecasterFactory.getForecaster("openweathermap");
		assertNotNull(owm);
	}

	// TESTS IF THE DATA IS RETRIEVED BY THE CALL
	@Test
	public void TestDownload() {
		Forecaster owm = ForecasterFactory.getForecaster("openweathermap");
		JSONObject data = owm.getForecast(10.00, 10.00);
		assertNotNull(data);
		assertNotNull(data.getJSONArray("forecast"));
	}

	// TESTS IF THE JSON ARRAY IS APPROPRIATELY LOADED 
	@Test
	public void dataSummary() {
		Forecaster owm = ForecasterFactory.getForecaster("openweathermap");
		JSONObject data = owm.getForecast(10.00, 10.00);
		JSONArray forecasts = data.getJSONArray("forecast");
		data = forecasts.getJSONObject(0);
		try {
			assertNotNull(data.get("description"));

		} catch (Exception e) {
			fail();
		}
	}
	/*
	 * 
	 * TESTS  BELOW TESTTHE ELEMENTS OF THE JSON ARRAY
	 */
	@Test
	public void dataTemp() {
		Forecaster owm = ForecasterFactory.getForecaster("openweathermap");
		JSONObject data = owm.getForecast(10.00, 10.00);
		JSONArray forecasts = data.getJSONArray("forecast");
		data = forecasts.getJSONObject(0);
		try {
			assertNotNull(data.get("temp"));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void dataHumid() {
		Forecaster owm = ForecasterFactory.getForecaster("openweathermap");
		JSONObject data = owm.getForecast(10.00, 10.00);
		JSONArray forecasts = data.getJSONArray("forecast");
		data = forecasts.getJSONObject(0);
		try {
			assertNotNull(data.get("humidity"));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void dataSpeed() {
		Forecaster owm = ForecasterFactory.getForecaster("openweathermap");
		JSONObject data = owm.getForecast(10.00, 10.00);
		JSONArray forecasts = data.getJSONArray("forecast");
		data = forecasts.getJSONObject(0);
		try {
			assertNotNull(data.get("speed"));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void dataWinddeg() {
		Forecaster owm = ForecasterFactory.getForecaster("openweathermap");
		JSONObject data = owm.getForecast(10.00, 10.00);
		JSONArray forecasts = data.getJSONArray("forecast");
		data = forecasts.getJSONObject(0);
		try {
			assertNotNull(data.get("winddeg"));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void dataPressure() {
		Forecaster owm = ForecasterFactory.getForecaster("openweathermap");
		JSONObject data = owm.getForecast(10.00, 10.00);
		JSONArray forecasts = data.getJSONArray("forecast");
		data = forecasts.getJSONObject(0);
		try {
			assertNotNull(data.get("pressure"));
		} catch (Exception e) {
			fail();
		}
	}
// Rain is not in the data downloaded
//	@Test
//	public void dataRain() {
//		Forecaster owm = ForecasterFactory.getForecaster("openweathermap");
//		JSONObject data = owm.getForecast(10.00, 10.00);
//		JSONArray forecasts = data.getJSONArray("forecast");
//		data = forecasts.getJSONObject(0);
//		try {
//			assertNotNull(data.get("rain"));
//		} catch (Exception e) {
//			fail();
//		}
//	}

}
