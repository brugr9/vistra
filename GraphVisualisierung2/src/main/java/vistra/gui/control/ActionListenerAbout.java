package vistra.gui.control;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import vistra.gui.IGuiModel;

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
		try {
			JOptionPane.showMessageDialog(null, this.model.getResourceBundle()
					.getString("app.label")
					+ System.lineSeparator()
					+ this.model.getResourceBundle().getString("about.message")
							.replaceAll("\n", System.lineSeparator()),
					this.model.getResourceBundle().getString("about.label"), 1,
					null);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(), this.model
					.getResourceBundle().getString("app.label"), 1, null);
			ex.printStackTrace();
		}
	}

}