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
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JOptionPane;

/**
 * Sundial GUI main class. Draws out the sundial ONLY AFTER input has been
 * validated.
 * 
 * North and South Pole JRadio buttons won't click off, unless there's an
 * invisible, 3rd JRadio button.
 * 
 * @author Amy
 * @author Reginald
 * @author Bryce
 */
public class SunDialFrame extends javax.swing.JFrame implements Printable {
	/**SerialVersionUID*/
	private static final long serialVersionUID = 1L;

	/**Tooltip string*/
	private static final String popupLat = "Degrees-Minutes-Seconds"; //$NON-NLS-1$
	/**Tooltip string*/
	private static final String format = "Format: [Degrees][Minutes][Seconds]"; //$NON-NLS-1$

	/*
	 * These JPanels have been extended to do more than just repaint the panel
	 * after the user hovers over or clicks the tab.
	 */
	/**JPanel extension for the gnomon image.*/
	private JPanelBExt gnomon;
	/**JPanel extension for the sundial image.*/
	private JPanelBExt sundial;

	/*user input variables*/
	private double lat; //latitude
	private double lon; //longitude
	/**standard meridian*/
	private double sm;  //standard meridian
	private String mon; //month
	private int day;    //day



	/**
	 * Creates new form SunDialFrame
	 */
	public SunDialFrame() {
		initComponents();

		// Sets the location to the middle of the screen
		setLocationRelativeTo(null);
	}

