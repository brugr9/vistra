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

	@Override
	public String getName() {
		return null;
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public void execute(IImmutableGraph graph) throws Exception {
	}

	@Override
	public GraphType[] getGraphTypes() {
		return null;
	}

}
