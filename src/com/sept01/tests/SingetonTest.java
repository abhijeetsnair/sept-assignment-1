package com.sept01.tests;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import com.sept01.main.WISApplication;
import com.sept01.model.Singleton;
import com.sept01.model.Weather;

/** Checking if no two instances of the same class are created */
public class SingetonTest {
	@Test
	public void checkifSingletoninstanceSame() {
		Singleton ins = Singleton.getInstance();
		Singleton ins2 = Singleton.getInstance();
		assertSame(ins, ins2);

	}

	@Test
	public void checkifWISinstanceSame() {
		WISApplication application = new WISApplication();
		Singleton.getInstance().setApplication(application);
		assertSame(application, Singleton.getInstance().getApplication());

	}

	@Test
	public void checkifWeatherinstanceSame() {
		Weather weather = new Weather();
		Singleton.getInstance().setWeather(weather);
		assertSame(weather, Singleton.getInstance().getWeather());

	}

	@Test
	public void checkiflocationSame() {
		int value = 0;
		int xloc = Singleton.getInstance().getXloc();
		int yloc = Singleton.getInstance().getYloc();
		assertSame(value, xloc);
		assertSame(value, yloc);

	}
	@Test
	public void checkifForecastInitialised() {
		int value = -1;
		int source = Singleton.getInstance().source;
		assertSame(value, source);

	}
}