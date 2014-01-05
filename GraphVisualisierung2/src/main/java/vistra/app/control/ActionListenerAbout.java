package vistra.app.control;

import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import vistra.app.IGuiModel;

/**
 * A listener for getting some background information about the program.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
final class ActionListenerAbout extends AbstractActionListener {

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model
	 */
	ActionListenerAbout(IGuiModel model) {
		super(model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		ResourceBundle b = this.model.getResourceBundle();
		try {
			JOptionPane.showMessageDialog(null, this.model.getAboutMessage(),
					b.getString("about.label"), 1, null);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(),
					b.getString("app.label"), 1, null);
			ex.printStackTrace();
		}
	}
}