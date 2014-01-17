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
	 * A field for a list of shortcuts. TODO i18n
	 */
	@SuppressWarnings("nls")
	private final String shortcuts = "<html>"
			+ "<h4>All Modes:</h4>"
			+ "<small>LC = left-click; RC = right-click</small>"
			+ "<ul>"
			+ "<li>Mousewheel: Scale the view"
			+ "<li>RC an empty area: Switch-mode pop-up menu"
			+ "</ul>"
			+ "<h4>Editing Mode:</h4>"
			+ "<ul>"
			+ "<li>LC an empty area: Create a vertex"
			+ "<li>LC + drag from a first to another vertex: Create an edge"
			+ "<li>RC on a vertex: Edit-vertex pop-up menu"
			+ "<li>RC on an edge: Edit-edge pop-up menu"
			+ "</ul>"
			+ "<h4>Picking Mode:</h4>"
			+ "<ul>"
			+ "<li>LC on a vertex: Select the vertex"
			+ "<li>LC + drag elsewhere: Select vertices in a region"
			+ "<li>LC + drag on a vertex: Move all selected vertices"
			+ "<li>LC elsewhere: Unselect all vertices"
			+ "<li>CTRL + LC on a vertex: Select the vertex as center and shift view"
			+ "<li>Shift + LC on a vertex: Add/remove vertex selection"
			+ "<li>Shift + LC + drag: Add selection of vertices in a new region"
			+ "</ul>" + "</html>";

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model
	 */
	public ActionListenerShortcuts(IModel model) {
		super(model);
		// TODO i18n
		this.model.setShortcutsMessage(this.shortcuts);
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
