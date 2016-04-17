package com.sept01.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.jsoup.select.Elements;
import org.junit.Test;

import com.sept01.model.Area;

/**
 * <p>
 * A test class that handles the testing of Areas and that data contained within the Areas, assessing
 * whether they conform to the standard requirements in the specifications.
 * </p>
 * 
 * @version 1.0
 *
 */
public class AreaTest {
	@Test
	public void checkifAreaCreated() {
	
		String name ="Wharton";
		String id="bh094";
		Elements elements = null;
		Area area  = new Area(name,id,elements);	
		assertThat(name, is(equalTo(area.getName())));
		assertThat(id, is(equalTo(area.getId())));		
	
	}

}
