package vistra.app.control;

import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import vistra.app.IGuiModel;

/**
 * A listener for quitting the program.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
final class ActionListenerQuit extends AbstractActionListener {

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model
	 */
	ActionListenerQuit(IGuiModel model) {
		super(model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ResourceBundle b = this.model.getResourceBundle();
		int value = JOptionPane.showConfirmDialog(null,
				b.getString("quit.message"), b.getString("app.label"),
				JOptionPane.YES_NO_OPTION);
		if (value == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}
