package ch.bfh.bti7301.hs2013.gravis.gui.visualization;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class GravisMouseMenus {

	private GravisMouseMenus() {
	}


//	/**
//	 * A class to implement the deletion of a vertex from within a
//	 * PopupVertexEdgeMenuMousePlugin.
//	 * 
//	 * @author Dr. Greg M. Bernstein
//	 */
//	public class DeleteVertexMenuItem<V> extends JMenuItem implements
//			VertexMenuListener<V> {
//		private V vertex;
//		private VisualizationViewer visComp;
//
//		/** Creates a new instance of DeleteVertexMenuItem */
//		public DeleteVertexMenuItem() {
//			super("Knoten löschen");
//			this.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					visComp.getPickedVertexState().pick(vertex, false);
//					visComp.getGraphLayout().getGraph().removeVertex(vertex);
//					visComp.repaint();
//				}
//			});
//		}
//
//		/**
//		 * Implements the VertexMenuListener interface.
//		 * 
//		 * @param v
//		 * @param visComp
//		 */
//		public void setVertexAndView(V v, VisualizationViewer visComp) {
//			this.vertex = v;
//			this.visComp = visComp;
//			this.setText("Delete Vertex " + v.toString());
//		}
//
//	}

	//
	// public static class EdgeMenu extends JPopupMenu {
	// // private JFrame frame;
	// public EdgeMenu(final JFrame frame) {
	// super("Edge Menu");
	// // this.frame = frame;
	// this.add(new DeleteEdgeMenuItem<GraphElements.MyEdge>());
	// this.addSeparator();
	// this.add(new WeightDisplay());
	// this.add(new CapacityDisplay());
	// this.addSeparator();
	// this.add(new EdgePropItem(frame));
	// }
	//
	// }
	//
	// public static class EdgePropItem extends JMenuItem implements
	// EdgeMenuListener<Samples.MouseMenu.GraphElements.MyEdge>,
	// MenuPointListener {
	// GraphElements.MyEdge edge;
	// VisualizationViewer visComp;
	// Point2D point;
	//
	// public void setEdgeAndView(GraphElements.MyEdge edge,
	// VisualizationViewer visComp) {
	// this.edge = edge;
	// this.visComp = visComp;
	// }
	//
	// public void setPoint(Point2D point) {
	// this.point = point;
	// }
	//
	// public EdgePropItem(final JFrame frame) {
	// super("Edit Edge Properties...");
	// this.addActionListener(new ActionListener() {
	// public void actionPerformed(ActionEvent e) {
	// EdgePropertyDialog dialog = new EdgePropertyDialog(frame,
	// edge);
	// dialog.setLocation((int) point.getX() + frame.getX(),
	// (int) point.getY() + frame.getY());
	// dialog.setVisible(true);
	// }
	//
	// });
	// }
	//
	// }
	//
	// public static class WeightDisplay extends JMenuItem implements
	// EdgeMenuListener<Samples.MouseMenu.GraphElements.MyEdge> {
	// public void setEdgeAndView(GraphElements.MyEdge e,
	// VisualizationViewer visComp) {
	// this.setText("Weight " + e + " = " + e.getWeight());
	// }
	// }
	//
	// public static class CapacityDisplay extends JMenuItem implements
	// EdgeMenuListener<Samples.MouseMenu.GraphElements.MyEdge> {
	// public void setEdgeAndView(GraphElements.MyEdge e,
	// VisualizationViewer visComp) {
	// this.setText("Capacity " + e + " = " + e.getCapacity());
	// }
	// }
	//

	// /**
	// * A class to implement the deletion of an edge from within a
	// * PopupVertexEdgeMenuMousePlugin.
	// * @author Dr. Greg M. Bernstein
	// */
	// public class DeleteEdgeMenuItem<E> extends JMenuItem implements
	// EdgeMenuListener<E> {
	// private E edge;
	// private VisualizationViewer visComp;
	//
	// /** Creates a new instance of DeleteEdgeMenuItem */
	// public DeleteEdgeMenuItem() {
	// super("Delete Edge");
	// this.addActionListener(new ActionListener(){
	// public void actionPerformed(ActionEvent e) {
	// visComp.getPickedEdgeState().pick(edge, false);
	// visComp.getGraphLayout().getGraph().removeEdge(edge);
	// visComp.repaint();
	// }
	// });
	// }
	//
	// /**
	// * Implements the EdgeMenuListener interface to update the menu item with
	// info
	// * on the currently chosen edge.
	// * @param edge
	// * @param visComp
	// */
	// public void setEdgeAndView(E edge, VisualizationViewer visComp) {
	// this.edge = edge;
	// this.visComp = visComp;
	// this.setText("Delete Edge " + edge.toString());
	// }
	//
	// }

}
