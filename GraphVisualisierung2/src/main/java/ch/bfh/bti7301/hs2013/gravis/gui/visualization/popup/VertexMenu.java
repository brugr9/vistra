package ch.bfh.bti7301.hs2013.gravis.gui.visualization.popup;

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

	/**
	 * 
	 * @param vViewer
	 */
	public VertexMenu(VisualizationViewer<IVertex, IEdge> vViewer) {
		super("Knoten");
		this.add(new StartVertexCheckBox(vViewer));
		this.add(new EndVertexCheckBox(vViewer));
		//this.add(new tdmCheckBox());
		// this.addSeparator();
		// this.add(new DeleteVertexMenuItem<GraphElements.MyVertex>());
	}
}
