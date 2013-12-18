package travis.gui.view.component.visualization.popup;

import javax.swing.JFrame;
import javax.swing.JPopupMenu;

import travis.core.graph.item.edge.IEdge;
import travis.core.graph.item.vertex.IVertex;

import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class MenuVertex extends JPopupMenu {

	private static final long serialVersionUID = 3273304014704565148L;

	private final MenuItemVertexProperty menuItemVertexProperty;

	/**
	 * 
	 * @param vViewer
	 */
	public MenuVertex(JFrame rootFrame,
			VisualizationViewer<IVertex, IEdge> vViewer) {
		super("Knoten");

		this.menuItemVertexProperty = new MenuItemVertexProperty(vViewer);
		this.menuItemVertexProperty.setRootFrame(rootFrame);
		this.add(new CheckBoxStartVertex(vViewer));
		this.add(new CheckBoxEndVertex(vViewer));
		this.addSeparator();
		this.add(this.menuItemVertexProperty);
		this.addSeparator();
		this.add(new MenuItemDeleteVertex(vViewer));
	}

}
