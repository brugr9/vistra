package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.common.IImmutableGraph;

/**
 * A dummy algorithm implementing the interface <code>IAlgorithm</code>.
 * <p>
 * Tries to behave <b>evil</b> >8=§~ on execute().
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class AlgorithmEvil implements IAlgorithm {

	/**
	 * Constructor.
	 */
	public AlgorithmEvil() {
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
		try {
			// TODO behave evil
			// graph.getClass().getClassLoader().getParent())

		} catch (Exception e) {
			throw e;
		}

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
