package vistra.app.control;

import java.awt.event.ActionListener;

import vistra.app.GuiModel;
import vistra.app.IGuiModel;

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
	protected final GuiModel model;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model
	 */
	AbstractActionListener(IGuiModel model) {
		super();
		this.model = (GuiModel) model;
	}

}
