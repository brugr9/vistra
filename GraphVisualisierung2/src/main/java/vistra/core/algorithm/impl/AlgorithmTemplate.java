package vistra.core.algorithm.impl;

import vistra.core.algorithm.AbstractAlgorithm;
import vistra.core.algorithm.AlgorithmException;
import vistra.core.algorithm.IAlgorithm;
import vistra.core.graph.IExtendedGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * @author TODO set developer name
 * 
 */
public abstract class AlgorithmTemplate extends AbstractAlgorithm implements
		IAlgorithm {

	// TODO rename the class
	// TODO remove the modifier 'abstract'

	/**
	 * Main constructor.
	 */
	public AlgorithmTemplate() {
		super();
		// TODO set an algorithm description
		this.setDescription("");
		// TODO set the edge type by using one of the following statements:
		this.setEdgeType(EdgeType.UNDIRECTED);
		// this.setEdgeType(EdgeType.DIRECTED);
		// this.setEdgeTypes(new EdgeType[] { EdgeType.UNDIRECTED,
		// EdgeType.DIRECTED });
	}

	@Override
	public void traverse(IExtendedGraph graph) throws AlgorithmException {
		// TODO implement the algorithm

	}

}
