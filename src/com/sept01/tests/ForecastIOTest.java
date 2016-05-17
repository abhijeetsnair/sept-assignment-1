package com.sept01.tests;

import static org.junit.Assert.*;

import java.util.HashMap;import org.hamcrest.core.Is;
import org.junit.Test;

import com.sept01.model.Forecaster;
import com.sept01.model.ForecasterFactory;

public class ForecastIOTest
{
   Forecaster f = ForecasterFactory.getForecaster("forecastio");

   @Test
   public void downloadData()
   {
      HashMap<String, Object> data = f.getHourly();
      assertNotNull(data);
   }
   @Test
   public void summary()
   {
      HashMap<String, Object> data = f.getHourly();
      assertNotNull(data.get("summary"));    
      
   }
   @Test
   public void data()
   {
      HashMap<String, Object> data = f.getHourly();
      assertNotNull(data.get("data"));    
      
   }

}
