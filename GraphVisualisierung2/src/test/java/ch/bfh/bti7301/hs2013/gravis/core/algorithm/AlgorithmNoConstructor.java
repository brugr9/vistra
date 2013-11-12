package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

<<<<<<< HEAD
import ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph;
=======
import ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph;
>>>>>>> branch 'master' of https://github.com/brugr9/gravis.git

/**
 * A dummy algorithm implementing the interface <code>IAlgorithm</code>. Since
 * having a private constructor, initialisation would fail.
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
		return null;
	}

	@Override
	public String getDescription() {
		return null;
	}

<<<<<<< HEAD
	public void execute(IRestrictedGraph graph) throws Exception {
		// TODO Auto-generated method stub

=======
	@Override
	public void execute(IImmutableGraph graph) throws Exception {
>>>>>>> branch 'master' of https://github.com/brugr9/gravis.git
	}

	@Override
	public GraphType[] getGraphTypes() {
		return null;
	}

}
