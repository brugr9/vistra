package vistra.gui.view.mouse.popup;

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
class EdgeDelete extends JMenuItem implements IItemModifier {

	private static final long serialVersionUID = -8344732316212412105L;

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
	private IEdgeLayout edge;

	/**
	 * Main constructor.
	 * 
	 * @param vViewer
	 *            a visualization viewer
	 * @param model
	 *            a gui model
	 */
	protected EdgeDelete(
			VisualizationViewer<IVertexLayout, IEdgeLayout> vViewer,
			IGuiModel model) {
		super(model.getResourceBundle().getString("delete.label"));
		this.vViewer = vViewer;
		this.model = model;
		this.edge = null;
		/**/
		this.setActionCommand(EventSource.EDIT_GRAPH.toString());
		this.addActionListener(model.getParameterStateHandler());
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EdgeDelete.this.deleteEdge();
			}
		});
	}

	/**
	 * Deletes the edge.
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
			this.setText(this.model.getResourceBundle().getString(
					"delete.label"));
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
