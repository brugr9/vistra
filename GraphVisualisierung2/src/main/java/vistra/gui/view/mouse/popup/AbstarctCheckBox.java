package vistra.gui.view.mouse.popup;

import java.awt.geom.Point2D;

import javax.swing.JCheckBoxMenuItem;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.gui.IGuiModel;
import edu.uci.ics.jung.visualization.VisualizationViewer;

abstract class AbstarctCheckBox extends JCheckBoxMenuItem implements
		IItemModifier {

	private static final long serialVersionUID = 1L;

	/**
	 * A field for a viewer.
	 */
	protected final VisualizationViewer<IVertexLayout, IEdgeLayout> viewer;
	/**
	 * A field for a model.
	 */
	protected IGuiModel model;
	/**
	 * A field for a vertex.
	 */
	protected IVertexLayout vertex;

	/**
	 * Main constructor.
	 * 
	 * @param viewer
	 *            a viewer
	 */
	protected AbstarctCheckBox(
			VisualizationViewer<IVertexLayout, IEdgeLayout> viewer,
			String label, IGuiModel model) {
		super(label);
		this.viewer = viewer;
		this.model = model;
		this.vertex = null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGraphItemLocation(Point2D point) {
		// does nothing
	}

}
