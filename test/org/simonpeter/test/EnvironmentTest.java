/*
 * EnvironmentTest.java
 */

package org.simonpeter.test;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author  Simon Peter Chappell
 * @version 20100617
 */
public class EnvironmentTest {

	@Test public void testCurrentTimeMillisInTestMode() {
		Environment.setTestMode(true);
		long time = Environment.currentTimeMillis();
		assertEquals(1234567890123L, time);
	}
	
	@Test public void testCurrentTimeMillisInProductionMode() {
		Environment.setTestMode(false);
		long time = Environment.currentTimeMillis();
		assertTrue(time > 1234567890123L);
	}
	
}
