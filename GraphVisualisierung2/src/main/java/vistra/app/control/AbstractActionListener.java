package vistra.app.control;

import java.awt.event.ActionListener;

import vistra.app.IModel;
import vistra.app.Model;

/**
 * An abstract action listener.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
abstract class AbstractActionListener implements ActionListener {

	/**
	 * A field for a model.
	 */
	protected final Model model;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model
	 */
	AbstractActionListener(IModel model) {
		super();
		this.model = (Model) model;
	}

}
