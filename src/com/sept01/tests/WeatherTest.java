package com.sept01.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sept01.model.WeatherStation;

/**
 * <p>
 * A test class that handles the testing of WeatherData in the requirements. The ability to obtain the data
 * , verify its contents and integrity of data are all assessed whether they conform to the standard requirements in the specifications.
 * </p>
 * 
 * @version 1.0
 *
 */
public class WeatherTest {
	@Test
	public void checkifWeatherCreated() {
	String url="http://www.bom.gov.au/products/IDN60801/IDN60801.94596.shtml";	
	String name ="bal";
		WeatherStation weather = new WeatherStation(url,name);
		assertThat(name, is(equalTo(weather.getName())));
	}

}
