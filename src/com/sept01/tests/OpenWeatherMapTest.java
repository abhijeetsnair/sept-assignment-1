package com.sept01.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.json.JSONArray;
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
	public void TestDownload() {
		Forecaster owm = ForecasterFactory.getForecaster("openweathermap");
		JSONObject data = owm.getForecast(10.00, 10.00);
		assertNotNull(data);
		assertNotNull(data.getJSONArray("forecast"));
	}

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

	@Test
	public void dataRain() {
		Forecaster owm = ForecasterFactory.getForecaster("openweathermap");
		JSONObject data = owm.getForecast(10.00, 10.00);
		JSONArray forecasts = data.getJSONArray("forecast");
		data = forecasts.getJSONObject(0);
		try {
			assertNotNull(data.get("rain"));
		} catch (Exception e) {
			fail();
		}
	}

}
