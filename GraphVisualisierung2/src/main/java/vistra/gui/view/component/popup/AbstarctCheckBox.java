package vistra.gui.view.component.popup;

import java.awt.geom.Point2D;

import javax.swing.JCheckBoxMenuItem;

import vistra.core.zobsolete.graph.item.edge.IEdge;
import vistra.core.zobsolete.graph.item.vertex.IVertex;
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
	protected final VisualizationViewer<IVertex, IEdge> viewer;
	/**
	 * 
	 */
	protected IVertex vertex;

	/**
	 * Main constructor.
	 * 
	 * @param viewer
	 *            a visualization viewer
	 */
	protected AbstarctCheckBox(VisualizationViewer<IVertex, IEdge> viewer,
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
