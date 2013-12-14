package ch.bfh.bti7301.hs2013.gravis.common;

import ch.bfh.bti7301.hs2013.gravis.core.algorithm.AlgorithmException;
import ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * @author // TODO set developer name
 * 
 */
public class AlgorithmTemplate implements IAlgorithm {

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm#getName()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		// TODO set Algorithm name
		return "AlgorithmTemplate";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm#getDescription()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		// TODO set Algorithm description
		return "AlgorithmTemplate";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm#execute(ch.bfh
	 * .bti7301.hs2013.gravis.core.graph.IRestrictedGraph)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(IRestrictedGraph graph) throws AlgorithmException {
		// TODO implement algorithm

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm#getGraphTypes()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public EdgeType[] getEdgeTypes() {
		// TODO EdgeType verwenden

		// TODO set EdgeType
		return null;
	}

}
