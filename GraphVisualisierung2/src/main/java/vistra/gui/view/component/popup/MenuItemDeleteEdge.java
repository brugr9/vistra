package vistra.gui.view.component.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.JMenuItem;

import vistra.core.graph.zobsolete.item.IGraphItem;
import vistra.core.graph.zobsolete.item.edge.IEdge;
import vistra.core.graph.zobsolete.item.vertex.IVertex;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class MenuItemDeleteEdge extends JMenuItem implements IItemModifier {

	private static final long serialVersionUID = -8344732316212412105L;
	/**
	 * 
	 */
	private IEdge edge;
	/**
	 * 
	 */
	private final VisualizationViewer<IVertex, IEdge> vViewer;

	/**
	 * @param vViewer
	 */
	protected MenuItemDeleteEdge(VisualizationViewer<IVertex, IEdge> vViewer) {
		super("Delete edge");

		this.vViewer = vViewer;

		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuItemDeleteEdge.this.deleteEdge();
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
	public void setGraphItemAndView(IGraphItem item) {
		if (item instanceof IEdge) {
			this.edge = (IEdge) item;
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
