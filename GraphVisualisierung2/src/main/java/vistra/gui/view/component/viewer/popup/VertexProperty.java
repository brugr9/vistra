package vistra.gui.view.component.viewer.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IItemLayout;
import vistra.core.graph.item.IVertexLayout;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * An vertex property menu item.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class VertexProperty extends JMenuItem implements IItemModifier {

	private static final long serialVersionUID = 3448304253580836407L;

	private final VisualizationViewer<IVertexLayout, IEdgeLayout> vViewer;

	/**
	 * A field for a vertex.
	 */
	private IVertexLayout vertex;

	/**
	 * A field for a point.
	 */
	private Point2D point;

	/**
	 * @param vViewer
	 */
	protected VertexProperty(
			VisualizationViewer<IVertexLayout, IEdgeLayout> vViewer) {
		super("Edit vertex ...");
		this.vViewer = vViewer;
		this.vertex = null;
		this.point = null;
	}

	/**
	 * 
	 * @param owner
	 */
	private void showDialog(JFrame owner) {
		if (this.point != null && this.vertex != null) {
			VertexDialog dialog = new VertexDialog(this.vertex, owner,
					this.vViewer);
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
		if (item instanceof IVertexLayout) {
			this.vertex = (IVertexLayout) item;
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

	/**
	 * @param rootFrame
	 */
	protected void setRootFrame(final JFrame rootFrame) {
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VertexProperty.this.showDialog(rootFrame);
			}
		});
	}

}
