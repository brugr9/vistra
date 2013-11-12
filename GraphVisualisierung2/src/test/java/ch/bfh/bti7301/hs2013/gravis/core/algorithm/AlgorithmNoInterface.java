package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * A dummy algorithm <b>not</b> implementing the interface
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

<<<<<<< HEAD
	public void execute(IRestrictedGraph graph) throws Exception {
		// Auto-generated method stub

	}

	public int getId() {
		// Auto-generated method stub
		return 0;
=======
	public void execute(IImmutableGraph graph) throws Exception {
>>>>>>> branch 'master' of https://github.com/brugr9/gravis.git
	}

	public EdgeType[] getAnnotations() {
		return null;
	}

}
