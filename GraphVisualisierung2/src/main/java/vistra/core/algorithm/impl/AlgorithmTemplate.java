package vistra.core.algorithm.impl;

import vistra.core.algorithm.AbstractAlgorithm;
import vistra.core.algorithm.AlgorithmException;
import vistra.core.algorithm.AlgorithmManager;
import vistra.core.algorithm.IAlgorithm;
import vistra.core.graph.ITraversableGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An algorithm template for algorithm developers.
 * <p>
 * As algorithm developer, you may
 * <ul>
 * <li>set your name in the authors-tag below
 * <li>rename the class
 * <li>remove the modifier 'abstract'
 * <li>implement the constructor and the methods
 * <li>add this class to the {@link AlgorithmManager} constructor.
 * 
 * @author the developer name
 * 
 */
public abstract class AlgorithmTemplate extends AbstractAlgorithm implements
		IAlgorithm {

	/**
	 * Main constructor.
	 * 
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
	public void traverse(ITraversableGraph graph) throws AlgorithmException {
		// TODO implement the algorithm

	}

}
