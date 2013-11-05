package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.common.IImmutableGraph;

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

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public void execute(IImmutableGraph graph) throws Exception {
		// TODO Auto-generated method stub

	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public GraphType[] getGraphTypes() {
		// TODO Auto-generated method stub
		return null;
	}

}
