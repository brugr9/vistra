package ch.bfh.bti7301.hs2013.gravis.gui.visualization.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.JCheckBoxMenuItem;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class StartVertexCheckBox extends JCheckBoxMenuItem implements
			GraphItemMenuListener {

		private static final long serialVersionUID = 6641658478963193492L;

		private final VisualizationViewer<IVertex, IEdge> vViewer;
		
		private IVertex vertex = null;
		
		/**
		 * 
		 * @param vViewer
		 */
		protected StartVertexCheckBox(VisualizationViewer<IVertex, IEdge> vViewer) {
			super("Startknoten");

			this.vViewer = vViewer;
			
			this.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					StartVertexCheckBox.this.setValue();
				}
			});
		}

		private void setValue() {
			if (this.vertex != null) {
				this.vertex.setStart(this.isSelected());
				this.vViewer.repaint();
			}
		}
		
		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * ch.bfh.bti7301.hs2013.gravis.gui.visualization.GraphItemMenuListener
		 * #setGraphItemAndView
		 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem)
		 */
		@Override
		public void setGraphItemAndView(IGraphItem item) {
			if (item instanceof IVertex) {
				this.vertex = (IVertex) item;
				this.setSelected(this.vertex.isStart());
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * ch.bfh.bti7301.hs2013.gravis.gui.visualization.GraphItemMenuListener
		 * #setGraphItemLocation(java.awt.geom.Point2D)
		 */
		@Override
		public void setGraphItemLocation(Point2D point) {
			// does nothing
		}

}
