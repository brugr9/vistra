package ch.bfh.bti7301.hs2013.gravis.core.algorithm.impl;

import ch.bfh.bti7301.hs2013.gravis.core.algorithm.AbstractAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * A default algorithm implementing the interface <code>IAlgorithm</code> by
 * extending <code>AbstractAlgorithm</code>.
 * <p>
 * Does nothing on execute().
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class AlgorithmDefault extends AbstractAlgorithm implements IAlgorithm {

	/**
	 * Main Constructor.
	 */
	public AlgorithmDefault() {
		super.setName("----------");
		super.setDescription("");
		super.setEdgeTypes(new EdgeType[] { EdgeType.UNDIRECTED,
				EdgeType.DIRECTED });
	}

}
