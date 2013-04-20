/**
  @author Reginald Nartatez
 */
 
import java.math.*;

public class SundialMath
{
	
	//Converts hour to decimal
	//from stackoverflow5
	public static double convertHourToDecimal(String degree)
	{
    	if(!degree.matches("(-)?[0-6][0-9]\"[0-6][0-9]\'[0-6][0-9](.[0-9]{1,5})?"))
  	      throw new IllegalArgumentException();
  	      
  		String[] strArray=degree.split("[\"']");
  		return Double.parseDouble(strArray[0])+Double.parseDouble(strArray[1])/60+Double.parseDouble(strArray[2])/3600;
	}
	
	//finds the angle of the hour line for the gnomon
	//formula:	tan(d) = tan(t)*sin(phi)
	//d	= angle of the hour line
	//t	= time measured from noon in degrees of arc
	//phi = latitude of sundial location
	public static double getAngleOfHour(double t, String phi)
	{	
		return Math.atan(Math.tan(t)*Math.sin(convertHourToDecimal(phi)));
	}
	
	//same as above, but takes a double for phi instead of a string
	public static double getAngleOfHour(double t, double phi)
	{	
		return Math.atan(Math.tan(t)*Math.sin(phi));
	}
}
