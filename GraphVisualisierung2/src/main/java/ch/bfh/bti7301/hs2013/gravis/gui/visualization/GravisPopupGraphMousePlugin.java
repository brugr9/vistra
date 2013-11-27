package ch.bfh.bti7301.hs2013.gravis.gui.visualization;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import javax.swing.JPopupMenu;

import org.apache.commons.collections15.Factory;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.gui.visualization.popup.GraphItemMenuListener;
import edu.uci.ics.jung.algorithms.layout.GraphElementAccessor;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.EditingPopupGraphMousePlugin;

/**
 * A plugin that uses popup menus to create vertices, undirected edges, and
 * directed edges.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class GravisPopupGraphMousePlugin extends
		EditingPopupGraphMousePlugin<IVertex, IEdge> {

	private JPopupMenu edgePopup = null;

	private JPopupMenu vertexPopup = null;

	private JPopupMenu vertexCreatePopup = null;

	/**
	 * 
	 * @param vertexFactory
	 * @param edgeFactory
	 */
	public GravisPopupGraphMousePlugin(Factory<IVertex> vertexFactory,
			Factory<IEdge> edgeFactory) {
		super(vertexFactory, edgeFactory);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.visualization.control.EditingPopupGraphMousePlugin#
	 * handlePopup(java.awt.event.MouseEvent)
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
						&& this.vertexCreatePopup != null) {
					if (this.vertexCreatePopup instanceof GraphItemMenuListener) {
						((GraphItemMenuListener) this.vertexCreatePopup)
								.setGraphItemLocation(point);
					}
					this.vertexCreatePopup.show(vViewer, e.getX(), e.getY());
				}
			}
		}
	}

	/**
	 * 
	 * @param item
	 * @param point
	 * @param popUp
	 */
	private void updateItemMenu(IGraphItem item, Point2D point, JPopupMenu popUp) {
		for (Component comp : popUp.getComponents()) {
			if (comp instanceof GraphItemMenuListener) {
				((GraphItemMenuListener) comp).setGraphItemAndView(item);
				((GraphItemMenuListener) comp).setGraphItemLocation(point);
			}
		}
	}

	/**
	 * Setter for the Edge popup.
	 * 
	 * @param edgePopup
	 */
	public void setEdgePopup(JPopupMenu edgePopup) {
		this.edgePopup = edgePopup;
	}

	/**
	 * Setter for the vertex popup.
	 * 
	 * @param vertexPopup
	 */
	public void setVertexPopup(JPopupMenu vertexPopup) {
		this.vertexPopup = vertexPopup;
	}

	/**
	 * Setter for the vertex create popup.
	 * 
	 * @param vertexPopup
	 */
	public void setVertexCreatePopup(JPopupMenu vertexCreatePopup) {
		this.vertexCreatePopup = vertexCreatePopup;
	}

}
