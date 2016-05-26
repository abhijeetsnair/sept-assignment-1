package com.sept01.tests;

import static org.junit.Assert.*;

import java.util.HashMap;import org.hamcrest.core.Is;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import com.sept01.model.Forecaster;
import com.sept01.model.ForecasterFactory;

public class ForecastIOTest
{
	
   Forecaster f = ForecasterFactory.getForecaster("forecastio");

   @Test
   public void TestCreate(){
	   Forecaster fio = ForecasterFactory.getForecaster("forecastio");  
	   assertNotNull(fio);
   }
   @Test
   public void downloadData()
   {
      JSONObject data = f.getForecast(10.00, 10.00);
      assertNotNull(data);
   }
   @Test
   public void data()
   {
	   JSONObject data = f.getForecast(10.00, 10.00);
	   JSONArray forecasts = data.getJSONArray("forecast");
      assertNotNull(forecasts);    
      
   }

}
