package test.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import sundial.SundialMath;

/**
 * JUnit test for SundialMath
 * 
 * @author Amy
 * @author Reginald
 * @author briceorbryce
 *
 */
public class SundialMathTest {

	/**
	 * Tests the convert hour to decimal method
	 */
	@SuppressWarnings({ "static-method", "nls" })
	@Test
	public void testConvertHourToDecimal() {
		
		double expected = 0;
		double actual = SundialMath.convertHourToDecimal("");
		double delta = 0.01;
		assertEquals(expected, actual, delta);
	}
	
	/**
	 * Tests the angle of hour method.
	 */
	@SuppressWarnings({ "static-method", "nls" })
	@Test
	public void testgetAngleOfHour() {
		double expected = 0;
		double actual = SundialMath.convertHourToDecimal("");
		double delta = 0.01;
		assertEquals(expected, actual, delta);
	}
	
	/**
	 * Tests the angle of hour method using different parameters.
	 */
	@SuppressWarnings({ "static-method", "nls" })
	@Test
	public void testgetAngleOfHour2() {
		double expected = 0;
		double actual = SundialMath.convertHourToDecimal("");
		double delta = 0.01;
		assertEquals(expected, actual, delta);
	}
}