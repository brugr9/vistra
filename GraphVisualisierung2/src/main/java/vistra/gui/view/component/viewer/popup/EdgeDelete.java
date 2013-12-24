package vistra.gui.view.component.viewer.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.JMenuItem;

import vistra.core.graph.item.IItemLayout;
import vistra.core.graph.item.edge.IEdgeLayout;
import vistra.core.graph.item.vertex.IVertexLayout;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class EdgeDelete extends JMenuItem implements IItemModifier {

	private static final long serialVersionUID = -8344732316212412105L;
	/**
	 * A field for an edge.
	 */
	private IEdgeLayout edge;
	/**
	 * A field for a visualization viewer.
	 */
	private final VisualizationViewer<IVertexLayout, IEdgeLayout> vViewer;

	/**
	 * @param vViewer
	 */
	protected EdgeDelete(VisualizationViewer<IVertexLayout, IEdgeLayout> vViewer) {
		super("Delete edge");

		this.vViewer = vViewer;

		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EdgeDelete.this.deleteEdge();
			}
		});
	}

	/**
	 * 
	 */
	private void deleteEdge() {
		this.vViewer.getPickedEdgeState().pick(this.edge, false);
		this.vViewer.getGraphLayout().getGraph().removeEdge(this.edge);
		this.vViewer.repaint();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGraphItemAndView(IItemLayout item) {
		if (item instanceof IEdgeLayout) {
			this.edge = (IEdgeLayout) item;
			this.setText("Kante " + this.edge.getId() + " löschen");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGraphItemLocation(Point2D point) {
		// does nothing
	}
}
