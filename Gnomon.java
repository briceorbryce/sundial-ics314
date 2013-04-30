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

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

/**
 * This class computes the Gnomon angle.
 * 
 * @author Amy
 * @author Reginald
 * @author Bryce
 *
 */
public class Gnomon{
	/**Point A.*/
	private Point a = new Point();
	/**Point B.*/
	private Point b = new Point();
	/**Point C.*/
	private Point c = new Point();
	/**Height of gnomon.*/
	private double height;
	/**Width of gnomon*/
	private double width;


	/**
	 * Constructs gnomon.
	 * 
	 * @param lat latitude
	 * @param panel JPanel ext
	 */
	public Gnomon(double lat, JPanelBExt panel){
		this.height = panel.getHeight();
		this.width = panel.getWidth();
		setPoints(this.a, 0, 0);
		setPoints(this.b, 0, this.height);
		setPoints(this.c, gnomonHeight(lat), 0);
	}

	/**
	 * Calculates the height of the gnomon
	 * 
	 * @param lat latitude
	 * @return gnomon height
	 */
	public double gnomonHeight(double lat){
		double gHeight;
		gHeight = this.height * Math.tan(Math.toRadians(lat));
		return gHeight;
	}
	/**
	 * Sets the points.
	 * 
	 * @param p point object
	 * @param setx x coor
	 * @param sety y coor
	 */
	public static void setPoints(Point p, double setx, double sety){
		p.setX(setx);
		p.setY(sety);
	}
	/**
	 * Getter for point A.
	 * 
	 * @return Point A
	 */
	public Point getPointa(){
		return this.a;
	}
	/**
	 * Getter for point B.
	 * 
	 * @return Point B
	 */
	public Point getPointb(){
		return this.b;
	}
	/**
	 * Getter for point C.
	 * @return Point C
	 */
	public Point getPointc(){
		return this.c;
	}

	/**
	 * Draws out gnomon.
	 * 
	 * @param gr graphics to draw gnomon on
	 */
	public void drawGnomon(Graphics gr){
		Graphics2D gr2 = (Graphics2D) gr;
		System.out.println("called gnomon");
		gr2.draw(new Line2D.Double(this.a.getX(), this.a.getY(), this.b.getX(), this.b.getY()));
		gr2.draw(new Line2D.Double(this.a.getX(), this.a.getY(), this.c.getX(), this.c.getY()));
		gr2.draw(new Line2D.Double(this.b.getX(), this.b.getY(), this.c.getX(), this.c.getY()));

	}
}
