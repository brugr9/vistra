package vistra.gui.view.component.viewer.popup;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * An edge pop up menu.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgePopup extends JPopupMenu {

	private static final long serialVersionUID = 2640685878709501654L;

	/**
	 * A field for an edge property menu item.
	 */
	private final EdgeProperty property;

	/**
	 * Main constructor.
	 * 
	 * @param top
	 *            the top frame
	 * @param viewer
	 *            a visualization viewer
	 */
	public EdgePopup(JFrame top, VisualizationViewer<IVertexLayout, IEdgeLayout> viewer) {
		super("edgePopup");
		this.property = new EdgeProperty(viewer);
		this.property.setRootFrame(top);
		this.add(this.property);
		this.addSeparator();
		this.add(new EdgeDelete(viewer));
	}
}
