package vistra.gui.view.component.viewer.popup;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.gui.IGuiModel;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * A vertex pop-up menu.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexPopup extends JPopupMenu {

	private static final long serialVersionUID = 3273304014704565148L;

	/**
	 * A field for a start check box.
	 */
	private CheckBoxStart start;
	/**
	 * A field for an end check box.
	 */
	private CheckBoxEnd end;
	/**
	 * A field for a property menu item.
	 */
	private VertexProperty property;
	/**
	 * A field for a delete menu item.
	 */
	private VertexDelete delete;

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
	public VertexPopup(JFrame top,
			VisualizationViewer<IVertexLayout, IEdgeLayout> viewer,
			IGuiModel model) {
		super(model.getResourceBundle().getString("vertex.label"));
		/**/
		this.start = new CheckBoxStart(viewer, model);
		this.end = new CheckBoxEnd(viewer, model);
		this.property = new VertexProperty(viewer, model);
		this.property.setRootFrame(top);
		this.delete = new VertexDelete(viewer, model);
		/**/
		this.add(this.start);
		this.add(this.end);
		this.addSeparator();
		this.add(this.property);
		this.addSeparator();
		this.add(this.delete);
	}

}