	/**
	 * This is message is automatically generated by Netbeans.
	 * 
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	private void initComponents() {

		this.buttonGroupHemisphere = new javax.swing.ButtonGroup();
		this.buttonGroupPole = new javax.swing.ButtonGroup();
		this.jPanelInfo = new javax.swing.JPanel();
		this.jComboBoxFractionOrDegArcSec = new javax.swing.JComboBox();
		this.jLabelLongitude = new javax.swing.JLabel();
		this.jLabelLatitude = new javax.swing.JLabel();
		this.jLabelLongDeg = new javax.swing.JLabel();
		this.jTextFieldLongitude = new javax.swing.JTextField();
		this.jTextFieldLatitude = new javax.swing.JTextField();
		this.jLabelDate = new javax.swing.JLabel();
		this.jLabelLatiDeg = new javax.swing.JLabel();
		this.jComboBoxMonth = new javax.swing.JComboBox();
		this.jComboBoxDay = new javax.swing.JComboBox();
		this.jButtonSearch = new javax.swing.JButton();
		this.jCheckBoxDST = new javax.swing.JCheckBox();
		this.jCheckBoxEquator = new javax.swing.JCheckBox();
		this.jRadioButtonNorthHemi = new javax.swing.JRadioButton();
		this.jRadioButtonSouthHemi = new javax.swing.JRadioButton();
		this.jRadioButtonNPole = new javax.swing.JRadioButton();
		this.jRadioButtonSPole = new javax.swing.JRadioButton();
		this.jTabbedPaneDialGno = new javax.swing.JTabbedPane();
		this.jTextFieldStdMeridian = new javax.swing.JTextField();
		this.jLabelStdMeridian = new javax.swing.JLabel();
		this.jLabelStdMeridianDeg = new javax.swing.JLabel();
		this.jMenuBar = new javax.swing.JMenuBar();
		this.jMenuFile = new javax.swing.JMenu();
		this.jMenuItemPrint = new javax.swing.JMenuItem();
		this.jMenuHelp = new javax.swing.JMenu();
		this.jMenuItemAbout = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		this.jPanelInfo.setBackground(java.awt.Color.orange);

		this.jComboBoxFractionOrDegArcSec.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  "Fractional Degrees", SunDialFrame.popupLat })); //$NON-NLS-1$
		this.jComboBoxFractionOrDegArcSec.setPreferredSize(new java.awt.Dimension(185, 20));

		this.jLabelLongitude.setText("Longitude:"); //$NON-NLS-1$

		this.jLabelLatitude.setText("Latitude:"); //$NON-NLS-1$

		this.jLabelLongDeg.setText("Degrees"); //$NON-NLS-1$

		this.jTextFieldLongitude.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				tooltipLongEnter(evt);
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent evt) {
				tooltipLongExit(evt);
			}
		});

		this.jTextFieldLatitude.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				tooltiplatitudeEnter(evt);
			}
			@Override
			public void mouseExited(java.awt.event.MouseEvent evt) {
				tooltipLatExit(evt);
			}
		});

		this.jLabelDate.setText("Date:"); //$NON-NLS-1$

		this.jLabelLatiDeg.setText("Degrees"); //$NON-NLS-1$

		this.jComboBoxMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" })); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$

		String[] holdDays = new String[32];
		holdDays[0] = "Day"; //$NON-NLS-1$
		for (int i = 1; i < 32; i++) {
			holdDays[i] = String.valueOf(i);
		}

		this.jComboBoxDay.setModel(new javax.swing.DefaultComboBoxModel(holdDays));

		this.jButtonSearch.setText("Display Sundial & Gnomon"); //$NON-NLS-1$
		this.jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButtonSearchActionPerformed(evt);
			}
		});

		this.jCheckBoxDST.setText("Daylight Savings Time?"); //$NON-NLS-1$

		this.jCheckBoxEquator.setText("Are you at the equator?\n"); //$NON-NLS-1$

		this.jRadioButtonNorthHemi.setSelected(true);
		this.jRadioButtonNorthHemi.setText("Northern Hemisphere"); //$NON-NLS-1$

		this.jRadioButtonSouthHemi.setText("Southern Hemisphere"); //$NON-NLS-1$

		this.jRadioButtonNPole.setText("North Pole"); //$NON-NLS-1$

		this.jRadioButtonSPole.setText("South Pole"); //$NON-NLS-1$

		this.jLabelStdMeridian.setText("Standard Meridian"); //$NON-NLS-1$

		this.jLabelStdMeridianDeg.setText("Degrees"); //$NON-NLS-1$

		javax.swing.GroupLayout jPanelInfoLayout = new javax.swing.GroupLayout(this.jPanelInfo);
		this.jPanelInfo.setLayout(jPanelInfoLayout);
		jPanelInfoLayout.setHorizontalGroup(
				jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelInfoLayout.createSequentialGroup()
						.addContainerGap(36, Short.MAX_VALUE)
						.addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(this.jLabelLatitude, javax.swing.GroupLayout.Alignment.TRAILING)
												.addComponent(this.jLabelLongitude, javax.swing.GroupLayout.Alignment.TRAILING))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInfoLayout.createSequentialGroup()
														.addGap(24, 24, 24)
														.addComponent(this.jLabelDate)))
														.addComponent(this.jLabelStdMeridian, javax.swing.GroupLayout.Alignment.TRAILING))
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																.addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																		.addGroup(jPanelInfoLayout.createSequentialGroup()
																				.addComponent(this.jTextFieldLatitude, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																				.addComponent(this.jLabelLatiDeg))
																				.addGroup(jPanelInfoLayout.createSequentialGroup()
																						.addComponent(this.jComboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(this.jComboBoxDay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																						.addGroup(jPanelInfoLayout.createSequentialGroup()
																								.addComponent(this.jTextFieldLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(this.jLabelLongDeg))
																								.addComponent(this.jButtonSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																								.addGroup(jPanelInfoLayout.createSequentialGroup()
																										.addComponent(this.jTextFieldStdMeridian, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(this.jLabelStdMeridianDeg)))
																										.addGap(42, 42, 42)
																										.addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																												.addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																														.addGroup(jPanelInfoLayout.createSequentialGroup()
																																.addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																																		.addComponent(this.jCheckBoxDST)
																																		.addComponent(this.jRadioButtonNorthHemi))
																																		.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																																		.addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
																																				.addComponent(this.jRadioButtonSouthHemi)
																																				.addComponent(this.jCheckBoxEquator)
																																				.addComponent(this.jRadioButtonSPole)))
																																				.addComponent(this.jComboBoxFractionOrDegArcSec, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																																				.addComponent(this.jRadioButtonNPole))
																																				.addGap(88, 88, 88))
																																				.addGroup(jPanelInfoLayout.createSequentialGroup()
																																						.addContainerGap()
																																						.addComponent(this.jTabbedPaneDialGno)
																																						.addContainerGap())
				);
		jPanelInfoLayout.setVerticalGroup(
				jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelInfoLayout.createSequentialGroup()
						.addGap(18, 18, 18)
						.addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(this.jLabelLatitude)
								.addComponent(this.jTextFieldLatitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(this.jLabelLatiDeg)
								.addComponent(this.jComboBoxFractionOrDegArcSec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(this.jTextFieldLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(this.jLabelLongitude)
										.addComponent(this.jLabelLongDeg)
										.addComponent(this.jCheckBoxDST)
										.addComponent(this.jCheckBoxEquator))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(jPanelInfoLayout.createSequentialGroup()
														.addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																.addComponent(this.jRadioButtonNorthHemi)
																.addComponent(this.jRadioButtonSouthHemi))
																.addGap(2, 2, 2))
																.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInfoLayout.createSequentialGroup()
																		.addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																				.addComponent(this.jTextFieldStdMeridian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																				.addComponent(this.jLabelStdMeridian)
																				.addComponent(this.jLabelStdMeridianDeg))
																				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
																				.addGroup(jPanelInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(this.jLabelDate)
																						.addComponent(this.jComboBoxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(this.jComboBoxDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(this.jRadioButtonNPole)
																						.addComponent(this.jRadioButtonSPole))
																						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(this.jButtonSearch)
																						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(this.jTabbedPaneDialGno, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
																						.addContainerGap())
				);

		this.buttonGroupHemisphere.add(this.jRadioButtonNorthHemi);
		this.buttonGroupHemisphere.add(this.jRadioButtonSouthHemi);
		this.buttonGroupPole.add(this.jRadioButtonNPole);
		this.buttonGroupPole.add(this.jRadioButtonSPole);
		this.gnomon = new JPanelBExt("gnomon"); //$NON-NLS-1$
		this.sundial = new JPanelBExt("sundial"); //$NON-NLS-1$
		this.jTabbedPaneDialGno.add("Horizontal Sundial", this.sundial); //$NON-NLS-1$
		this.jTabbedPaneDialGno.add("Gnomon", this.gnomon); //$NON-NLS-1$

		this.jMenuFile.setText("File"); //$NON-NLS-1$

		this.jMenuItemPrint.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
		this.jMenuItemPrint.setText("Print"); //$NON-NLS-1$
		this.jMenuItemPrint.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItemPrintActionPerformed(evt);
			}
		});
		this.jMenuFile.add(this.jMenuItemPrint);

		this.jMenuBar.add(this.jMenuFile);

		this.jMenuHelp.setText("Help"); //$NON-NLS-1$

		this.jMenuItemAbout.setText("About"); //$NON-NLS-1$
		this.jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItemAboutActionPerformed(evt);
			}
		});
		this.jMenuHelp.add(this.jMenuItemAbout);

		this.jMenuBar.add(this.jMenuHelp);

		setJMenuBar(this.jMenuBar);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(this.jPanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(this.jPanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);

		pack();
	}

	/**
	 * Opens the about page.
	 * 
	 * @param evt clicked the about page
	 */
	public void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {
		new AboutPage(this, this.rootPaneCheckingEnabled).setVisible(true);
	}

