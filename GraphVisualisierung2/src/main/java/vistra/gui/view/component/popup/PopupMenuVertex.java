package vistra.gui.view.component.popup;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;

import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * A vertex pop up menu.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class PopupMenuVertex extends JPopupMenu {

	private static final long serialVersionUID = 3273304014704565148L;

	/**
	 * A field for an vertex property menu item.
	 */
	private final MenuItemVertexProperty menuItemVertexProperty;

	/**
	 * Main constructor.
	 * 
	 * @param viewer
	 *            a visualization viewer
	 */
	public PopupMenuVertex(JFrame rootFrame,
			VisualizationViewer<IVertex, IEdge> viewer) {
		super("Vertex");

		this.menuItemVertexProperty = new MenuItemVertexProperty(viewer);
		this.menuItemVertexProperty.setRootFrame(rootFrame);
		this.add(new CheckBoxStartVertex(viewer));
		this.add(new CheckBoxEndVertex(viewer));
		this.addSeparator();
		this.add(this.menuItemVertexProperty);
		this.addSeparator();
		this.add(new MenuItemDeleteVertex(viewer));
	}

}
