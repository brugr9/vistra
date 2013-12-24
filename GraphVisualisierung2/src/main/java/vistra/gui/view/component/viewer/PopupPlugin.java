package vistra.gui.view.component.viewer;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import javax.swing.JPopupMenu;

import org.apache.commons.collections15.Factory;

import vistra.core.graph.item.IItemLayout;
import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import vistra.gui.view.component.viewer.popup.IItemModifier;
import edu.uci.ics.jung.algorithms.layout.GraphElementAccessor;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.EditingPopupGraphMousePlugin;

/**
 * An adapted JUNG mouse plugin that uses popup menus to create vertices and
 * edges.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class PopupPlugin extends EditingPopupGraphMousePlugin<IVertex, IEdge> {

	/**
	 * A field for an edge popup menu.
	 */
	private JPopupMenu edgePopup;
	/**
	 * A field for a vertex popup menu.
	 */
	private JPopupMenu vertexPopup;
	/**
	 * A field for a switch mode popup menu.
	 */
	private JPopupMenu switchMode;

	/**
	 * Main constructor.
	 * 
	 * @param vertexFactory
	 *            a vertex factory
	 * @param edgeFactory
	 *            an edge factory
	 */
	public PopupPlugin(Factory<IVertex> vertexFactory,
			Factory<IEdge> edgeFactory) {
		super(vertexFactory, edgeFactory);
		this.edgePopup = null;
		this.vertexPopup = null;
		this.switchMode = null;
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

				if (edge == null && vertex == null && this.switchMode != null) {
					if (this.switchMode instanceof IItemModifier) {
						((IItemModifier) this.switchMode)
								.setGraphItemLocation(point);
					}
					this.switchMode.show(vViewer, e.getX(), e.getY());
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
	private void updateItemMenu(IItemLayout item, Point2D point,
			JPopupMenu popUp) {
		for (Component comp : popUp.getComponents()) {
			if (comp instanceof IItemModifier) {
				((IItemModifier) comp).setGraphItemAndView(item);
				((IItemModifier) comp).setGraphItemLocation(point);
			}
		}
	}

	/**
	 * Setter for the edge popup.
	 * 
	 * @param popup
	 *            a popup
	 */
	public void setEdgePopup(JPopupMenu popup) {
		this.edgePopup = popup;
	}

	/**
	 * Setter for the vertex popup.
	 * 
	 * @param popup
	 *            a popup
	 */
	public void setVertexPopup(JPopupMenu popup) {
		this.vertexPopup = popup;
	}

	/**
	 * Setter for the switch-mode popup.
	 * 
	 * @param popup
	 *            a popup
	 */
	public void setSwitchModePopup(JPopupMenu popup) {
		this.switchMode = popup;
	}

}
