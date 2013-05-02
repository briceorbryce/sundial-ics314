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


import java.io.Serializable;
import java.util.Calendar;


/**
 * Computes the angles for the gnomon.<br />
 * <br />
 * Implements Serializable to get rid of the Lint4J error in the JPanelBExt class.
 * 
 * @author Reginald Nartatez
 * @author Amy Takayesu
 * @author Bryce Nagareda
 *
 */
public class SundialMath implements Serializable {
	/**SerialVersion UID*/
	private static final long serialVersionUID = 1L;
	
	
	private double phi;			/*latitude*/
	private double longitude; 	/*longitude*/
	/**standard meridian*/
	private double sm;			/*standard meridian*/
	private String month;		/*month of the year*/
	private int day;			/*day of the month*/
	private boolean dSave;		/*true if daylight savings is in effect*/

	/**
	 * Constructs SundialMath
	 */
	public SundialMath (double lat, double lon, double standardM, String mon, int d, boolean b)
	{
		this.phi = lat;
		this.longitude = Math.abs(lon);
		this.sm = Math.abs(standardM);
		this.month = mon;
		this.day = d;
		this.dSave = b;
	}
	
	/**			
	 *	@params:	double t:	time measured from noon in degrees of arc
	 *	
	 *	finds the angle of the hour line for time t
	 *	formula:	tan(d) = tan(t)*sin(phi)
	 */
	public double calculateAngle(double t){
		double angle = Math.toDegrees(Math.atan(Math.tan(Math.toRadians(t))*Math.sin(Math.toRadians(this.phi))));
		return angle;
	}
	
	/**
	 * 
	 * @param t (hourline time), 
	 * @param dayOfTheYear (the day of the year i.e. Jan 1 is day 1, Feb 1 is day 32, Dec 31 is day 365)
	 * @return adjustedAngle in degrees (angle adjusted with both first and second refinements)
	 */
	public double adjustAngle(double t){
		int[] a = new int[2];
		if(this.dSave){
			a[0] = (int) t + 1;
		}
		else{
			a[0]=(int) t;
		}
		a[1] = 0;
		int actualTime = (int)((convertToMin(a) - firstRefinement()) - eot());
		double adjustedAngle = calculateAngle(convertToDec(convertTimeToArcDeg(convertToMinHour(actualTime))));
		return adjustedAngle;
	}

	/**			
	 *	First Refinement
	 *	finds the amount of minutes to adjust the hour lines due to difference in longitude
	 *  @return minOff (amount of minutes the sundial is off of clock time in minutes)
	 */
	public double firstRefinement()
	{
		/* minutes earlier or later than standard time (1 degree = 4 minutes)*/
		double minOff = (this.longitude - this.sm) * 4;
		int[] a = new int[2];
		a[0]=0;
		a[1]= (int)minOff;
		minOff = convertToMin(a);
		return minOff;
	}
	
	/**
	 * 
	 * @return Day of the year, calculated from month and day of month.
	 */
	public int calcDayOfYear(){
        Calendar ca = Calendar.getInstance();
        int n = 0;
        if(this.month.equals("January")){ //$NON-NLS-1$
        	n=0;
        }
        else if(this.month.equals("February")){ //$NON-NLS-1$
        	n=1;
        }
        else if(this.month.equals("March")){ //$NON-NLS-1$
        	n=2;
        }
        else if(this.month.equals("April")){ //$NON-NLS-1$
        	n=3;
        }
        else if(this.month.equals("May")){ //$NON-NLS-1$
        	n=4;
        }
        else if(this.month.equals("June")){ //$NON-NLS-1$
        	n=5;
        }
        else if(this.month.equals("July")){ //$NON-NLS-1$
        	n=6;
        }
        else if(this.month.equals("August")){ //$NON-NLS-1$
        	n=7;
        }
        else if(this.month.equals("September")){ //$NON-NLS-1$
        	n=8;
        }
        else if(this.month.equals("October")){ //$NON-NLS-1$
        	n=9;
        }
        else if(this.month.equals("November")){ //$NON-NLS-1$
        	n=10;
        }
        else if(this.month.equals("December")){ //$NON-NLS-1$
        	n=11;
        }

        /* set(int year, int month, int date)
         * Jan=0,Feb=1,Mar=2...
         */
        ca.set(2013,n,this.day);
        int dayOfYear=ca.get(Calendar.DAY_OF_YEAR);
        return dayOfYear;
	}
	
	/**			
	 *	@params int dayOfTheYear: the day of the year i.e. Jan 1 is day 1, Feb 1 is day 32, Dec 31 is day 365
	 *	@return difference due to Equation of Time in decimal
	 */
	public double eot()
	{
		double b = Math.toRadians(360 * (calcDayOfYear() - 81) / 365);
		double eot = (9.87 * Math.sin(2 * b) - 7.53 * Math.cos(b) - 1.5 * Math.sin(b));
		
		int[] t = new int[2];
		t[0] = 0;
		t[1] = (int)eot;

		eot = convertToMin(t);
		return eot;
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
	 * Converts array of degrees-minutes into decimal form.
	 * @param a int[] a (array of degrees-minutes)
	 * @return double dec (decimal form)
	 */
	public static double convertToDec(int[] a){
		double dec = a[0] + (a[1]/60.0);
		return dec;
	}
	
	/**
	 * Converts hours and minutes to minutes
	 * @param time time array
	 * @return time in minutes
	 */
	public static int convertToMin(int[] time){
		int minutes;
		minutes = (time[0] * 60) + time[1];
		return minutes;
	}
	
	/**
	 * Converts minutes to hours and minutes
	 * @param min time in minutes
	 * @return time in hours and minutes
	 */
	public static int[] convertToMinHour(int min){
		int[] mh = new int[2];
		mh[0] = min/60; 
		mh[1] = min - (mh[0]*60);
		return mh;
	}
	
	/**
	 * Getter for latitude.
	 * 
	 * @return latitude
	 */
	public double getLat(){
		return this.phi;
	}
	
	/**
	 * Getter for longitude.
	 * 
	 * @return longitude
	 */
	public double getLon(){
		return this.longitude;
	}
	
	/**
	 * Getter for standard meridian.
	 * 
	 * @return std meridian
	 */
	public double getSm(){
		return this.sm;
	}
	
	/**
	 * Getter for month.
	 * 
	 * @return month
	 */
	public String getMon(){
		return this.month;
	}
	
	/**
	 * Getter for day.
	 * 
	 * @return day
	 */
	public int getDay(){
		return this.day;
	}
}
