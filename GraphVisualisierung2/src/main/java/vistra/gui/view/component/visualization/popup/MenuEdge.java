package vistra.gui.view.component.visualization.popup;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;

import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;

import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * An edge menu.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class MenuEdge extends JPopupMenu {

	private static final long serialVersionUID = 2640685878709501654L;

	/**
	 * A field for an edge property menu item.
	 */
	private final MenuItemEdgeProperty menuItemEdgeProperty;

	/**
	 * Main constructor.
	 * 
	 * @param viewer
	 *            a visualization viewer
	 */
	public MenuEdge(JFrame rootFrame, VisualizationViewer<IVertex, IEdge> viewer) {
		super("Kanten");

		this.menuItemEdgeProperty = new MenuItemEdgeProperty(viewer);
		this.menuItemEdgeProperty.setRootFrame(rootFrame);
		this.add(this.menuItemEdgeProperty);
		this.addSeparator();
		this.add(new MenuItemDeleteEdge(viewer));
	}

}
