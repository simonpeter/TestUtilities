/*
 * GuardedString.java
 */

package org.simonpeter.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Test the {@link GuardedString} test utility object.
 * 
 * @author  Simon Peter Chappell
 * @version 20100701
 */
public final class GuardedStringTest {

	@Test public void testAccessors() {
		GuardedString gs = new GuardedString("alphabravo");
		assertEquals("alphabravo", gs.toString());
	}

	@Test public void testNullHandlingWithNulls() {
		GuardedString gs = new GuardedString(null);
		assertTrue(gs.isNull());
	}

	@Test public void testNullHandlingWithNonNulls() {
		GuardedString gs = new GuardedString("alpha");
		assertFalse(gs.isNull());
	}

	@Test public void testEmptyStringHandlingWithEmptyStrings() {
		GuardedString gs = new GuardedString("");
		assertEquals("", gs.toString());
		assertTrue(gs.isEmpty());
	}

	@Test public void testEmptyStringHandlingWithNonEmptyStrings() {
		GuardedString gs = new GuardedString("alpha");
		assertFalse(gs.isEmpty());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testNotNullEnforcementWithNulls() {
		GuardedString gs = new GuardedString(null);
		gs.mustNotBeNull();
	}

	@Test public void testNotNullEnforcementWithNonNulls() {
		GuardedString gs = new GuardedString("alpha");
		gs.mustNotBeNull();
	}

	@Test public void testNullEnforcementWithNulls() {
		GuardedString gs1 = new GuardedString(null);
		gs1.mustBeNull();
	}

	@Test(expected=IllegalArgumentException.class)
	public void testNullEnforcementWithNonNulls() {
		GuardedString gs = new GuardedString("alpha");
		gs.mustBeNull();
	}

	@Test(expected=IllegalArgumentException.class)
	public void testNotBlankEnforcementWithBlanks() {
		GuardedString gs = new GuardedString("");
		gs.mustNotBeBlank();
	}

	@Test public void testNotBlankEnforcementWithNonBlanks() {
		GuardedString gs = new GuardedString("alpha");
		gs.mustNotBeBlank();
	}

	@Test public void testBlankEnforcementWithBlanks() {
		GuardedString gs1 = new GuardedString("");
		gs1.mustBeBlank();
	}

	@Test(expected=IllegalArgumentException.class)
	public void testBlankEnforcementWithNonBlanks() {
		GuardedString gs = new GuardedString("alpha");
		gs.mustBeBlank();
	}

	@Test public void testNotNullOrBlankEnforcementWithNonBlanks() {
		GuardedString gs = new GuardedString("alpha");
		gs.mustNotBeNullOrBlank();
	}

	@Test(expected=IllegalArgumentException.class)
	public void testNotNullOrBlankEnforcementWithBlanks() {
		GuardedString gs = new GuardedString("");
		gs.mustNotBeNullOrBlank();
	}

	@Test(expected=IllegalArgumentException.class)
	public void testNotNullOrBlankEnforcementWithNull() {
		GuardedString gs = new GuardedString(null);
		gs.mustNotBeNullOrBlank();
	}

	@Test public void testRegexEnforcementWithNonBlanks() {
		GuardedString gs = new GuardedString("123");
		gs.mustMatchRegex("[0-9][0-9][0-9]");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testRegexEnforcementWithBadMatch() {
		GuardedString gs = new GuardedString("alpha");
		gs.mustMatchRegex("[0-9][0-9][0-9]");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testRegexEnforcementWithNull() {
		GuardedString gs = new GuardedString(null);
		gs.mustMatchRegex("[0-9][0-9][0-9]");
	}
}