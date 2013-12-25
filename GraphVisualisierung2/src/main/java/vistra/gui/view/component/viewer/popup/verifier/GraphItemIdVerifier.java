package vistra.gui.view.component.viewer.popup.verifier;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

import vistra.core.graph.IExtendedGraph;
import vistra.core.graph.item.ILayoutItem;
import vistra.core.graph.item.edge.ILayoutEdge;
import vistra.core.graph.item.vertex.ILayoutVertex;
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
	private final ILayoutItem graphItem;
	/**
	 * A field for a graph.
	 */
	private final Graph<ILayoutVertex, ILayoutEdge> graph;

	/**
	 * Main constructor.
	 * 
	 * @param lastGood
	 * @param graphItem
	 *            a graph item
	 * @param vViewer
	 *            a visualization viewer
	 */
	public GraphItemIdVerifier(String lastGood, ILayoutItem graphItem,
			VisualizationViewer<ILayoutVertex, ILayoutEdge> vViewer) {
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

			return !textField.getText().trim().isEmpty()
					&& (textField.getText().equals(
							((ILayoutItem) this.graphItem).getId()) || graph
							.unused(textField.getText().trim()));
		}

		return false;
	}

}