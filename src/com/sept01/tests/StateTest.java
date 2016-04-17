package com.sept01.tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.sept01.model.State;

/**
 * <p>
 * A test class that handles the testing of State (actual program state, not States of Australia)
 * .
 * </p>
 * 
 * @version 1.0
 *
 */
public class StateTest {
	@Test
	public void checkifStateCreated() {
	String name ="vic";
		State state = new State(name);
		assertThat(name.toLowerCase(), is(equalTo(state.getName().toLowerCase())));
	}

	
}
