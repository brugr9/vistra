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
class VertexDelete extends JMenuItem implements IItemModifier {

	private static final long serialVersionUID = -4699986300655692795L;
	/**
	 * 
	 */
	private IVertexLayout vertex;
	/**
	 * 
	 */
	private final VisualizationViewer<IVertexLayout, IEdgeLayout> vViewer;

	/**
	 * 
	 * @param vViewer
	 */
	protected VertexDelete(
			VisualizationViewer<IVertexLayout, IEdgeLayout> vViewer) {
		super("Delete vertex");

		this.vViewer = vViewer;

		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VertexDelete.this.deleteVertex();
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
	public void setGraphItemAndView(IItemLayout item) {
		if (item instanceof IVertexLayout) {
			this.vertex = (IVertexLayout) item;
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