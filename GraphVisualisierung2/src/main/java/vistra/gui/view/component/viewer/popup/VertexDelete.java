package vistra.gui.view.component.viewer.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.JMenuItem;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IItemLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.gui.IGuiModel;
import vistra.gui.control.IControl.EventSource;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class VertexDelete extends JMenuItem implements IItemModifier {

	private static final long serialVersionUID = -4699986300655692795L;

	/**
	 * A field for a visualization viewer.
	 */
	private final VisualizationViewer<IVertexLayout, IEdgeLayout> vViewer;
	/**
	 * A field for a model.
	 */
	private IGuiModel model;
	/**
	 * A field for an edge.
	 */
	private IVertexLayout vertex;

	/**
	 * Main constructor.
	 * 
	 * @param vViewer
	 *            a visualization viewer
	 * @param model
	 *            a gui model
	 */
	protected VertexDelete(
			VisualizationViewer<IVertexLayout, IEdgeLayout> vViewer,
			IGuiModel model) {
		super(model.getResourceBundle().getString("delete.vertex.label"));
		this.vViewer = vViewer;
		this.model = model;
		this.setActionCommand(EventSource.EDIT_GRAPH.toString());
		this.addActionListener(model.getParameterStateHandler());
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VertexDelete.this.deleteVertex();
			}
		});
	}

	/**
	 * Deletes the vertex.
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
			this.setText(this.model.getResourceBundle().getString(
					"delete.vertex.label"));
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