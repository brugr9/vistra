package vistra.gui.control;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import vistra.gui.IModel;

/**
 * A listener for getting a list of shortcuts.
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
			+ "<li><b>Mousewheel</b> scales with a crossover value of 1.0.<p>"
			+ "     - scales the graph layout when the combined scale is greater than 1<p>"
			+ "     - scales the graph view when the combined scale is less than 1"
			+ "</ul>"
			+ "<h3>Picking Mode:</h3>"
			+ "<ul>"
			+ "<li><b>Left-click</b> elsewhere: unselects all Vertices"
			+ "<li><b>Left-click + drag</b> elsewhere: selects Vertices in a region"
			+ "<li><b>Left-click</b> on a Vertex: selects the vertex"
			+ "<li><b>Left-click + drag</b> on a Vertex: moves all selected Vertices"
			+ "<li><b>CTRL + Left-click</b> on a Vertex: selects the vertex and centers the display on it"
			+ "<li><b>Shift + Left-click</b> on a Vertex: adds/removes Vertex selection"
			+ "<li><b>Shift + Left-click + drag</b> adds selection of Vertices in a new region"
			+ "</ul>"
			+ "<h3>Edit Graph:</h3>"
			+ "<ul>"
			+ "<li><b>Left-click</b> an empty area to create a Vertex"
			+ "<li><b>Left-click + drag</b> from a first Vertex to another Vertex to create an edge"
			+ "<li><b>Left-Double-click</b> on a vertex or edge allows you to edit the label"
			+ "<li><b>Right-click</b> an empty area for a Create Vertex popup"
			+ "<li><b>Right-click</b> on a Vertex for an Edit Vertex popup"
			+ "<li><b>Right-click</b> on an Edge for an Edit Edge popup"
			+ "</ul>" + "</html>";

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            the model
	 */
	ActionListenerHelp(IModel model) {
		super(model);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			JOptionPane.showMessageDialog(null, this.shortCuts, this.model
					.getResourceBundle().getString("help.label"), 1, null);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(), this.model
					.getResourceBundle().getString("app.label"), 1, null);
			ex.printStackTrace();
		}
	}

}
