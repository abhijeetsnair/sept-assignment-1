package com.sept01.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.sept01.model.Forecaster;
import com.sept01.model.ForecasterFactory;

public class ForecastFactoryTest
{

   @Test
   public void forecastIO()
   {
      Forecaster f = ForecasterFactory.getForecaster("forecastio");
      assertNotNull(f);
   }
   @Test
   public void openweather()
   {
      Forecaster f = ForecasterFactory.getForecaster("openweathermap");
      assertNotNull(f);
   }

}
