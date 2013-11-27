package ch.bfh.bti7301.hs2013.gravis.gui.visualization.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.JMenuItem;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class DeleteEdgeMenuItem extends JMenuItem implements
		GraphItemMenuListener {

	private static final long serialVersionUID = -8344732316212412105L;

	private IEdge edge;

	private final VisualizationViewer<IVertex, IEdge> vViewer;

	/**
	 * @param vViewer
	 */
	protected DeleteEdgeMenuItem(VisualizationViewer<IVertex, IEdge> vViewer) {
		super("Kante löschen");

		this.vViewer = vViewer;

		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteEdgeMenuItem.this.deleteEdge();
			}
		});
	}

	private void deleteEdge() {
		this.vViewer.getPickedEdgeState().pick(this.edge, false);
		this.vViewer.getGraphLayout().getGraph().removeEdge(this.edge);
		this.vViewer.repaint();
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
		if (item instanceof IEdge) {
			this.edge = (IEdge) item;
			this.setText("Kante " + this.edge.getId() + " löschen");
		}
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
		// does nothing
	}
}
