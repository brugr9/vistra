/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.gui.control;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import ch.bfh.bti7301.hs2013.gravis.gui.IModel;

/**
 * A listener for getting a list of shortcuts.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class ActionListenerShortcuts extends AbstractActionListener {

	/**
	 * A field for a list of shortcuts.
	 */
	private final String shortCuts = "<html>"
			+ "<h3>All Modes:</h3>"
			+ "<ul>"
			+ "<li>Right-click an empty area for <b>Create Vertex</b> popup"
			+ "<li>Right-click on a Vertex for <b>Set Start Vertex, Set End Vertex, Edit Vertex, Delete Vertex</b> popup"
			+ "<li>Right-click on an Edge for <b>Edit Edge, Delete Edge</b> popup"
			+ "<li>Mousewheel scales with a crossover value of 1.0.<p>"
			+ "     - scales the graph layout when the combined scale is greater than 1<p>"
			+ "     - scales the graph view when the combined scale is less than 1"
			+ "</ul>"
			+ "<h3>Editing Mode:</h3>"
			+ "<ul>"
			+ "<li>Left-click an empty area to create a new Vertex"
			+ "<li>Left-click on a Vertex and drag to another Vertex to create an undirected or directed edge"
			+ "</ul>"
			+ "<h3>Picking Mode:</h3>"
			+ "<ul>"
			+ "<li>Mouse1 on a Vertex selects the vertex"
			+ "<li>Mouse1 elsewhere unselects all Vertices"
			+ "<li>Mouse1+Shift on a Vertex adds/removes Vertex selection"
			+ "<li>Mouse1+drag on a Vertex moves all selected Vertices"
			+ "<li>Mouse1+drag elsewhere selects Vertices in a region"
			+ "<li>Mouse1+Shift+drag adds selection of Vertices in a new region"
			+ "<li>Mouse1+CTRL on a Vertex selects the vertex and centers the display on it"
			+ "</ul>"
			+ "<h3>Transforming Mode:</h3>"
			+ "<ul>"
			+ "<li>Mouse1+drag pans the graph"
			+ "<li>Mouse1+Shift+drag rotates the graph"
			+ "<li>Mouse1+CTRL(or Command)+drag shears the graph"
			+ "<li>Mouse1 double-click on a vertex or edge allows you to edit the label"
			+ "</ul>" + "</html>";

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            a gravis model
	 */
	public ActionListenerShortcuts(IModel model) {
		super(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
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
