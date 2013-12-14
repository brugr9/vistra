package ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.popup;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public class EdgeMenu extends JPopupMenu {

	private static final long serialVersionUID = 2640685878709501654L;
	/**
	 * 
	 */
	private final EdgePropertyMenuItem edgePropertyMenuItem;
	
	
	/**
	 * 
	 * @param vViewer
	 */
	public EdgeMenu(VisualizationViewer<IVertex, IEdge> vViewer) {
		super("Kanten");
		
		this.edgePropertyMenuItem = new EdgePropertyMenuItem(vViewer);
		this.add(this.edgePropertyMenuItem);
		this.addSeparator();
		this.add(new DeleteEdgeMenuItem(vViewer));
	}
	
	/**
	 * @param rootFrame
	 */
	public void setRootFrame(JFrame rootFrame) {
		this.edgePropertyMenuItem.setRootFrame(rootFrame);
	}
}
