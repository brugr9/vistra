package vistra.core.algorithm;

import vistra.common.IAlgorithm;
import vistra.core.zobsolete.graph.IRestrictedGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An abstract algorithm, does nothing on execute.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public abstract class AbstractAlgorithm implements IAlgorithm {

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
		this.description = "";
		this.edgeTypes = null;
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverse(IRestrictedGraph graph) throws AlgorithmException {
		// Does nothing on execute.
	}

}
