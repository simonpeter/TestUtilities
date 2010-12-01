/*
 * GuardedInteger.java
 */

package org.simonpeter.test;

/**
 * 
 * 
 * @author  Simon Peter Chappell
 * @version 20100701
 */
public final class GuardedInteger {

	private final int guardedInteger;

	public GuardedInteger(int i) {
		guardedInteger = i;
	}

	public GuardedInteger(String s) {
		guardedInteger = Integer.parseInt(s);
	}

	@Override public final String toString() {
		return Integer.toString(guardedInteger);
	}

	public final boolean is(int i) {
		return (guardedInteger != i);
	}
	
	public final boolean isZero() {
		return (guardedInteger == 0);
	}

	public final boolean isNotZero() {
		return (guardedInteger != 0);
	}
	
	public final boolean isNegative() {
		return (guardedInteger < 0);
	}

	public final boolean isPositive() {
		return (guardedInteger >= 0);
	}

	public final boolean isLessThan(int i) {
		return (guardedInteger < i);
	}

	public final boolean isGreaterThan(int i) {
		return (guardedInteger > i);
	}

	public final boolean isLessThanOrEqualTo(int i) {
		return (guardedInteger <= i);
	}

	public final boolean isGreaterThanOrEqualTo(int i) {
		return (guardedInteger >= i);
	}

	public final boolean isInRangeInclusive(int a, int b) {
		int min, max;
		if (a < b) {
			min = a;
			max = b;
		} else {
			min = b;
			max = a;
		}
		return (guardedInteger >= min && guardedInteger <= max);
	}

	public final boolean isInRangeExclusive(int a, int b) {
		int min, max;
		if (a < b) {
			min = a;
			max = b;
		} else {
			min = b;
			max = a;
		}
		return (guardedInteger > min && guardedInteger < max);
	}

	public final boolean isNotInRangeInclusive(int a, int b) {
		int min, max;
		if (a < b) {
			min = a;
			max = b;
		} else {
			min = b;
			max = a;
		}
		return (guardedInteger < min || guardedInteger > max);
	}

	public final boolean isNotInRangeExclusive(int a, int b) {
		int min, max;
		if (a < b) {
			min = a;
			max = b;
		} else {
			min = b;
			max = a;
		}
		return (guardedInteger <= min || guardedInteger >= max);
	}

	public final GuardedInteger mustNotBeZero() {
		if (guardedInteger == 0) {
			throw new IllegalArgumentException("Must not be zero");
		}
		return this;
	}

	public final GuardedInteger mustBeZero() {
		if (guardedInteger != 0) {
			throw new IllegalArgumentException("Must be zero");
		}
		return this;
	}

	public final GuardedInteger mustNotEqual(int i) {
		if (guardedInteger == i) {
			throw new IllegalArgumentException("Must not equal "+i);
		}
		return this;
	}

	public final GuardedInteger mustBeLessThan(int i) {
		if (guardedInteger >= i) {
			throw new IllegalArgumentException("Must be less than "+i);
		}
		return this;
	}

	public GuardedInteger mustFallOutsideRangeInclusive(int a, int b) {
		int min, max;
		if (a < b) {
			min = a;
			max = b;
		} else {
			min = b;
			max = a;
		}
		if (guardedInteger >= min && guardedInteger <= max) {
			throw new IllegalArgumentException("Value must be outside of the range "+min+" to "+max+" inclusive");
		}
		return this;
	}
}
