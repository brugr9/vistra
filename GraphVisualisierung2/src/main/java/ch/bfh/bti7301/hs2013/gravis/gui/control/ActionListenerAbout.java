/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.gui.control;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import ch.bfh.bti7301.hs2013.gravis.gui.IModel;

/**
 * A listener for getting some background information about the program.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class ActionListenerAbout extends AbstractActionListener {

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            a gravis model
	 */
	public ActionListenerAbout(IModel model) {
		super(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
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