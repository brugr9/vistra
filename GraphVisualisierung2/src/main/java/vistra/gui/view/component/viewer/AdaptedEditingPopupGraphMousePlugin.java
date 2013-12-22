package vistra.gui.view.component.viewer;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import javax.swing.JPopupMenu;

import org.apache.commons.collections15.Factory;

import vistra.core.graph.item.IGraphItem;
import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import vistra.gui.view.component.viewer.popup.IItemModifier;
import edu.uci.ics.jung.algorithms.layout.GraphElementAccessor;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.EditingPopupGraphMousePlugin;

/**
 * An adapted JUNG mouse plugin that uses popup menus to create vertices,
 * undirected edges, and directed edges.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class AdaptedEditingPopupGraphMousePlugin extends
		EditingPopupGraphMousePlugin<IVertex, IEdge> {

	/**
	 * A field for an edge popup menu.
	 */
	private JPopupMenu edgePopup = null;
	/**
	 * A field for a vertex popup menu.
	 */
	private JPopupMenu vertexPopup = null;
	/**
	 * A field for a create vertex popup menu.
	 */
	private JPopupMenu createVertexPopup = null;

	/**
	 * Main constructor.
	 * 
	 * @param vertexFactory
	 *            a vertex factory
	 * @param edgeFactory
	 *            an edge factory
	 */
	public AdaptedEditingPopupGraphMousePlugin(Factory<IVertex> vertexFactory,
			Factory<IEdge> edgeFactory) {
		super(vertexFactory, edgeFactory);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void handlePopup(MouseEvent e) {
		if (e.getSource() instanceof VisualizationViewer<?, ?>) {
			@SuppressWarnings("unchecked")
			VisualizationViewer<IVertex, IEdge> vViewer = (VisualizationViewer<IVertex, IEdge>) e
					.getSource();
			Point2D point = e.getPoint();
			GraphElementAccessor<IVertex, IEdge> pickSupport = vViewer
					.getPickSupport();

			if (pickSupport != null) {
				IVertex vertex = pickSupport.getVertex(
						vViewer.getGraphLayout(), point.getX(), point.getY());

				if (vertex != null && this.vertexPopup != null) {
					this.updateItemMenu(vertex, point, this.vertexPopup);
					this.vertexPopup.show(vViewer, e.getX(), e.getY());
				}

				IEdge edge = pickSupport.getEdge(vViewer.getGraphLayout(),
						point.getX(), point.getY());

				if (edge != null && this.edgePopup != null) {
					this.updateItemMenu(edge, point, this.edgePopup);
					this.edgePopup.show(vViewer, e.getX(), e.getY());

				}

				if (edge == null && vertex == null
						&& this.createVertexPopup != null) {
					if (this.createVertexPopup instanceof IItemModifier) {
						((IItemModifier) this.createVertexPopup)
								.setGraphItemLocation(point);
					}
					this.createVertexPopup.show(vViewer, e.getX(), e.getY());
				}
			}
		}
	}

	/**
	 * Updates an item menu.
	 * 
	 * @param item
	 *            the item
	 * @param point
	 *            a point
	 * @param popUp
	 *            a popup
	 */
	private void updateItemMenu(IGraphItem item, Point2D point, JPopupMenu popUp) {
		for (Component comp : popUp.getComponents()) {
			if (comp instanceof IItemModifier) {
				((IItemModifier) comp).setGraphItemAndView(item);
				((IItemModifier) comp).setGraphItemLocation(point);
			}
		}
	}

	/**
	 * Setter for the Edge popup.
	 * 
	 * @param edgePopup
	 *            an edge popup
	 */
	public void setEdgePopup(JPopupMenu edgePopup) {
		this.edgePopup = edgePopup;
	}

	/**
	 * Setter for the vertex popup.
	 * 
	 * @param vertexPopup
	 *            a vertex popup
	 */
	public void setVertexPopup(JPopupMenu vertexPopup) {
		this.vertexPopup = vertexPopup;
	}

	/**
	 * Setter for the create vertex popup.
	 * 
	 * @param createVertexPopup
	 *            a createVertexPopup
	 */
	public void setVertexCreatePopup(JPopupMenu createVertexPopup) {
		this.createVertexPopup = createVertexPopup;
	}

}
