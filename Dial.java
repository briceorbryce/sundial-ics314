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
 *
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
 * @author Amy
 * @author Reginald
 * @author Bryce
 *
 */
public class Dial {
	/*height and width of panel*/
	/**Height of Dial panel.*/
	private double height;
	/**Width of Dial panel.*/
	private double width;
	
	/*array of the points of the dial lines*/
	/**Array of the dial points.*/
	private Point[] dialPoints = new Point[13];

	/**
	 * Constructs horizontal sundial
	 * @param panel Panel ext
	 */
	public Dial(JPanelBExt panel){
		this.height = panel.getHeight();
		this.width = panel.getWidth();
		for(int x = 0; x <= 12; x ++){
			this.dialPoints[x] = new Point();
		}
		System.out.println("HERE?");
	}

	/**
	 * Sets sundial hour line point
	 * @param h hour
	 * @param angle angle of gnomon and hour line
	 */
	public void setPoint(int h, double angle){
		double lengthTop = this.height * Math.tan(angle);
		double lengthSide = this.width/2 * Math.tan((Math.toRadians(90)) - angle);
		System.out.println("Hour: " + h + " angle: " + angle + " Math.tan: " + Math.tan(angle));
		System.out.println("length: " + lengthTop);
		System.out.println("height: " + this.height);
		System.out.println("width: " + this.width);
		/*line intersects with side of panel*/
		if(Math.abs(lengthTop) >= this.width/2){
			/*if line is to the right of the gnomon*/
			if(angle > 0){
				System.out.println("side, PM");
				this.dialPoints[h].setX(this.width);
				this.dialPoints[h].setY(this.height - Math.abs(lengthSide));
			}
			/*if line is to the left of the gnomon*/
			else{
				System.out.println("side, AM");
				this.dialPoints[h].setX(0.0);
				this.dialPoints[h].setY(this.height - Math.abs(lengthSide));
			}
		}
		/*line intersects with top of panel*/
		else{
			/*if line is to the right of the gnomon*/
			if(angle > 0){
				System.out.println("top, PM");
				this.dialPoints[h].setX((this.width/2) + Math.abs(lengthTop));
				this.dialPoints[h].setY(0.0);
			}
			/*if line is to the left of the gnomon*/
			else{
				System.out.println("top, AM");
				this.dialPoints[h].setX((this.width/2) - Math.abs(lengthTop));
				this.dialPoints[h].setY(0.0);
			}
		}
	}

	/**
	 * Sets sundial hour point.
	 * 
	 * @param h hour
	 * @param x x coor
	 * @param y y coor
	 */
	public void setPoint(int h, double x, double y){
		this.dialPoints[h].setX(x);
		this.dialPoints[h].setY(y);
	}

	/**
	 * Draws out sundial.
	 * 
	 * @param gr graphics
	 */
	public void drawDial(Graphics gr){
		Graphics2D gr2 = (Graphics2D) gr;
		System.out.println("DRAW!!!!!!!!!!");
		//gr.drawLine(0, 314, 782, 314);
		try{
			for(int i = 1; i <= 12; i++){
				if(i == 6){
					System.out.println("x==6");
					gr2.draw(new Line2D.Double(0.0, this.height, this.width, this.height));
				}
				else if(i == 12){
					System.out.println("x==12");
					gr2.draw(new Line2D.Double(this.width/2, 0.0, this.width/2, this.height));
				}
				else{
					System.out.println("x==123457891011");
					gr2.draw(new Line2D.Double(this.width/2, this.height, this.dialPoints[i].getX(), this.dialPoints[i].getY()));
				}
			}
		}
		catch(NullPointerException npe){
			System.out.println("One or more of the hour line points are missing.");
		}
	}
}
