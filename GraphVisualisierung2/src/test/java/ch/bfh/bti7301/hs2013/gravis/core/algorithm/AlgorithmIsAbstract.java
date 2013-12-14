package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph;

/**
 * A dummy algorithm implementing the interface <code>IAlgorithm</code>.
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
	public void execute(IRestrictedGraph graph) throws AlgorithmException {
		// TODO Auto-generated method stub

	}

	@Override
	public GraphType[] getGraphTypes() {
		// TODO Auto-generated method stub
		return null;
	}

}
