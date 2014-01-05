package vistra.framework.algorithm.impl;

import vistra.framework.algorithm.IAlgorithm;
import vistra.framework.graph.ITraversableGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * Depth-last search (DFS).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class DLS extends AbstractAlgorithm implements IAlgorithm {

	/**
	 * A field for a description.
	 */
	private final static String ALGO_DESCRIPTION = "Der Graph wird in Postorder traversiert. "
			+ "Es sind sowohl gerichtete als auch ungerichtete Graphen zulässig."
			+ "Die Knoten werden in Postorder-Reihenfolge nummeriert.";

	/**
	 * Main constructor.
	 */
	public DLS() {
		super();
		super.setDescription(ALGO_DESCRIPTION);
		super.setEdgeTypes(new EdgeType[] { EdgeType.UNDIRECTED,
				EdgeType.DIRECTED });
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverse(ITraversableGraph graph) {
		// TODO
	}

}
