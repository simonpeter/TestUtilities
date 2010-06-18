/*
 * GuardCondition.java
 */

package org.simonpeter.test;


/**
 * 
 * @author  Simon Peter Chappell
 * @version 20100509
 */
public abstract class GuardCondition {

	public static void mustBeTrue(boolean flag) {
		if (flag == false) {
			throw new IllegalArgumentException("Value must be true");
		}
	}

	public static void mustBeFalse(boolean flag) {
		if (flag == true) {
			throw new IllegalArgumentException("Value must be false");
		}
	}

	public static void mustBeNull(Object obj) {
		if (obj != null) {
			throw new IllegalArgumentException("Value must be null");
		}
	}

	public static void mustNotBeNull(Object obj) {
		if (obj == null) {
			throw new IllegalArgumentException("Value must not be null");
		}
	}

	public static void mustNotBeNegative(long n) {
		if (n < 0) {
			throw new IllegalArgumentException("Value must not be negative");
		}
	}

	public static void mustNotBeEmptyString(String s) {
		if ("".equals(s)) {
			throw new IllegalArgumentException("Value must not be empty string");
		}
	}

	public static void mustBeAString(Object obj) {
		if (!(obj instanceof String)) {
			throw new IllegalArgumentException("Value must be of type string");
		}
	}

	public static void mustMatchRegex(String s, String regex) {
		if (!(s.matches(regex))) {
			throw new IllegalArgumentException("Value must match regular expression "+regex);
		}
	}

	public static void mustFallInsideRangeInclusive(long value, long lowerBound, long upperBound) {
		if (!(value >= lowerBound && value <= upperBound)) {
			throw new IllegalArgumentException("Value must be between upper and lower bound inclusive");
		}
	}

	public static void mustBeLessThan(long value, long pivot) {
		if (value >= pivot) {
			throw new IllegalArgumentException("Value must be less than supplied pivot");
		}
	}

	public static void mustBeMoreThan(long value, long pivot) {
		if (value <= pivot) {
			throw new IllegalArgumentException("Value must be more than supplied pivot");
		}
	}

	public static void mustFallOutsideRangeInclusive(long value, long lowerBound, long upperBound) {
		if (value >= lowerBound && value <= upperBound) {
			throw new IllegalArgumentException("Value must be outside of the range lower to upper bound inclusive");
		}
	}

	public static void mustNotBeZero(long n) {
		if (n == 0) {
			throw new IllegalArgumentException("Value must not be zero");
		}
	}

	public static void mustNotBeEqual(long n1, long n2) {
		if (n1 == n2) {
			throw new IllegalArgumentException("Values must not be equal");
		}
	}
}
