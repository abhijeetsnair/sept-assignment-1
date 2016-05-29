package com.sept01.tests;

import static org.junit.Assert.assertNotNull;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import com.sept01.model.Forecaster;
import com.sept01.model.ForecasterFactory;

public class ForecastIOTest {

	Forecaster f = ForecasterFactory.getForecaster("forecastio");

	@Test
	public void TestCreate() {
		Forecaster fio = ForecasterFactory.getForecaster("forecastio");
		assertNotNull(fio);
	}

	@Test
	public void downloadData() {
		JSONObject data = f.getForecast(10.00, 10.00);
		assertNotNull(data);
	}

	@Test
	public void data() {
		JSONObject data = f.getForecast(10.00, 10.00);
		JSONArray forecasts = data.getJSONArray("forecast");
		assertNotNull(forecasts);
	}

	@Test
	public void dataSummary() {
		JSONObject data = f.getForecast(10.00, 10.00);
		JSONArray forecasts = data.getJSONArray("forecast");
		data = forecasts.getJSONObject(0);
		assertNotNull(data.get("description"));
	}

	@Test
	public void dataTemp() {
		JSONObject data = f.getForecast(10.00, 10.00);
		JSONArray forecasts = data.getJSONArray("forecast");
		data = forecasts.getJSONObject(0);
		assertNotNull(data.get("temp"));
	}

	@Test
	public void dataHumid() {
		JSONObject data = f.getForecast(10.00, 10.00);
		JSONArray forecasts = data.getJSONArray("forecast");
		data = forecasts.getJSONObject(0);
		assertNotNull(data.get("humidity"));
	}

	@Test
	public void dataSpeed() {
		JSONObject data = f.getForecast(10.00, 10.00);
		JSONArray forecasts = data.getJSONArray("forecast");
		data = forecasts.getJSONObject(0);
		assertNotNull(data.get("speed"));
	}

	@Test
	public void dataWinddeg() {
		JSONObject data = f.getForecast(10.00, 10.00);
		JSONArray forecasts = data.getJSONArray("forecast");
		data = forecasts.getJSONObject(0);
		assertNotNull(data.get("winddeg"));
	}

	@Test
	public void dataPressure() {
		JSONObject data = f.getForecast(10.00, 10.00);
		JSONArray forecasts = data.getJSONArray("forecast");
		data = forecasts.getJSONObject(0);
		assertNotNull(data.get("pressure"));
	}

	@Test
	public void dataRain() {
		JSONObject data = f.getForecast(10.00, 10.00);
		JSONArray forecasts = data.getJSONArray("forecast");
		data = forecasts.getJSONObject(0);
		assertNotNull(data.get("rain"));
	}

}
