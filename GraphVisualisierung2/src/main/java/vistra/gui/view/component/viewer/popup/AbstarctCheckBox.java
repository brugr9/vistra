package vistra.gui.view.component.viewer.popup;

import java.awt.geom.Point2D;

import javax.swing.JCheckBoxMenuItem;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import edu.uci.ics.jung.visualization.VisualizationViewer;

public abstract class AbstarctCheckBox extends JCheckBoxMenuItem implements
		IItemModifier {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * A field for a visualization viewer.
	 */
	protected final VisualizationViewer<IVertexLayout, IEdgeLayout> viewer;
	/**
	 * 
	 */
	protected IVertexLayout vertex;

	/**
	 * Main constructor.
	 * 
	 * @param viewer
	 *            a visualization viewer
	 */
	protected AbstarctCheckBox(VisualizationViewer<IVertexLayout, IEdgeLayout> viewer,
			String label) {
		super(label);
		this.viewer = viewer;
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
