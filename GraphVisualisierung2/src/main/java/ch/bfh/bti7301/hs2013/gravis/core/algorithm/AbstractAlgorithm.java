/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An abstract algorithm, does nothing on execute.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public abstract class AbstractAlgorithm implements IAlgorithm {

	/**
	 * A filed for the name.
	 */
	private String name;

	/**
	 * A filed for the description.
	 */
	private String description;

	/**
	 * A field for the edge type(s).
	 */
	private EdgeType[] edgeTypes;

	/**
	 * Main constructor.
	 */
	protected AbstractAlgorithm() {
		this.name = "";
		this.description = "";
		this.edgeTypes = null;
	}

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the name to set
	 */
	protected final void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            the description to set
	 */
	protected final void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Sets the edgeTypes.
	 * 
	 * @param graphtypes
	 *            the edgeTypes to set
	 */
	protected final void setEdgeTypes(EdgeType[] edgeTypes) {
		this.edgeTypes = edgeTypes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm#getName()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getName() {
		return this.name;
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
	public final String getDescription() {
		return this.description;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm#getEdgeTypes()
	 */
	@Override
	public final EdgeType[] getEdgeTypes() {
		return this.edgeTypes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.processing.algorithms.IGraphAlgorithm
	 * #execute(edu.uci.ics.jung.graph.Graph)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(IRestrictedGraph graph) throws AlgorithmException {
		// Does nothing on execute.
	}

}
