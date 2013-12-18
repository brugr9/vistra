package travis.gui.view.component.visualization.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import travis.core.graph.item.IGraphItem;
import travis.core.graph.item.edge.IEdge;
import travis.core.graph.item.vertex.IVertex;
import travis.core.graph.item.vertex.VertexFactory;
import travis.gui.view.component.visualization.GravisVisualizationViewer;

import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * A menu factory.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class MenuFactory extends JPopupMenu implements IGraphItemModifier {

	private static final long serialVersionUID = 6897658442329318591L;
	/**
	 * A field for a vertex factory.
	 */
	private final VertexFactory vertexFactory;
	/**
	 * A field for a visualization viewer.
	 */
	private final VisualizationViewer<IVertex, IEdge> vViewer;
	/**
	 * A field for a 2D point.
	 */
	private Point2D point2D = null;

	/**
	 * Main constructor.
	 * 
	 * @param viewer
	 *            a gravis visualization viewer
	 */
	public MenuFactory(GravisVisualizationViewer viewer) {
		super("Neuer Knoten");

		this.vertexFactory = new VertexFactory();
		this.vViewer = viewer;

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
			IVertex newVertex = this.vertexFactory.create();
			Layout<IVertex, IEdge> layout = this.vViewer.getGraphLayout();
			Point2D newPoint = this.vViewer.getRenderContext()
					.getMultiLayerTransformer().inverseTransform(this.point2D);

			newVertex.setLocation(newPoint);
			layout.getGraph().addVertex(newVertex);
			layout.setLocation(newVertex, newPoint);
			this.vViewer.repaint();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.visualization.GraphItemMenuListener#
	 * setGraphItemAndView
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setGraphItemAndView(IGraphItem item) {
		// // does nothing
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.gui.visualization.GraphItemMenuListener#
	 * setGraphItemLocation(java.awt.geom.Point2D)
	 */
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
