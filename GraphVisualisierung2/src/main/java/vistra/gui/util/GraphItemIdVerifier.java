package vistra.gui.util;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

import vistra.core.graph.IGravisGraph;
import vistra.core.graph.item.IGraphItem;
import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * An input verifier for the graph item identifier.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class GraphItemIdVerifier extends AbstractGravisVerifier {

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.InputVerifier#verify(javax.swing.JComponent)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean verify(JComponent input) {
		if (input instanceof JTextComponent
				&& this.graph instanceof IGravisGraph) {
			JTextComponent textField = (JTextComponent) input;
			IGravisGraph gravisGraph = (IGravisGraph) this.graph;

			return !textField.getText().trim().isEmpty()
					&& (textField.getText().equals(this.graphItem.getId()) || !gravisGraph
							.containsItemId(textField.getText().trim()));
		}

		return false;
	}

}