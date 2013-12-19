package vistra.core.algorithm;

import vistra.common.IAlgorithm;
import vistra.core.zobsolete.graph.IRestrictedGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An algorithm test dummy implementing the interface <code>IAlgorithm</code>.
 * <p>
 * As declared as abstract, the instantiation should fail.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public abstract class AlgorithmIsAbstract implements IAlgorithm {

	/**
	 * Constructor.
	 */
	public AlgorithmIsAbstract() {
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
	public void traverse(IRestrictedGraph graph) throws AlgorithmException {
		// TODO Auto-generated method stub

	}

	@Override
	public EdgeType[] getEdgeTypes() {
		// TODO Auto-generated method stub
		return null;
	}

}
