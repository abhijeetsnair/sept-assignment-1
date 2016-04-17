package com.sept01.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sept01.model.State;

public class StateTest {
	@Test
	public void checkifStateCreated() {
	String name ="vic";
		State state = new State(name);
		assertThat(name.toLowerCase(), is(equalTo(state.getName().toLowerCase())));
	}

	
}
