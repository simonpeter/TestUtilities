/*
 * GuardedIntegerTest.java
 */

package org.simonpeter.test;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class GuardedIntegerTest {

	@Test public void testAccessors() {
		GuardedInteger gi = new GuardedInteger(23);
		assertEquals("23", gi.toString());
	}

	@Test public void testConstructorWithString() {
		GuardedInteger gi = new GuardedInteger("23");
		assertEquals("23", gi.toString());
	}

	@Test public void testZeroHandlingWithZeroData() {
		GuardedInteger gi = new GuardedInteger(0);
		assertTrue(gi.isZero());
		assertFalse(gi.isNotZero());
	}

	@Test public void testZeroHandlingWithNonZeroData() {
		GuardedInteger gi = new GuardedInteger(23);
		assertFalse(gi.isZero());
		assertTrue(gi.isNotZero());
	}

	@Test public void testNegativePositiveTestingWithPositiveData() {
		GuardedInteger gi = new GuardedInteger(23);
		assertTrue(gi.isPositive());
		assertFalse(gi.isNegative());
	}

	@Test public void testNegativePositiveTestingWithNegativeData() {
		GuardedInteger gi = new GuardedInteger(-1);
		assertFalse(gi.isPositive());
		assertTrue(gi.isNegative());
	}

	@Test public void testNegativePositiveTestingWithZeroData() {
		GuardedInteger gi = new GuardedInteger(0);
		assertTrue(gi.isPositive());
		assertFalse(gi.isNegative());
	}

	@Test public void testIsLessThan() {
		GuardedInteger gi = new GuardedInteger(23);
		assertTrue(gi.isLessThan(50));
		assertFalse(gi.isLessThan(1));
		assertFalse(gi.isLessThan(23));
	}

	@Test public void testIsGreaterThan() {
		GuardedInteger gi = new GuardedInteger(23);
		assertFalse(gi.isGreaterThan(50));
		assertTrue(gi.isGreaterThan(1));
		assertFalse(gi.isGreaterThan(23));
	}

	@Test public void testIsLessThanOrEqualTo() {
		GuardedInteger gi = new GuardedInteger(23);
		assertTrue(gi.isLessThanOrEqualTo(50));
		assertFalse(gi.isLessThanOrEqualTo(1));
		assertTrue(gi.isLessThanOrEqualTo(23));
	}

	@Test public void testIsGreaterThanOrEqualTo() {
		GuardedInteger gi = new GuardedInteger(23);
		assertFalse(gi.isGreaterThanOrEqualTo(50));
		assertTrue(gi.isGreaterThanOrEqualTo(1));
		assertTrue(gi.isGreaterThanOrEqualTo(23));
	}

	@Test public void testIsInRangeInclusive() {
		GuardedInteger gi = new GuardedInteger(23);
		assertTrue(gi.isInRangeInclusive(20, 30));
		assertTrue(gi.isInRangeInclusive(30, 20));
		assertFalse(gi.isInRangeInclusive(10, 20));
		assertFalse(gi.isInRangeInclusive(30, 40));
		assertTrue(gi.isInRangeInclusive(23, 30));
		assertTrue(gi.isInRangeInclusive(20, 23));
	}

	@Test public void testIsInRangeExclusive() {
		GuardedInteger gi = new GuardedInteger(23);
		assertTrue(gi.isInRangeExclusive(20, 30));
		assertTrue(gi.isInRangeExclusive(30, 20));
		assertFalse(gi.isInRangeExclusive(10, 20));
		assertFalse(gi.isInRangeExclusive(30, 40));
		assertFalse(gi.isInRangeExclusive(23, 30));
		assertFalse(gi.isInRangeExclusive(20, 23));
	}

	@Test public void testIsNotInRangeInclusive() {
		GuardedInteger gi = new GuardedInteger(23);
		assertFalse(gi.isNotInRangeInclusive(20, 30));
		assertFalse(gi.isNotInRangeInclusive(30, 20));
		assertTrue(gi.isNotInRangeInclusive(10, 20));
		assertTrue(gi.isNotInRangeInclusive(30, 40));
		assertFalse(gi.isNotInRangeInclusive(23, 30));
		assertFalse(gi.isNotInRangeInclusive(20, 23));
	}

	@Test public void testIsNotInRangeExclusive() {
		GuardedInteger gi = new GuardedInteger(23);
		assertFalse(gi.isNotInRangeExclusive(20, 30));
		assertFalse(gi.isNotInRangeExclusive(30, 20));
		assertTrue(gi.isNotInRangeExclusive(10, 20));
		assertTrue(gi.isNotInRangeExclusive(30, 40));
		assertTrue(gi.isNotInRangeExclusive(23, 30));
		assertTrue(gi.isNotInRangeExclusive(20, 23));
	}

	@Test public void testMustNotBeZeroWithNonZero() {
		GuardedInteger gi = new GuardedInteger(23);
		gi.mustNotBeZero();
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMustNotBeZeroWithZero() {
		GuardedInteger gi = new GuardedInteger(0);
		gi.mustNotBeZero();
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMustBeZeroWithNonZero() {
		GuardedInteger gi = new GuardedInteger(23);
		gi.mustBeZero();
	}

	@Test public void testMustBeZeroWithZero() {
		GuardedInteger gi = new GuardedInteger(0);
		gi.mustBeZero();
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMustNotEqualWithEqual() {
		GuardedInteger gi = new GuardedInteger(23);
		gi.mustNotEqual(23);
	}

	@Test public void testMustNotEqualWithNotEqual() {
		GuardedInteger gi = new GuardedInteger(23);
		gi.mustNotEqual(17);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMustBeLessThanWithMore() {
		GuardedInteger gi = new GuardedInteger(23);
		gi.mustBeLessThan(17);
	}

	@Test public void testMustBeLessThanWithLess() {
		GuardedInteger gi = new GuardedInteger(17);
		gi.mustBeLessThan(23);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMustFallOutsideRangeInclusiveWithInRange() {
		GuardedInteger gi = new GuardedInteger(23);
		gi.mustFallOutsideRangeInclusive(20, 30);
	}

	@Test public void testMustFallOutsideRangeInclusiveWithOutsideRange() {
		GuardedInteger gi = new GuardedInteger(23);
		gi.mustFallOutsideRangeInclusive(10, 20);
	}
}