	/**
	 * When you mouse over the latitude text field, the tooltip is shown if
	 * degree/arc/sec is selected in the dropdown menu.
	 * 
	 * @param evt enters textbox
	 */
	public void tooltiplatitudeEnter(java.awt.event.MouseEvent evt) {
		if (this.jComboBoxFractionOrDegArcSec.getSelectedItem().equals(SunDialFrame.popupLat)) {
			this.jTextFieldLatitude.setToolTipText(SunDialFrame.format);
		}
	}

	/**
	 * When you move the mouse outside of the text field, set tooltip to null.
	 * 
	 * @param evt exits textbox
	 */
	public void tooltipLatExit(java.awt.event.MouseEvent evt) {
		if (this.jComboBoxFractionOrDegArcSec.getSelectedItem().equals(SunDialFrame.popupLat)) {
			this.jTextFieldLatitude.setToolTipText(null);
		}
	}

	/**
	 * Prints the gnomon.
	 * 
	 * @param evt print
	 */
	private void jMenuItemPrintActionPerformed(java.awt.event.ActionEvent evt) {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setJobName("Gnomon-and-sundial"); //$NON-NLS-1$
		job.setPrintable(this);
		boolean doPrint = job.printDialog();
		if (doPrint) {
			try {
				job.print();
			}
			catch (PrinterException fail) {
				JOptionPane.showMessageDialog(null, fail);
			}
		}
	}

