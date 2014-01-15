package vistra.app;

import java.awt.EventQueue;

import javax.swing.JOptionPane;

import vistra.app.view.ViewFactory.ViewType;

/**
 * Startup: Application entry point.
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
		 EventQueue.invokeLater(new Runnable() {
		 @Override
		 public void run() {
		try {
			AppFactory.createApp(ViewType.DEFAULT);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString() + e.getCause(),
					null, 1, null);
			e.printStackTrace();
		}
			}
		});
	}

}
