package travis.gui.view.component.visualization.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import travis.core.graph.item.IGraphItem;
import travis.core.graph.item.edge.IEdge;
import travis.core.graph.item.vertex.IVertex;
import travis.gui.view.component.visualization.dialog.VertexPropertyDialog;

import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class MenuItemVertexProperty extends JMenuItem implements IGraphItemModifier {

	private static final long serialVersionUID = 3448304253580836407L;

	private final VisualizationViewer<IVertex, IEdge> vViewer;

	/**
	 * A field for a vertex.
	 */
	private IVertex vertex;

	/**
	 * A field for a point.
	 */
	private Point2D point;

	/**
	 * @param vViewer
	 */
	protected MenuItemVertexProperty(VisualizationViewer<IVertex, IEdge> vViewer) {
		super("Knoten bearbeiten...");
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
			VertexPropertyDialog dialog = new VertexPropertyDialog(this.vertex,
					owner, this.vViewer);
			dialog.setLocation((int) this.point.getX() + owner.getX(),
					(int) this.point.getY() + owner.getY());
			dialog.setVisible(true);
		}
	}

	@Override
	public void setGraphItemAndView(IGraphItem item) {
		if (item instanceof IVertex) {
			this.vertex = (IVertex) item;
		}
	}

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
				MenuItemVertexProperty.this.showDialog(rootFrame);
			}
		});
	}

}
