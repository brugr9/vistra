package vistra.gui.view.component.viewer.popup.verifier;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

import vistra.core.graph.IExtendedGraph;
import vistra.core.graph.item.IGraphItem;
import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * A graph item identifier verifier.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class GraphItemIdVerifier extends AbstractVerifier {

	/**
	 * A field for a graph item.
	 */
	private final IGraphItem graphItem;
	/**
	 * A field for a graph.
	 */
	private final Graph<IVertex, IEdge> graph;

	/**
	 * Main constructor.
	 * 
	 * @param lastGood
	 * @param graphItem
	 *            a graph item
	 * @param vViewer
	 *            a visualization viewer
	 */
	public GraphItemIdVerifier(String lastGood, IGraphItem graphItem,
			VisualizationViewer<IVertex, IEdge> vViewer) {
		super(lastGood);
		this.graphItem = graphItem;
		this.graph = vViewer.getGraphLayout().getGraph();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean verify(JComponent input) {

		if (input instanceof JTextComponent) {
			JTextComponent textField = (JTextComponent) input;
			IExtendedGraph graph = (IExtendedGraph) this.graph;

			// TODO
			// return !textField.getText().trim().isEmpty()
			// && (textField.getText().equals(this.graphItem.getId()) || !graph
			// .containsItemId(textField.getText().trim()));
			return false;
		}

		return false;
	}

}