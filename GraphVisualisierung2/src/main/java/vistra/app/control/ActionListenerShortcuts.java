package vistra.app.control;

import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import vistra.app.IModel;

/**
 * A help action listener.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class ActionListenerShortcuts extends AbstractActionListener {

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model
	 */
	public ActionListenerShortcuts(IModel model) {
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
