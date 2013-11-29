package ch.bfh.bti7301.hs2013.gravis.gui.visualization.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.VertexFactory;
import ch.bfh.bti7301.hs2013.gravis.gui.visualization.GravisVisualizationViewer;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class CreateVertexMenu extends JPopupMenu implements
		GraphItemMenuListener {

	private static final long serialVersionUID = 6897658442329318591L;

	private final VertexFactory vertexFactory;

	private final VisualizationViewer<IVertex, IEdge> vViewer;

	private Point2D point = null;

	/**
	 * @param viewer
	 */
	public CreateVertexMenu(GravisVisualizationViewer viewer) {
		super("Neuer Knoten");

		this.vertexFactory = new VertexFactory();
		this.vViewer = viewer;

		JMenuItem newVertexMenuItem = new JMenuItem("Neuer Knoten");
		this.add(newVertexMenuItem);
		newVertexMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CreateVertexMenu.this.createVertex();
			}
		});
	}

	private void createVertex() {
		if (this.point != null) {
			IVertex newVertex = this.vertexFactory.create();
			Layout<IVertex, IEdge> layout = this.vViewer.getGraphLayout();
			Point2D newPoint = this.vViewer.getRenderContext()
			. getMultiLayerTransformer().inverseTransform(this.point);
			
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
	@Override
	public void setGraphItemLocation(Point2D point) {
		if (point != null) {
			this.point = point;
		}
	}

}
