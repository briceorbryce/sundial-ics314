/*
 * Copyright (c) 2013, Amy, Reginald, Bryce
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 		Redistributions of source code must retain the above copyright notice, this
 * 		list of conditions and the following disclaimer.
 * 		
 * 		Redistributions in binary form must reproduce the above copyright
 * 		notice, this list of conditions and the following disclaimer in the
 * 		documentation and/or other materials provided with the distribution.
 * 		
 * 		Neither the name of the University of Hawaii, ICS Dept, nor the names
 * 		of its contributors	may be used to endorse or promote products derived
 * 		from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */


package sundial;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Amy
 * @author Reginald
 * @author Bryce
 *
 */
public class Calculations {
	
	/**
	 * Calculates the Gnomon angle for the user.
	 * 
	 * @param latitude user input
	 * @return the angle to print
	 */
	public static double calculateGnomonangle (double latitude) {
		//TODO still need to do the arctan..
		double d = Calculations.calcTimeFrmNoonArcDeg()* Math.sin(latitude);
		// the only thing this method should do is return the arctan of d
		return 0;
	}
	
	/**
	 * @return the tan angle of t
	 */
	public static double calcTimeFrmNoonArcDeg() {
		//TODO
		Calculations.getTime();
		return 0;
	}
	
	//TODO Math.sin(latitude) - latitude probably isn't in radians..so put a method here
	// you dumbass brice
	
	/**
	 * Gets the time from ... I'm not sure LOL
	 * 
	 * and stores it in an int array, size 2, where 
	 * [0] = hour
	 * [1] = minunte
	 * 
	 * http://www.mkyong.com/java/java-how-to-get-current-date-time-date-and-calender/
	 * 
	 * @return a string of the time
	 */
	public static int[] getTime() {
		DateFormat df = new SimpleDateFormat("hh:mm"); //$NON-NLS-1$
		Date date = new Date();
		String[] stringTime = df.format(date).split(":"); //$NON-NLS-1$
		int[] intTime = {Integer.parseInt(stringTime[0]),
							Integer.parseInt(stringTime[1])};
		return intTime;
	}
	
	/**
	 * Converts the time from hh:mm to degrees of arc.
	 * 
	 * @param time array where [0] is hr [1] is min 
	 * @return the degrees of arc
	 */
	public static int[] convertTimeToArcDeg (int[] time) {
		int[] arcTime = new int[2];
		arcTime[0] = time[0] * 15; 
		arcTime[1] = (time[1] % 4) * 15;
		int arcMinutesCarry =  time[1] / 4; 
		arcTime[0] += arcMinutesCarry;
		return arcTime;
	}
	
	/**
	 * Converts from degrees-minutes to fractional degrees
	 * 
	 * @param arcDeg degree-min
	 * @return fractional degrees 
	 */
	public static double convertArcDegToFracDeg (int[] arcDeg) {
		
		double[] fractionalDeg = {arcDeg[0], arcDeg[1]};
		fractionalDeg[1] = arcDeg[1] / 60.0;
		
		return fractionalDeg[0] + (fractionalDeg[1]);
	}
	
	/**
	 * Uses the static math class to convert radians to degrees.
	 * 
	 * @param radians to convert
	 * @return the conversion to degrees
	 */
	public static double radToDegree (double radians) {
		return Math.toDegrees(radians);
	}
	
	/**
	 * Uses the static math class to convert radians to degrees.
	 * 
	 * @param degrees to convert
	 * @return the conversion to degrees
	 */
	public static double degToRadians (double degrees) {
		return Math.toDegrees(degrees);
	}
	
	
	/**
	 *  This code was taken from StackOverflow:
	 *  http://stackoverflow.com/questions/2779405/how-to-convert-degree-minutes-second-into-decimal-in-java
	 *  
	 *  
	 *  Added the Non NLS comments
	 *  
	 * answer=hour+minutes/60+seconds/3600 
	 * @param degree to convert
	 * @return the conversion to decimal
	 */
	public static double convertHourToDecimal(String degree) { 
		if(!degree.matches("(-)?[0-6][0-9]\"[0-6][0-9]\'[0-6][0-9](.[0-9]{1,5})?")) //$NON-NLS-1$
				throw new IllegalArgumentException();
		String[] strArray=degree.split("[\"']"); //$NON-NLS-1$
		return Double.parseDouble(strArray[0])+Double.parseDouble(strArray[1])/60+Double.parseDouble(strArray[2])/3600;
	}
}