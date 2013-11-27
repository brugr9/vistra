package ch.bfh.bti7301.hs2013.gravis.gui.verifier;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class GraphItemIdVerifier extends AbstractGravisVerifier {

	private final IGraphItem graphItem;

	private final Graph<IVertex, IEdge> graph;

	/**
	 * 
	 * @param lastGood
	 * @param graphItem
	 * @param vViewer
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
	@Override
	public boolean verify(JComponent input) {
		if (input instanceof JTextComponent
				&& this.graph instanceof IGravisGraph) {
			JTextComponent textField = (JTextComponent) input;
			IGravisGraph gravisGraph = (IGravisGraph) this.graph;
			
			return !textField.getText().trim().isEmpty()
					&& (textField.getText()
							.equals(this.graphItem.getId()) || !gravisGraph
							.containsItemId(textField.getText().trim()));
		}

		return false;
	}

}