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
			+ "<li><b>Mousewheel</b>: scales the view"
			+ "<li><b>Right-click</b> an empty area: Switch Mode"
			+ "</ul>"
			+ "<h3>Edit Mode:</h3>"
			+ "<ul>"
			+ "<li><b>Left-click</b> an empty area: create a Vertex"
			+ "<li><b>Left-click + drag</b> from a first Vertex to another Vertex: create an edge"
			+ "<li><b>Left-Double-click</b> on a vertex or edge: edit the label"
			+ "<li><b>Right-click</b> on a Vertex: Edit-Vertex popup"
			+ "<li><b>Right-click</b> on an Edge: Edit-Edge popup"
			+ "</ul>"
			+ "<h3>Picking Mode:</h3>"
			+ "<ul>"
			+ "<li><b>Left-click + drag</b> elsewhere: selects Vertices in a region"
			+ "<li><b>Left-click</b> on a Vertex: selects the vertex"
			+ "<li><b>Left-click + drag</b> on a Vertex: moves all selected Vertices"
			+ "<li><b>Left-click</b> elsewhere: unselects all Vertices"
			+ "<li><b>CTRL + Left-click</b> on a Vertex: selects the vertex and centers the display on it"
			+ "<li><b>Shift + Left-click</b> on a Vertex: adds/removes Vertex selection"
			+ "<li><b>Shift + Left-click + drag</b> adds selection of Vertices in a new region"
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
			JOptionPane.showMessageDialog(null, this.shortCuts,
					b.getString("help.label"), 1, null);
			// JOptionPane.showMessageDialog(null, b.getString("help.message"),
			// b.getString("help.label"), 1, null);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(),
					b.getString("app.label"), 1, null);
			ex.printStackTrace();
		}
	}

}
