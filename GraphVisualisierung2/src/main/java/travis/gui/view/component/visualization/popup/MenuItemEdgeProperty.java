package travis.gui.view.component.visualization.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import travis.core.graph.item.IGraphItem;
import travis.core.graph.item.edge.IEdge;
import travis.core.graph.item.vertex.IVertex;
import travis.gui.view.component.visualization.dialog.EdgePropertyDialog;

import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * An edge property menu item.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class MenuItemEdgeProperty extends JMenuItem implements IGraphItemModifier {

	private static final long serialVersionUID = -1894264493446725645L;

	/**
	 * A field for a visualization viewer.
	 */
	private final VisualizationViewer<IVertex, IEdge> viewer;
	/**
	 * A field for an edge.
	 */
	private IEdge edge;
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
	protected MenuItemEdgeProperty(VisualizationViewer<IVertex, IEdge> viewer) {
		super("Kante bearbeiten...");

		this.viewer = viewer;
	}

	/**
	 * @param rootFrame
	 */
	protected void setRootFrame(final JFrame rootFrame) {
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuItemEdgeProperty.this.showDialog(rootFrame);
			}
		});
	}

	/**
	 * @param rootFrame
	 */
	protected void showDialog(JFrame owner) {
		if (this.point != null && this.edge != null) {
			EdgePropertyDialog dialog = new EdgePropertyDialog(this.edge,
					owner, this.viewer);
			dialog.setLocation((int) this.point.getX() + owner.getX(),
					(int) this.point.getY() + owner.getY());
			dialog.setVisible(true);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGraphItemAndView(IGraphItem item) {
		if (item instanceof IEdge) {
			this.edge = (IEdge) item;
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
