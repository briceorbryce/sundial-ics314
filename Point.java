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


/**
 * Point object.
 * 
 * @author amytakayesu
 *
 */

public class Point {
	/**X-coordinate*/
	private double x;
	/**Y-coordinate*/
	private double y;
	
	/**
	 * Initializes the Point object in the Gnomon and Sundial class. <br />
	 * Empty to begin with.
	 */
	public Point() {
		
	}
	
	/**
	 * Constructs a coordinate point with coordinate x(parameter a) and y(parameter b)
	 * @param a to set to x
	 * @param b to set to y
	 */
	public Point(double a, double b){
		this.x = a;
		this.y = b;
	}

	/**
	 * Sets the x coordinate.
	 * 
	 * @param a will be set to x
	 */
	public void setX(double a){
		this.x = a;
	}

	/**
	 * Sets the y coordinate.
	 * 
	 * @param b will be set to y
	 */
	public void setY(double b){
		this.y = b;
	}

	/**
	 * Getter for x coordinate.
	 * 
	 * @return x coordinate
	 */
	public double getX(){
		return this.x;
	}

	/**
	 * Getter for y coordinate
	 * @return y coordinate
	 */
	public double getY(){
		return this.y;
	}
}
