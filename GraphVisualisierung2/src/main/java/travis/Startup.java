package travis;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import travis.gui.GuiFactory.ViewType;

/**
 * Startup.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class Startup {

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
					ApplicationFactory.createApplication(ViewType.FULL);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(
							null,
							"Sorry, somthing went totally wrong:\n"
									+ e.toString() + e.getCause(), this
									.getClass().getName(), 1, null);
					e.printStackTrace();
				}
			}
		});
	}

}
