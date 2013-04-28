package sundial;

import java.awt.Graphics;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
	
	// amy's awesome thing goes here TODO
    
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
     * 
     * 4/27/2013 @ 4:43 pm
     * Right now, to show that it works, a line gets printed on both panels at
     * startup and when you click the button.
     */
    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // TODO Take out
        g.drawLine(0, 0, 100, 100);
        // TODO if gnomon or if sundial
    }
    
    /**
     * Called from the SunDialFrame class. This method needs to take some kind
     * of object as its parameter but it has not been created yet.
     */
    public void paintMe () {
    	// TODO
    	this.repaint();
    }
    
}
