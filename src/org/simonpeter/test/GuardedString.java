package org.simonpeter.test;

public final class GuardedString {

	private final String guardedString;

	public GuardedString(String s) {
		if (s == null) {
			guardedString = null;
		} else {
			guardedString = new String(s);
		}
	}

	public final String toString() {
		return guardedString;
	}

	public final boolean isNull() {
		return (guardedString == null);
	}

	public final boolean isEmpty() {
		return ("".equals(guardedString));
	}

	public final GuardedString mustNotBeNull() {
		if (guardedString == null) {
			throw new IllegalArgumentException("Must not be null");
		}
		return this;
	}

	public final GuardedString mustBeNull() {
		if (guardedString != null) {
			throw new IllegalArgumentException("Must be null");
		}
		return this;
	}

	public final GuardedString mustNotBeBlank() {
		if ("".equals(guardedString)) {
			throw new IllegalArgumentException("Must not be blank");
		}
		return this;
	}

	public final GuardedString mustBeBlank() {
		mustNotBeNull();
		if (!("".equals(guardedString))) {
			throw new IllegalArgumentException("Must be blank");
		}
		return this;
	}

	public final GuardedString mustNotBeNullOrBlank() {
		mustNotBeNull();
		mustNotBeBlank();
		return this;
	}

	public final GuardedString mustMatchRegex(String regex) {
		mustNotBeNull();
		if (!(guardedString.matches(regex))) {
			throw new IllegalArgumentException("Match regular expression "+regex);
		}
		return this;
	}
}
