package vistra.gui.view.component.viewer.popup;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.gui.IGuiModel;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * An edge pop-up menu.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgePopup extends JPopupMenu {

	private static final long serialVersionUID = 2640685878709501654L;

	/**
	 * A field for a property menu item.
	 */
	private EdgeProperty property;

	/**
	 * A field for a delete menu item.
	 */
	private EdgeDelete delete;

	/**
	 * Main constructor.
	 * 
	 * @param top
	 *            the top frame
	 * @param viewer
	 *            the visualization viewer
	 * @param model
	 *            the gui model
	 */
	public EdgePopup(JFrame top,
			VisualizationViewer<IVertexLayout, IEdgeLayout> viewer,
			IGuiModel model) {
		super(model.getResourceBundle().getString("edge.label"));
		/**/
		this.property = new EdgeProperty(viewer, model);
		this.property.setRootFrame(top);
		this.delete = new EdgeDelete(viewer, model);
		/**/
		this.add(this.property);
		this.addSeparator();
		this.add(this.delete);
	}
}
