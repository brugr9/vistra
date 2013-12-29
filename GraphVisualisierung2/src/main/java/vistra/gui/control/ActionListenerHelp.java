package vistra.gui.control;

import java.awt.event.ActionEvent;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import vistra.gui.IGuiModel;

/**
 * A listener for getting some help.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
final class ActionListenerHelp extends AbstractActionListener {

	/**
	 * A field for a list of shortcuts.
	 */
	private final String shortCuts = "<html>"
			+ "<h3>All Modes:</h3>"
			+ "<ul>"
			+ "<li><b>Mousewheel</b>: Scale the view"
			+ "<li><b>Right-click</b> an empty area: Switch mode"
			+ "</ul>"
			+ "<h3>Edit Mode:</h3>"
			+ "<ul>"
			+ "<li><b>Left-click</b> an empty area: Create a vertex"
			+ "<li><b>Left-click + drag</b> from a first vertex to another vertex: Create an edge"
			+ "<li><b>Left-Double-click</b> on a vertex or edge: Edit the label"
			+ "<li><b>Right-click</b> on a vertex: Edit-vertex popup"
			+ "<li><b>Right-click</b> on an edge: Edit-edge popup"
			+ "</ul>"
			+ "<h3>Picking Mode:</h3>"
			+ "<ul>"
			+ "<li><b>Left-click + drag</b> elsewhere: Select vertices in a region"
			+ "<li><b>Left-click</b> on a vertex: Select the vertex"
			+ "<li><b>Left-click + drag</b> on a vertex: Move all selected vertices"
			+ "<li><b>Left-click</b> elsewhere: Unselect all vertices"
			+ "<li><b>CTRL + Left-click</b> on a vertex: Select the vertex as center and shift view"
			+ "<li><b>Shift + Left-click</b> on a vertex: Add/remove vertex selection"
			+ "<li><b>Shift + Left-click + drag</b>: Add selection of vertices in a new region"
			+ "</ul>" + "</html>";

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model
	 */
	ActionListenerHelp(IGuiModel model) {
		super(model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		ResourceBundle b = this.model.getResourceBundle();
		try {
			// TODO i18n
			String message = this.shortCuts;
			// String message = b.getString("help.message");
			JOptionPane.showMessageDialog(null, message,
					b.getString("help.label"), 1, null);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(),
					b.getString("app.label"), 1, null);
			ex.printStackTrace();
		}
	}

}
