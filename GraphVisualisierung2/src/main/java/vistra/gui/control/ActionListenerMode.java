package vistra.gui.control;

import static vistra.gui.control.IControl.EventSource.MODE;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode;

import vistra.gui.IGuiModel;

/**
 * A mode action listener.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class ActionListenerMode extends AbstractActionListener {

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model
	 */
	ActionListenerMode(IGuiModel model) {
		super(model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			String c = e.getActionCommand();
			this.model.setMode(Mode.valueOf(c));
			this.model.notifyObservers(MODE);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(), this.model
					.getResourceBundle().getString("app.label"), 1, null);
			ex.printStackTrace();
		}

	}

}
