package vistra.gui.view.component.viewer.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import vistra.core.graph.item.IItemLayout;
import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import vistra.core.graph.item.vertex.VertexFactory;
import vistra.gui.view.component.viewer.Viewer;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * A menu factory.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class MenuFactory extends JPopupMenu implements IItemModifier {

	private static final long serialVersionUID = 6897658442329318591L;
	/**
	 * A field for a visualization viewer.
	 */
	private final VisualizationViewer<IVertex, IEdge> viewer;
	/**
	 * A field for a 2D point.
	 */
	private Point2D point2D = null;

	/**
	 * Main constructor.
	 * 
	 * @param viewer
	 *            an adapted visualization viewer
	 */
	public MenuFactory(Viewer viewer) {
		super("Neuer Knoten");
		this.viewer = viewer;

		JMenuItem newVertexMenuItem = new JMenuItem("Neuer Knoten");
		this.add(newVertexMenuItem);
		newVertexMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MenuFactory.this.createVertex();
			}
		});
	}

	/**
	 * Creates a vertex.
	 */
	private void createVertex() {
		if (this.point2D != null) {
			VertexFactory vertexFactory = new VertexFactory();
			IVertex vertex = vertexFactory.create();
			Layout<IVertex, IEdge> layout = this.viewer.getGraphLayout();
			Point2D newPoint = this.viewer.getRenderContext()
					.getMultiLayerTransformer().inverseTransform(this.point2D);

			vertex.setLocation(newPoint);
			layout.getGraph().addVertex(vertex);
			layout.setLocation(vertex, newPoint);
			this.viewer.repaint();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGraphItemAndView(IItemLayout item) {
		// does nothing
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGraphItemLocation(Point2D point) {
		if (point != null) {
			this.point2D = point;
		}
	}

}
