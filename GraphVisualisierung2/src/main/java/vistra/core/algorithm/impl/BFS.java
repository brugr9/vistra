package vistra.core.algorithm.impl;

import vistra.common.IAlgorithm;
import vistra.core.algorithm.AbstractAlgorithm;
import vistra.core.algorithm.AlgorithmException;
import vistra.core.graph.IExtendedGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * Breadth-first search (BFS).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class BFS extends AbstractAlgorithm implements IAlgorithm {

	/**
	 * A field for a description.
	 */
	private final static String ALGO_DESCRIPTION = "Die Breitensuche ist als Schleife "
			+ "implementiert. Es sind sowohl gerichtete als auch ungerichtete Graphen "
			+ "zulässig. Die Breitensuche wird für jede (schwache) Zusammenhangskomponente "
			+ "separat durchgefürt.";

	/**
	 * Main constructor.
	 */
	public BFS() {
		super();
		super.setDescription(ALGO_DESCRIPTION);
		super.setEdgeTypes(new EdgeType[] { EdgeType.UNDIRECTED,
				EdgeType.DIRECTED });
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverse(IExtendedGraph graph) throws AlgorithmException {
		// TODO
	}

}
