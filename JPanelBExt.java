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

import javax.swing.JPanel;

/**
 * This class extends JPanel to override the method that repaints the panel
 * everytime the user's mouse hovers over the tabs in the SunDialFrame class.
 * 
 * Instead, we repaint the exact same thing.
 * 
 * have something shown in the beginning? Like a sample picture?
 * 
 * @author briceorbryce
 */
public class JPanelBExt extends JPanel{
	/**Serial Version UID*/
	private static final long serialVersionUID = 1L;

	/**The name of the panel.*/
	private final String nameOfPanel;

	/**User input variables.*/
    SundialMath sundial;
    
    /**Prevents program from repainting on start.*/
    private boolean runProgram;

	/**
	 * The name of the panel will either be "gnomon" or "sundial"
	 * 
	 * @param name of the panel
	 */
	public JPanelBExt (String name) {
		this.nameOfPanel = name;
	}

	/**
	 * Override the paintComponent method to redraw the same components on the
	 * panel.
	 */
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (this.runProgram) {
	        if(this.nameOfPanel.equals("sundial")){ //$NON-NLS-1$
	        	//print sundial here
	        	Dial di = new Dial(this);
	        	/*x is the hour line*/
	        	for(double x = 1; x < 6; x++){
	        			di.setPoint((int)x, Math.toRadians(this.sundial.adjustAngle(x)));
	        			int y = 0;
	        			switch((int)x){
	        				case 1:
	        					y = 11;
	        					break;
	        				case 2:
	        					y = 10;
	        					break;
	        				case 3:
	        					y = 9;
	        					break;
	        				case 4:
	        					y = 8;
	        					break;
	        				case 5:
	        					y = 7;
	        					break;
	        				default:
	        					// Should not hit
	        					break;
	        			}
	        			di.setPoint(y, -Math.toRadians(this.sundial.adjustAngle(x)));
	        	}
	        	di.drawDial(g);
	        }
	        else if(this.nameOfPanel.equals("gnomon")){ //$NON-NLS-1$
	        	//print gnomon here
	        	Gnomon gn = new Gnomon(30.0, this);
	        	gn.drawGnomon(g);
	        }
		}
	}

	/**
	 * Called from the SunDialFrame class. This method needs to take some kind
	 * of object as its parameter but it has not been created yet.
	 * 
	 * @param s Sundial math object
	 */
	public void paintMe (SundialMath s) {
    	this.sundial = s;
    	this.runProgram = true;
		this.repaint();
	}
}
