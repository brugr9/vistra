package vistra.app;

import javax.swing.JOptionPane;

import vistra.app.AppFactory.ViewType;

/**
 * Startup.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class Startup {

	/**
	 * The program starter.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// EventQueue.invokeLater(new Runnable() {
		// @Override
		// public void run() {
		try {
			AppFactory.createApplication(ViewType.DEFAULT);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(
					null,
					"Sorry, somthing went totally wrong:\n" + e.toString()
							+ e.getCause(), null, 1, null);
			e.printStackTrace();
		}
		// }
		// });
	}

}
