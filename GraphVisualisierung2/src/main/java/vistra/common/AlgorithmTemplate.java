package vistra.common;

import vistra.core.algorithm.AlgorithmException;
import vistra.core.graph.zobsolete.IRestrictedGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * @author TODO set developer name
 * 
 *         TODO rename the class
 */
public class AlgorithmTemplate implements IAlgorithm {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return this.getClass().getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		// TODO set Algorithm description
		return "AlgorithmTemplate";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverse(IRestrictedGraph graph) throws AlgorithmException {
		// TODO implement algorithm

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EdgeType[] getEdgeTypes() {
		// TODO EdgeType verwenden
		// TODO set EdgeType
		return null;
	}

}
