/**
 * 
 */
package travis.gui.control;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import travis.gui.IModel;

/**
 * A listener for quitting the program.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class ActionListenerQuit extends AbstractActionListener {

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model
	 */
	public ActionListenerQuit(IModel model) {
		super(model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int value = JOptionPane.showConfirmDialog(null, this.model
				.getResourceBundle().getString("quit.message"), this.model
				.getResourceBundle().getString("app.label"),
				JOptionPane.YES_NO_OPTION);
		if (value == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
