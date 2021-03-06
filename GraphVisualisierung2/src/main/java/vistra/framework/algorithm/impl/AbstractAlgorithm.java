package vistra.framework.algorithm.impl;

import vistra.framework.algorithm.IAlgorithm;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An observable algorithm, does nothing on execute.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
abstract class AbstractAlgorithm implements IAlgorithm {

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
	AbstractAlgorithm() {
		this.description = "";
		this.edgeTypes = null;
	}

	/**
	 * Sets the description.
	 * 
	 * @param description
	 *            the description to set
	 */
	final void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Sets the edgeType.
	 * 
	 * @param edgeType
	 *            the edgeTypes to set
	 */
	final void setEdgeType(EdgeType edgeType) {
		this.edgeTypes = new EdgeType[] { edgeType };
	}

	/**
	 * Sets the edgeTypes.
	 * 
	 * @param edgeTypes
	 *            the edgeTypes to set
	 */
	final void setEdgeTypes(EdgeType[] edgeTypes) {
		this.edgeTypes = edgeTypes;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getName() {
		return this.getClass().getSimpleName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getDescription() {
		return this.description;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final EdgeType[] getEdgeTypes() {
		return this.edgeTypes;
	}

}
