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
public class VertexMenu extends JPopupMenu {

	private static final long serialVersionUID = 3273304014704565148L;

	private final VertexPropertyMenuItem vertexPropertyMenuItem;
	
	/**
	 * 
	 * @param vViewer
	 */
	public VertexMenu(VisualizationViewer<IVertex, IEdge> vViewer) {
		super("Knoten");
		
		this.vertexPropertyMenuItem = new VertexPropertyMenuItem(vViewer);
		this.add(new StartVertexCheckBox(vViewer));
		this.add(new EndVertexCheckBox(vViewer));
		this.addSeparator();
		this.add(this.vertexPropertyMenuItem);
		this.addSeparator();
		this.add(new DeleteVertexMenuItem(vViewer));
	}

	/**
	 * @param rootFrame
	 */
	public void setRootFrame(JFrame rootFrame) {
		this.vertexPropertyMenuItem.setRootFrame(rootFrame);
	}
}
