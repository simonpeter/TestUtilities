package org.simonpeter.test;


/**
 * A wrapper for certain methods of the System class to better
 * facilitate unit testing.
 * 
 * @author  Simon Peter Chappell
 * @Version June 2010
 */
public class Environment {

	private static boolean inTestMode = false;

	public static void setTestMode(boolean testModeRequested) {
		inTestMode = testModeRequested;
	}
	
	public static long currentTimeMillis() {
		long now;
		if (inTestMode) {
			now = 1234567890123L;
		} else {
			now = System.currentTimeMillis();
		}
		return now;
	}
}
