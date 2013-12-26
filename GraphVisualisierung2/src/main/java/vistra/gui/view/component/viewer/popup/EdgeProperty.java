package vistra.gui.view.component.viewer.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import vistra.core.graph.item.IItemLayout;
import vistra.core.graph.item.edge.IEdgeLayout;
import vistra.core.graph.item.vertex.IVertexLayout;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * An edge property menu item.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class EdgeProperty extends JMenuItem implements IItemModifier {

	private static final long serialVersionUID = -1894264493446725645L;

	/**
	 * A field for a visualization viewer.
	 */
	private final VisualizationViewer<IVertexLayout, IEdgeLayout> viewer;
	/**
	 * A field for an edge.
	 */
	private IEdgeLayout edge;
	/**
	 * A field for a point.
	 */
	private Point2D point;

	/**
	 * Main constructor.
	 * 
	 * @param viewer
	 *            a visualization viewer
	 * 
	 */
	protected EdgeProperty(
			VisualizationViewer<IVertexLayout, IEdgeLayout> viewer) {
		super("Edit edge ...");

		this.viewer = viewer;
	}

	/**
	 * @param rootFrame
	 */
	protected void setRootFrame(final JFrame rootFrame) {
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EdgeProperty.this.showDialog(rootFrame);
			}
		});
	}

	/**
	 * @param rootFrame
	 */
	protected void showDialog(JFrame owner) {
		if (this.point != null && this.edge != null) {
			EdgeDialog dialog = new EdgeDialog(this.edge, owner, this.viewer);
			dialog.setLocation((int) this.point.getX() + owner.getX(),
					(int) this.point.getY() + owner.getY());
			dialog.setVisible(true);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGraphItemAndView(IItemLayout item) {
		if (item instanceof IEdgeLayout) {
			this.edge = (IEdgeLayout) item;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGraphItemLocation(Point2D point) {
		if (point != null) {
			this.point = point;
		}
	}

}
