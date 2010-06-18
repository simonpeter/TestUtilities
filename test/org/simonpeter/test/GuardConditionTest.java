/*
 * GuardConditionTest.java
 */

package org.simonpeter.test;

import org.junit.Test;

/**
 * 
 * @author  Simon Peter Chappell
 * @version 20100617
 */
public class GuardConditionTest {

	@Test
	public void testMustBeTrueWithTrue() {
		GuardCondition.mustBeTrue(true);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMustBeTrueWithFalse() {
		GuardCondition.mustBeTrue(false);
	}

	@Test
	public void testMustBeFalseWithFalse() {
		GuardCondition.mustBeFalse(false);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMustBeFalseWithTrue() {
		GuardCondition.mustBeFalse(true);
	}

	@Test
	public void testMustBeNullWithNull() {
		GuardCondition.mustBeNull(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMustBeNullWithNonNull() {
		GuardCondition.mustBeNull(new Object());
	}

	@Test
	public void testMustNotBeNullWithNonNull() {
		GuardCondition.mustNotBeNull(new Object());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMustNotBeNullWithNull() {
		GuardCondition.mustNotBeNull(null);
	}

	@Test
	public void testMustNotBeNegativeWithPositiveInteger() {
		GuardCondition.mustNotBeNegative(42);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMustNotBeNegativeWithNegativeInteger() {
		GuardCondition.mustNotBeNegative(-42);
	}

	@Test
	public void testMustNotBeEmptyStringWithValidString() {
		GuardCondition.mustNotBeEmptyString("alpha");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMustNotBeEmptyStringWithEmptyString() {
		GuardCondition.mustNotBeEmptyString("");
	}

	@Test
	public void testMustNotBeEmptyStringWithNull() {
		GuardCondition.mustNotBeEmptyString(null);
	}

	@Test
	public void testMustBeAStringWithAString() {
		GuardCondition.mustBeAString("bravo");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMustBeAStringWithANonString() {
		GuardCondition.mustBeAString(new Object());
	}

	@Test
	public void testMustMatchRegexWithMatchingData() {
		GuardCondition.mustMatchRegex("123", "[0-9][0-9][0-9]");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMustMatchRegexWithNonMatchingData() {
		GuardCondition.mustMatchRegex("ABC", "[0-9][0-9][0-9]");
	}

	@Test
	public void testMustFallInsideRangeInclusiveWithPassingData() {
		GuardCondition.mustFallInsideRangeInclusive(123L, 1L, 1000L);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMustFallInsideRangeInclusiveWithFailingData() {
		GuardCondition.mustFallInsideRangeInclusive(123L, 1L, 10L);
	}

	@Test
	public void testMustBeLessThanWithPassingData() {
		GuardCondition.mustBeLessThan(123L, 1000L);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMustBeLessThanWithFailingData() {
		GuardCondition.mustBeLessThan(123L, 1L);
	}

	@Test
	public void testMustBeMoreThanWithPassingData() {
		GuardCondition.mustBeMoreThan(123L, 10L);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMustBeMoreThanWithFailingData() {
		GuardCondition.mustBeMoreThan(123L, 1000L);
	}

	@Test
	public void testMustFallOutsideRangeInclusiveWithPassingData() {
		GuardCondition.mustFallOutsideRangeInclusive(123L, 1L, 10L);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMustFallOutsideRangeInclusiveWithFailingData() {
		GuardCondition.mustFallOutsideRangeInclusive(123L, 1L, 1000L);
	}

	@Test
	public void testMustNotBeZeroWithPassingData() {
		GuardCondition.mustNotBeZero(42L);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMustNotBeZeroWithFailingData() {
		GuardCondition.mustNotBeZero(0L);
	}

	@Test
	public void testMustNotBeEqualWithPassingData() {
		GuardCondition.mustNotBeEqual(42L, 123L);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMustNotBeEqualWithFailingData() {
		GuardCondition.mustNotBeEqual(42L, 42L);
	}
}
