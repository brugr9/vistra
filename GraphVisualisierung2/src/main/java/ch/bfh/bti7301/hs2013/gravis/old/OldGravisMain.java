/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.old;

import java.awt.EventQueue;

/**
 * GravisMain
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @deprecated
 */
public class OldGravisMain {

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
					OldApplicationFactory.createMainWindow();
				} catch (Exception e) {
					// TODO exception handling
					e.printStackTrace();
				}
			}
		});
	}

}
