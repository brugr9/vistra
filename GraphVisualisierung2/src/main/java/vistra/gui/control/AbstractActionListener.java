package vistra.gui.control;

import java.awt.event.ActionListener;

import vistra.gui.IModel;

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
	protected final IModel model;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model
	 */
	AbstractActionListener(IModel model) {
		super();
		this.model = model;
	}

}
