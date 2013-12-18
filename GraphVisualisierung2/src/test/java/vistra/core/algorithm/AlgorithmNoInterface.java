package vistra.core.algorithm;

import vistra.core.graph.IRestrictedGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An algorithm test dummy <b>not</b> implementing the interface
 * <code>IAlgorithm</code>. Although the methods as declared in
 * <code>IAlgorithm</code> are available.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class AlgorithmNoInterface {

	public String getName() {
		return null;
	}

	public String getDescription() {
		return null;
	}

	public void execute(IRestrictedGraph graph) throws Exception {

	}

	public EdgeType[] getEdgeTypes() {
		return null;
	}

}
