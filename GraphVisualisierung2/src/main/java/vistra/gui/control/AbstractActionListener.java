package vistra.gui.control;

import java.awt.event.ActionListener;

import vistra.gui.IGuiModel;

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
	protected final IGuiModel model;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model
	 */
	AbstractActionListener(IGuiModel model) {
		super();
		this.model = model;
	}

}
