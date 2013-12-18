package travis.core.algorithm.impl;

import travis.common.IAlgorithm;
import travis.core.algorithm.AbstractAlgorithm;
import travis.core.graph.IRestrictedGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * Depth-first search (DFS), implemented recursively.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class DFS extends AbstractAlgorithm implements IAlgorithm {

	/**
	 * A field for a description.
	 */
	private final static String ALGO_DESCRIPTION = "Der Graph wird in Preorder traversiert. "
			+ "Es sind sowohl gerichtete als auch ungerichtete Graphen zulässig."
			+ "Die Knoten werden in Preorder-Reihenfolge nummeriert.";

	/**
	 * Main constructor.
	 */
	public DFS() {
		super();
		super.setDescription(ALGO_DESCRIPTION);
		super.setEdgeTypes(new EdgeType[] { EdgeType.UNDIRECTED,
				EdgeType.DIRECTED });
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(IRestrictedGraph graph) {
		// TODO
	}
}
