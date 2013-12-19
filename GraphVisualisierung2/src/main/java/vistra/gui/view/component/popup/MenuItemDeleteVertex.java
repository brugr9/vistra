package vistra.gui.view.component.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.JMenuItem;

import vistra.core.zobsolete.graph.item.IGraphItem;
import vistra.core.zobsolete.graph.item.edge.IEdge;
import vistra.core.zobsolete.graph.item.vertex.IVertex;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class MenuItemDeleteVertex extends JMenuItem implements IItemModifier {

	private static final long serialVersionUID = -4699986300655692795L;
	/**
	 * 
	 */
	private IVertex vertex;
	/**
	 * 
	 */
	private final VisualizationViewer<IVertex, IEdge> vViewer;

	/**
	 * 
	 * @param vViewer
	 */
	protected MenuItemDeleteVertex(VisualizationViewer<IVertex, IEdge> vViewer) {
		super("Delete vertex");

		this.vViewer = vViewer;

		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuItemDeleteVertex.this.deleteVertex();
			}
		});
	}

	/**
	 * 
	 */
	private void deleteVertex() {
		if (this.vertex != null) {
			this.vViewer.getPickedVertexState().pick(this.vertex, false);
			this.vViewer.getGraphLayout().getGraph().removeVertex(this.vertex);
			this.vViewer.repaint();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGraphItemAndView(IGraphItem item) {
		if (item instanceof IVertex) {
			this.vertex = (IVertex) item;
			this.setText("Knoten " + this.vertex.getId() + " löschen");
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