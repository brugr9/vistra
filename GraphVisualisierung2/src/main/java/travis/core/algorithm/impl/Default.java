package travis.core.algorithm.impl;

import travis.common.IAlgorithm;
import travis.core.algorithm.AbstractAlgorithm;
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
public class Default extends AbstractAlgorithm implements IAlgorithm {

	/**
	 * Main Constructor.
	 */
	public Default() {
		super.setDescription(" ");
		super.setEdgeTypes(new EdgeType[] { EdgeType.UNDIRECTED,
				EdgeType.DIRECTED });
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return "--------";
	}

}
