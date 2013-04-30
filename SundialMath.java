package sundial;

/**
 *@author Reginald Nartatez
 */
 
import java.util.Calendar;


public class SundialMath {

	private double phi;			/*latitude*/
	private double longitude; 	/*longitude*/
	private double sm;			/*standard meridian*/
	private String month;		/*month of the year*/
	private int day;			/*day of the month*/

	/**
	 * Constructs SundialMath
	 */
	public SundialMath (double lat, double lon, double standardM, String mon, int d)
	{
		phi = lat;
		longitude = Math.abs(lon);
		sm = Math.abs(standardM);
		month = mon;
		day = d;
	}
	
	/**			
	 *	@params:	double t:	time measured from noon in degrees of arc
	 *	
	 *	finds the angle of the hour line for time t
	 *	formula:	tan(d) = tan(t)*sin(phi)
	 */
	public double calculateAngle(double t){
		double angle = Math.toDegrees(Math.atan(Math.tan(Math.toRadians(t))*Math.sin(Math.toRadians(phi))));
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
		a[0]=(int) t;
		a[1] = 0;
		int actualTime = (int)((convertToMin(a) - firstRefinement()) - eot());
		//double actualTime = (convertToDec(convertTimeToArcDeg(a)) - (firstRefinement()) - (eot()));
		System.out.println("actualTime: " + actualTime);
	//	int hour = (int)actualTime;
	//	int min = (int)((actualTime - hour)*100);
	//	int[] time = new int[2];
	//	time[0] = hour;
	//	time[1] = min;
	//	System.out.println("hour: " + time[0]);
	//	System.out.println("min: " + time[1]);
	//	actualTime = convertToDec(convertTimeToArcDeg(time));
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
		double minOff = (longitude - sm) * 4;
		int[] a = new int[2];
		a[0]=0;
		a[1]= (int)minOff;
		//System.out.println("minoff b4 convert: " + a[1]);
		//minOff = convertToDec(convertTimeToArcDeg(a));
		minOff = convertToMin(a);
		System.out.println("minOff: " + minOff);
		return minOff;
	}
	
	/**
	 * 
	 * @return Day of the year, calculated from month and day of month.
	 */
	public int calcDayOfYear(){
        Calendar ca = Calendar.getInstance();
        int n = 0;
        if(month.equals("January")){
        	n=0;
        }
        else if(month.equals("February")){
        	n=1;
        }
        else if(month.equals("March")){
        	n=2;
        }
        else if(month.equals("April")){
        	n=3;
        }
        else if(month.equals("May")){
        	n=4;
        }
        else if(month.equals("June")){
        	n=5;
        }
        else if(month.equals("July")){
        	n=6;
        }
        else if(month.equals("August")){
        	n=7;
        }
        else if(month.equals("September")){
        	n=8;
        }
        else if(month.equals("October")){
        	n=9;
        }
        else if(month.equals("November")){
        	n=10;
        }
        else if(month.equals("December")){
        	n=11;
        }

        /* set(int year, int month, int date)
         * Jan=0,Feb=1,Mar=2...
         */
        ca.set(2013,n,day);
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
	//	eot = (eot/100);
	//	if(eot < 0){
	//		eot = eot - 0.4;
	//	}
	//	else{
	//		eot = eot + 0.4;
	//	}
		int[] t = new int[2];
		t[0] = 0;
		t[1] = (int)eot;
		//eot = convertToDec(convertTimeToArcDeg(t));
		eot = convertToMin(t);
		System.out.println("eot: " + eot);
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
		System.out.println("deg arc hour: " + arcTime[0] + " min: " + arcTime[1]);
		return arcTime;
	}

	/**
	 * Converts array of degrees-minutes into decimal form.
	 * @param int[] a (array of degrees-minutes)
	 * @return double dec (decimal form)
	 */
	public static double convertToDec(int[] a){
		double dec = a[0] + (a[1]/60.0);
		return dec;
	}
	
	/**
	 * Converts hours and minutes to minutes
	 * @param time
	 * @return time in minutes
	 */
	public static int convertToMin(int[] time){
		int minutes;
		minutes = (time[0] * 60) + time[1];
		return minutes;
	}
	
	/**
	 * Converts minutes to hours and minutes
	 * @param time in minutes
	 * @return time in hours and minutes
	 */
	public static int[] convertToMinHour(int min){
		int[] mh = new int[2];
		mh[0] = min/60; 
		mh[1] = min - (mh[0]*60);
		return mh;
	}
	
	public double getLat(){
		return phi;
	}
	
	public double getLon(){
		return longitude;
	}
	
	public double getSm(){
		return sm;
	}
	
	public String getMon(){
		return month;
	}
	
	public int getDay(){
		return day;
	}
}