	/**
	 * Sets up the printer dialog.
	 * 
	 */
	/* (non-Javadoc)
	 * @see java.awt.print.Printable#print(java.awt.Graphics, java.awt.print.PageFormat, int)
	 */
	@Override
	public int print(Graphics g, PageFormat pf, int page) {
		if (page > 0) {
			return NO_SUCH_PAGE;
		}
		//TODO I bet this is wrong...
		this.gnomon.print(g);
		this.sundial.print(g);
		return PAGE_EXISTS;
	}

	/**
	 * When you mouse over the longitude text field, the tooltip is shown if
	 * degree/arc/sec is selected in the dropdown menu.
	 * 
	 * @param evt enters textbox
	 */
	public void tooltipLongEnter(java.awt.event.MouseEvent evt) {
		if (this.jComboBoxFractionOrDegArcSec.getSelectedItem().equals(SunDialFrame.popupLat)) {
			this.jTextFieldLongitude.setToolTipText(SunDialFrame.format);
		}
	}

	/**
	 * When you move the mouse outside of the text field, set tooltip to null.
	 * 
	 * @param evt leaves textbox
	 */
	public void tooltipLongExit(java.awt.event.MouseEvent evt) {
		if (this.jComboBoxFractionOrDegArcSec.getSelectedItem().equals(SunDialFrame.popupLat)) {
			this.jTextFieldLongitude.setToolTipText(null);
		}
	}

