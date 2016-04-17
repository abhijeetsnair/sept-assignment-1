package com.sept01.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.jsoup.select.Elements;
import org.junit.Test;

import com.sept01.model.Area;

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
