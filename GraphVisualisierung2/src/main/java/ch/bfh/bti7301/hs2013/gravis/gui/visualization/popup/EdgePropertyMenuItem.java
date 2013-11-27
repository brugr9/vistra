package ch.bfh.bti7301.hs2013.gravis.gui.visualization.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.JMenuItem;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.gui.visualization.dialog.EdgePropertyDialog;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class EdgePropertyMenuItem extends JMenuItem implements
		GraphItemMenuListener {

	private static final long serialVersionUID = -1894264493446725645L;

	private final VisualizationViewer<IVertex, IEdge> vViewer;

	private IEdge edge = null;

	private Point2D point = null;

	/**
	 * @param vViewer
	 * 
	 */
	protected EdgePropertyMenuItem(VisualizationViewer<IVertex, IEdge> vViewer) {
		super("Kante bearbeiten...");

		this.vViewer = vViewer;
	}

	/**
	 * @param rootFrame
	 */
	protected void setRootFrame(final JFrame rootFrame) {
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EdgePropertyMenuItem.this.showDialog(rootFrame);
			}
		});
	}

	/**
	 * @param rootFrame
	 */
	protected void showDialog(JFrame owner) {
		if (this.point != null && this.edge != null) {
			EdgePropertyDialog dialog = new EdgePropertyDialog(this.edge,
					owner, this.vViewer);
			dialog.setLocation((int) this.point.getX() + owner.getX(),
					(int) this.point.getY() + owner.getY());
			dialog.setVisible(true);
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
		if (item instanceof IEdge) {
			this.edge = (IEdge) item;
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
		if (point != null) {
			this.point = point;
		}
	}

}
