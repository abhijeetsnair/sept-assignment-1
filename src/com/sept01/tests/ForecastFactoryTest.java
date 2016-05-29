package com.sept01.tests;

import static org.junit.Assert.*;
import org.junit.Test;
import com.sept01.model.Forecaster;
import com.sept01.model.ForecasterFactory;

public class ForecastFactoryTest
{
	// Tests the factory implementation for the Forecast Factory
   @Test
   public void forecastIO()
   {	// tests if the forecastIO instantiates correctly
      Forecaster f = ForecasterFactory.getForecaster("forecastio");
      assertNotNull(f);
   }
   @Test
   public void openweather()
   {// tests if the openweathermap instantiates correctly
      Forecaster f = ForecasterFactory.getForecaster("openweathermap");
      assertNotNull(f);
   }

}
