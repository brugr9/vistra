package vistra.gui.view.mouse;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import javax.swing.JPopupMenu;

import org.apache.commons.collections15.Factory;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IItemLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.gui.view.mouse.popup.IItemModifier;
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
public class PopupPlugin extends
		EditingPopupGraphMousePlugin<IVertexLayout, IEdgeLayout> {

	/**
	 * A field for a switch-mode pop-up menu.
	 */
	private JPopupMenu modePopup;
	/**
	 * A field for a vertex pop-up menu.
	 */
	private JPopupMenu vertexPopup;
	/**
	 * A field for an edge pop-up menu.
	 */
	private JPopupMenu edgePopup;

	/**
	 * Main constructor.
	 * 
	 * @param vertexFactory
	 *            a vertex factory
	 * @param edgeFactory
	 *            an edge factory
	 */
	public PopupPlugin(Factory<IVertexLayout> vertexFactory,
			Factory<IEdgeLayout> edgeFactory) {
		super(vertexFactory, edgeFactory);
		this.modePopup = null;
		this.vertexPopup = null;
		this.edgePopup = null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void handlePopup(MouseEvent e) {
		if (e.getSource() instanceof VisualizationViewer<?, ?>) {

			@SuppressWarnings("unchecked")
			VisualizationViewer<IVertexLayout, IEdgeLayout> vViewer = (VisualizationViewer<IVertexLayout, IEdgeLayout>) e
					.getSource();

			Point2D point = e.getPoint();
			GraphElementAccessor<IVertexLayout, IEdgeLayout> pickSupport = vViewer
					.getPickSupport();

			if (pickSupport != null) {
				IVertexLayout vertex = pickSupport.getVertex(
						vViewer.getGraphLayout(), point.getX(), point.getY());

				if (vertex != null && this.vertexPopup != null) {
					this.updateItemMenu(vertex, point, this.vertexPopup);
					this.vertexPopup.show(vViewer, e.getX(), e.getY());
				}

				IEdgeLayout edge = pickSupport.getEdge(
						vViewer.getGraphLayout(), point.getX(), point.getY());

				if (edge != null && this.edgePopup != null) {
					this.updateItemMenu(edge, point, this.edgePopup);
					this.edgePopup.show(vViewer, e.getX(), e.getY());

				}

				if (edge == null && vertex == null && this.modePopup != null) {
					if (this.modePopup instanceof IItemModifier) {
						((IItemModifier) this.modePopup)
								.setGraphItemLocation(point);
					}
					this.modePopup.show(vViewer, e.getX(), e.getY());
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
	 *            a pop-up
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
	 * Setter for the edge pop-up.
	 * 
	 * @param popup
	 *            a pop-up
	 */
	public void setEdgePopup(JPopupMenu popup) {
		this.edgePopup = popup;
	}

	/**
	 * Setter for the vertex pop-up.
	 * 
	 * @param popup
	 *            a pop-up
	 */
	public void setVertexPopup(JPopupMenu popup) {
		this.vertexPopup = popup;
	}

	/**
	 * Setter for the switch-mode pop-up.
	 * 
	 * @param popup
	 *            a pop-up
	 */
	public void setSwitchModePopup(JPopupMenu popup) {
		this.modePopup = popup;
	}

}
