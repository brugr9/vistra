package travis.common;

import travis.core.algorithm.AlgorithmException;
import travis.core.graph.IRestrictedGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * @author // TODO set developer name
 * 
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
	public void execute(IRestrictedGraph graph) throws AlgorithmException {
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
