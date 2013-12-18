package travis.core.algorithm;

import travis.common.IAlgorithm;
import travis.core.algorithm.AlgorithmException;
import travis.core.graph.IRestrictedGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * A dummy algorithm implementing the interface <code>IAlgorithm</code>. Since
 * having a private constructor, initialisation should fail.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class AlgorithmNoConstructor implements IAlgorithm {

	/**
	 * No-constructor.
	 */
	private AlgorithmNoConstructor() {
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void execute(IRestrictedGraph graph) throws AlgorithmException {
		// TODO Auto-generated method stub

	}

	@Override
	public EdgeType[] getEdgeTypes() {
		// TODO Auto-generated method stub
		return null;
	}

}
