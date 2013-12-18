/**
 * 
 */
package travis.gui.control;

import java.awt.event.ActionListener;

import travis.gui.IModel;

/**
 * An abstract action listener.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public abstract class AbstractActionListener implements ActionListener {

	/**
	 * A field for a gravis model.
	 */
	protected final IModel model;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model
	 */
	public AbstractActionListener(IModel model) {
		super();
		this.model = model;
	}

}
