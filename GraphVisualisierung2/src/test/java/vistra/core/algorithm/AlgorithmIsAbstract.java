package vistra.core.algorithm;

import vistra.common.IAlgorithm;
import vistra.core.graph.IExtendedGraph;
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
		// Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// Auto-generated method stub
		return null;
	}

	@Override
	public void traverse(IExtendedGraph graph) throws AlgorithmException {
		// Auto-generated method stub

	}

	@Override
	public EdgeType[] getEdgeTypes() {
		// Auto-generated method stub
		return null;
	}

}