	/**
	 * User has hit search.
	 * 
	 * @param evt User hits search
	 */
	private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {

		if (userError()) {
			JOptionPane.showMessageDialog(null, "Invalid input", null, JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$
		}
		else if (convertStringToDouble()) {
			JOptionPane.showMessageDialog(null, "Invalid input", null, JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$
		}
		else {
			// assume calculations are all correct
			drawGnomonAndSundial();
		}
	}

	/**
	 * Checks if any of the text fields or combo boxes are empty or they haven't been
	 * changed. Also checks if user enters Feb and 30, for example.
	 * 
	 * @return false if text fields are empty or combo boxes unchanged
	 */
	@SuppressWarnings("static-method")
	private boolean userError() {
		return false; /*this.jTextFieldLatitude.getText().isEmpty() ||
				this.jTextFieldLongitude.getText().isEmpty() ||
				this.jComboBoxMonth.getSelectedItem().equals("Month") || //$NON-NLS-1$
				this.jComboBoxDay.getSelectedItem().equals("Day") || //$NON-NLS-1$
				checkValidMonthsAndDays(); */
	}

	/**
	 * Checks to make sure the user chooses a month with a valid day. <br />
	 * Ignoring leap year, Feb 29.
	 * 
	 * @return true if user chose month with a valid day
	 */
	private boolean checkValidMonthsAndDays() {
		String selectedMonth = this.jComboBoxMonth.getSelectedItem().toString();
		int selectedDay = Integer.parseInt(this.jComboBoxDay.getSelectedItem().toString());
		
		if (selectedMonth.equals("February")) { //$NON-NLS-1$
			switch (selectedDay) {
			case 29:
			case 30:
			case 31:
			return true;
			default:
				return false;
			}
		}
		if (selectedDay == 31) {
			if (selectedMonth.equals("April")) { //$NON-NLS-1$
				return true;
			}
			else if (selectedMonth.equals("June")) { //$NON-NLS-1$
				return true;
			}
			else if (selectedMonth.equals("September")) { //$NON-NLS-1$
				return true;
			}
			else if (selectedMonth.equals("November")) { //$NON-NLS-1$
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Converts the longtidude and latitude text field to double. Returns false
	 * if the the parse worked correctly.
	 * 
	 * @return true if the parse worked correctly
	 */
	public boolean convertStringToDouble() {
		try {
			this.lat = Integer.parseInt(this.jTextFieldLatitude.getText());
			this.lon = Integer.parseInt(this.jTextFieldLongitude.getText());
		}
		catch (NumberFormatException fail) {
			this.jTextFieldLatitude.setText(""); //$NON-NLS-1$
			this.jTextFieldLongitude.setText(""); //$NON-NLS-1$
			return true;
		}
		return false;
	}

	/**
	 * Draws out the sundial and gnomon.
	 * 
	 */
	private void drawGnomonAndSundial() {
		
		SundialMath sundialToPass = new SundialMath(this.lat, this.lon, this.sm, this.mon, this.day);
		this.gnomon.paintMe(sundialToPass);
		this.sundial.paintMe(sundialToPass);
	}

	/**
	 * Main method.
	 * 
	 * @param args the command line arguments -not used
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) { //$NON-NLS-1$
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(SunDialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(SunDialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(SunDialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(SunDialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SunDialFrame().setVisible(true);
			}
		});
	}
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.ButtonGroup buttonGroupHemisphere;
	private javax.swing.ButtonGroup buttonGroupPole;
	private javax.swing.JButton jButtonSearch;
	private javax.swing.JCheckBox jCheckBoxDST;
	private javax.swing.JCheckBox jCheckBoxEquator;
	private javax.swing.JComboBox jComboBoxDay;
	private javax.swing.JComboBox jComboBoxFractionOrDegArcSec;
	private javax.swing.JComboBox jComboBoxMonth;
	private javax.swing.JLabel jLabelDate;
	private javax.swing.JLabel jLabelLatiDeg;
	private javax.swing.JLabel jLabelLatitude;
	private javax.swing.JLabel jLabelLongDeg;
	private javax.swing.JLabel jLabelLongitude;
	private javax.swing.JLabel jLabelStdMeridian;
	private javax.swing.JLabel jLabelStdMeridianDeg;
	private javax.swing.JMenuBar jMenuBar;
	private javax.swing.JMenu jMenuFile;
	private javax.swing.JMenu jMenuHelp;
	private javax.swing.JMenuItem jMenuItemAbout;
	private javax.swing.JMenuItem jMenuItemPrint;
	private javax.swing.JPanel jPanelInfo;
	private javax.swing.JRadioButton jRadioButtonNPole;
	private javax.swing.JRadioButton jRadioButtonNorthHemi;
	private javax.swing.JRadioButton jRadioButtonSPole;
	private javax.swing.JRadioButton jRadioButtonSouthHemi;
	private javax.swing.JTabbedPane jTabbedPaneDialGno;
	private javax.swing.JTextField jTextFieldLatitude;
	private javax.swing.JTextField jTextFieldLongitude;
	private javax.swing.JTextField jTextFieldStdMeridian;
	// End of variables declaration//GEN-END:variables
}
