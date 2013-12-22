package vistra.gui.view.component.viewer.popup;

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
public class VertexPopup extends JPopupMenu {

	private static final long serialVersionUID = 3273304014704565148L;

	/**
	 * A field for an vertex property menu item.
	 */
	private final VertexProperty menuItemVertexProperty;

	/**
	 * Main constructor.
	 * 
	 * @param top
	 *            the top frame
	 * @param viewer
	 *            a visualization viewer
	 */
	public VertexPopup(JFrame top, VisualizationViewer<IVertex, IEdge> viewer) {
		super("vertexPopup");
		this.menuItemVertexProperty = new VertexProperty(viewer);
		this.menuItemVertexProperty.setRootFrame(top);
		this.add(new CheckBoxStart(viewer));
		this.add(new CheckBoxEnd(viewer));
		this.addSeparator();
		this.add(this.menuItemVertexProperty);
		this.addSeparator();
		this.add(new VertexDelete(viewer));
	}

}
