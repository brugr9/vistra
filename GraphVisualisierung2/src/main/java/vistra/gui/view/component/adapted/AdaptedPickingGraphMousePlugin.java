package vistra.gui.view.component.adapted;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.PickingGraphMousePlugin;
import edu.uci.ics.jung.visualization.picking.PickedState;

/**
 * An adapted JUNG mouse plugin for picking a graph.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class AdaptedPickingGraphMousePlugin extends
		PickingGraphMousePlugin<IVertex, IEdge> {

	/**
	 * Main constructor.
	 */
	public AdaptedPickingGraphMousePlugin() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void mouseDragged(MouseEvent e) {
		if (this.locked == false) {
			VisualizationViewer<IVertex, IEdge> vv = (VisualizationViewer<IVertex, IEdge>) e
					.getSource();
			if (this.vertex != null) {
				Point p = e.getPoint();
				Point2D graphPoint = vv.getRenderContext()
						.getMultiLayerTransformer().inverseTransform(p);
				Point2D graphDown = vv.getRenderContext()
						.getMultiLayerTransformer().inverseTransform(this.down);
				Layout<IVertex, IEdge> layout = vv.getGraphLayout();
				double dx = graphPoint.getX() - graphDown.getX();
				double dy = graphPoint.getY() - graphDown.getY();
				PickedState<IVertex> ps = vv.getPickedVertexState();

				for (IVertex v : ps.getPicked()) {
					Point2D vp = layout.transform(v);
					vp.setLocation(vp.getX() + dx, vp.getY() + dy);
					layout.setLocation(v, vp);
					// update the vertex location
					v.setLocation(vp);
				}
				this.down = p;

			} else {
				Point2D out = e.getPoint();
				if (e.getModifiers() == this.addToSelectionModifiers
						|| e.getModifiers() == this.modifiers) {
					this.rect.setFrameFromDiagonal(this.down, out);
				}
			}
			if (this.vertex != null)
				e.consume();
			vv.repaint();
		}
	}

}
