/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import ch.bfh.bti7301.hs2013.gravis.gui.GuiFactory.ViewType;

/**
 * GravisStartup
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class GravisStartup {

	/**
	 * Program starter
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ApplicationFactory.createApplication(1000, 500,
							ViewType.FULL);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(
							null,
							"Sorry, somthing went totally wrong:\n"
									+ e.toString() + e.getMessage()
									+ e.getCause(), this.getClass().getName(),
							1, null);
					e.printStackTrace();
				}
			}
		});
	}

}
