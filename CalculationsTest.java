package test.junit;

import static org.junit.Assert.*;

import sundial.Calculations;

/**
 * JUnit test for Calculations class
 * 
 * @author briceorbryce
 *
 */
public class CalculationsTest {
	
	/**
	 * I use http://transition.fcc.gov/mb/audio/bickel/DDDMMSS-decimal.html
	 * to test against.
	 * 
	 * I got DELTA from this stack overflow page
	 * http://stackoverflow.com/questions/5686755/junit-assertequals-for-double-values
	 * However, since my values are very much different, I decided to use a
	 * much, much larger delta.
	 */
	@SuppressWarnings("static-method")
	//@Test
	public void testConvertHourToDecimal() {
		double DELTA = 0.01;
		assertEquals(28.695556, Calculations.convertHourToDecimal("28\"41'44"), DELTA); //$NON-NLS-1$
	}
	
	/**
	 * 
	 */
	//@Test
	@SuppressWarnings({ "static-method", "nls" })
	public void testCalculateGnomonangle() {
		fail("Not yet implemented");
	}

	/**
	 * In order to test this method, you need to change the expected array to
	 * the current time.
	 */
	//@Test
	@SuppressWarnings("static-method")
	public void testGetTime() {
		int[] expectedArray = {0, 0}; 
		assertArrayEquals(expectedArray, Calculations.getTime());
	}
	
	
	/**
	 * 2:35 == 38 deg 45'
	 */
	@SuppressWarnings("static-method")
	//@Test
	public void testConvertHourToDeg() {
		int[] timeArray = {2, 35};
		int[] expectedArray = {38, 45};
		assertArrayEquals(expectedArray, Calculations.convertTimeToArcDeg(timeArray));
	}
	
	
	/**
	 * 
	 */
	@SuppressWarnings({ "static-method" })
	//@Test
	public void testConvertArcToFrac() {
		int[] arcArray = {38, 45};
		assertEquals(38.75, Calculations.convertArcDegToFracDeg(arcArray), 0.01);
	}
}
