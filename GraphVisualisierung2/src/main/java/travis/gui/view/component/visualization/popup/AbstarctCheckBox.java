package travis.gui.view.component.visualization.popup;

import java.awt.geom.Point2D;
import javax.swing.JCheckBoxMenuItem;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import travis.core.graph.item.edge.IEdge;
import travis.core.graph.item.vertex.IVertex;

public abstract class AbstarctCheckBox extends JCheckBoxMenuItem implements
		IGraphItemModifier {

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
	protected AbstarctCheckBox(VisualizationViewer<IVertex, IEdge> viewer) {
		super();
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
