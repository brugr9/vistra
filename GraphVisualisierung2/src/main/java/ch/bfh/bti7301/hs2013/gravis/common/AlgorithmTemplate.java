package ch.bfh.bti7301.hs2013.gravis.common;

import ch.bfh.bti7301.hs2013.gravis.core.algorithm.AlgorithmException;
import ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph;


/**
 * @author // TODO set developer name
 *
 */
public class AlgorithmTemplate implements IAlgorithm {

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm#getName()
	 */
	@Override
	public String getName() {
		// TODO set Algorithm name
		return "AlgorithmTemplate";
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm#getDescription()
	 */
	@Override
	public String getDescription() {
		// TODO set Algorithm description
		return "AlgorithmTemplate";
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm#execute(ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph)
	 */
	@Override
	public void execute(IRestrictedGraph graph) throws AlgorithmException {
		// TODO implement algorithm
		
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm#getGraphTypes()
	 */
	@Override
	public GraphType[] getGraphTypes() {
		// TODO EdgeType verwenden
		
		// TODO set EdgeType
		return null;
	}

	

	
}
