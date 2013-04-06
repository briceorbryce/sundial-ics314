
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Well this is a test
 * @author briceorbryce
 */
public class SunDialFrame extends javax.swing.JFrame {
	/**SerialVersionUID*/
	private static final long serialVersionUID = 1L;
	
	/**Latitude*/
	@SuppressWarnings("unused")
	private double latitude = 0;
	/**Longitude*/
	@SuppressWarnings("unused")
	private double longitude = 0;
	/***/
	private static final String popupLat = "Degrees-Minutes-Seconds";
	/***/
	private static final String format = "Format: [Degrees][Minutes][Seconds]";
	/**
	 * Creates new form SunDialFrame
	 */
	public SunDialFrame() {
		initComponents();
		// Centers the app
		setLocationRelativeTo(null);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		this.jLabelLatitude = new javax.swing.JLabel();
		this.jLabelLongitude = new javax.swing.JLabel();
		this.jLabelDate = new javax.swing.JLabel();
		this.jTextFieldLatitude = new javax.swing.JTextField();
		this.jTextFieldDate = new javax.swing.JTextField();
		this.jTextFieldLongitude = new javax.swing.JTextField();
		this.jButtonSearch = new javax.swing.JButton();
		this.jLabelLatiDeg = new javax.swing.JLabel();
		this.jLabelLongDeg = new javax.swing.JLabel();
		this.jLabelDateMDY = new javax.swing.JLabel();
		this.jComboBoxFractionOrDegArcSec = new javax.swing.JComboBox();
		this.jMenuBar = new javax.swing.JMenuBar();
		this.jMenuFile = new javax.swing.JMenu();
		this.jMenuItemPrint = new javax.swing.JMenuItem();
		this.jMenuHelp = new javax.swing.JMenu();
		this.jMenuItemAbout = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		this.jLabelLatitude.setText("Latitude:");

		this.jLabelLongitude.setText("Longitude:");

		this.jLabelDate.setText("Date:");

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

		this.jButtonSearch.setText("Search");

		this.jLabelLatiDeg.setText("Degrees");

		this.jLabelLongDeg.setText("Degrees");

		this.jLabelDateMDY.setText("mm/dd/yyyy");

		this.jComboBoxFractionOrDegArcSec.setModel(new javax.swing.DefaultComboBoxModel(new String[] { SunDialFrame.popupLat, "Fractional Degrees" }));
		this.jComboBoxFractionOrDegArcSec.setPreferredSize(new java.awt.Dimension(185, 20));

		this.jMenuFile.setText("File");

		this.jMenuItemPrint.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
		this.jMenuItemPrint.setText("Print");
		this.jMenuFile.add(this.jMenuItemPrint);

		this.jMenuBar.add(this.jMenuFile);

		this.jMenuHelp.setText("Help");

		this.jMenuItemAbout.setText("About");
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
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addGap(172, 172, 172)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(this.jLabelLatitude, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(this.jLabelLongitude, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(this.jLabelDate, javax.swing.GroupLayout.Alignment.TRAILING))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(this.jTextFieldLatitude, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(this.jLabelLatiDeg)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(this.jComboBoxFractionOrDegArcSec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addComponent(this.jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(layout.createSequentialGroup()
														.addComponent(this.jTextFieldLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(this.jLabelLongDeg))
														.addGroup(layout.createSequentialGroup()
																.addComponent(this.jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(this.jLabelDateMDY)))
																.addContainerGap(119, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(this.jLabelLatitude)
								.addComponent(this.jTextFieldLatitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(this.jLabelLatiDeg)
								.addComponent(this.jComboBoxFractionOrDegArcSec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(this.jTextFieldLongitude, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(this.jLabelLongitude)
										.addComponent(this.jLabelLongDeg))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(this.jLabelDate)
												.addComponent(this.jTextFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(this.jLabelDateMDY))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(this.jButtonSearch)
												.addContainerGap(400, Short.MAX_VALUE))
				);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutActionPerformed
		new AboutPage(this, this.rootPaneCheckingEnabled).setVisible(true);
		//TODO make this pretty?
	}//GEN-LAST:event_jMenuItemAboutActionPerformed

	private void tooltiplatitudeEnter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tooltiplatitudeEnter
		if (this.jComboBoxFractionOrDegArcSec.getSelectedItem().equals(SunDialFrame.popupLat)) {
			this.jTextFieldLatitude.setToolTipText(SunDialFrame.format);
		}
	}//GEN-LAST:event_tooltiplatitudeEnter

	private void tooltipLatExit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tooltipLatExit
		if (this.jComboBoxFractionOrDegArcSec.getSelectedItem().equals(SunDialFrame.popupLat)) {
			this.jTextFieldLatitude.setToolTipText(null);
		}
	}//GEN-LAST:event_tooltipLatExit

	private void tooltipLongEnter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tooltipLongEnter
		if (this.jComboBoxFractionOrDegArcSec.getSelectedItem().equals(SunDialFrame.popupLat)) {
			this.jTextFieldLongitude.setToolTipText(SunDialFrame.format);
		}
	}//GEN-LAST:event_tooltipLongEnter

	private void tooltipLongExit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tooltipLongExit
		if (this.jComboBoxFractionOrDegArcSec.getSelectedItem().equals(SunDialFrame.popupLat)) {
			this.jTextFieldLongitude.setToolTipText(null);
		}
	}//GEN-LAST:event_tooltipLongExit

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
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
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SunDialFrame().setVisible(true);
			}
		});
	}
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButtonSearch;
	@SuppressWarnings("rawtypes")
	private javax.swing.JComboBox jComboBoxFractionOrDegArcSec;
	private javax.swing.JLabel jLabelDate;
	private javax.swing.JLabel jLabelDateMDY;
	private javax.swing.JLabel jLabelLatiDeg;
	private javax.swing.JLabel jLabelLatitude;
	private javax.swing.JLabel jLabelLongDeg;
	private javax.swing.JLabel jLabelLongitude;
	private javax.swing.JMenuBar jMenuBar;
	private javax.swing.JMenu jMenuFile;
	private javax.swing.JMenu jMenuHelp;
	private javax.swing.JMenuItem jMenuItemAbout;
	private javax.swing.JMenuItem jMenuItemPrint;
	private javax.swing.JTextField jTextFieldDate;
	private javax.swing.JTextField jTextFieldLatitude;
	private javax.swing.JTextField jTextFieldLongitude;
	// End of variables declaration//GEN-END:variables
}
