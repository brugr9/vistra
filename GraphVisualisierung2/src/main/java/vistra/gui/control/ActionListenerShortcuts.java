package vistra.gui.control;

import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import vistra.gui.IGuiModel;

/**
 * A listener for getting some help.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
final class ActionListenerShortcuts extends AbstractActionListener {

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model
	 */
	ActionListenerShortcuts(IGuiModel model) {
		super(model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ResourceBundle b = this.model.getResourceBundle();
		try {
			JOptionPane.showMessageDialog(null,
					this.model.getShortcutsMessage(),
					b.getString("help.label"), 1, null);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(),
					b.getString("app.label"), 1, null);
			ex.printStackTrace();
		}
	}

}
