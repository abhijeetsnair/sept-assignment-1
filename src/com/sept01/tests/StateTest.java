package com.sept01.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sept01.main.State;

public class StateTest {
	@Test
	public void checkifStateCreated() {
	String name ="Wharton";
		State state = new State(name);
		assertThat(name, is(equalTo(state.getName())));
	}

	
}
