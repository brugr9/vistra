package vistra.core.algorithm;

import vistra.core.graph.ITraversableGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An observable algorithm, does nothing on execute.
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
	 * A constructor.
	 * 
	 * @param description
	 *            a description
	 */
	protected AbstractAlgorithm(String description) {
		this.description = description;
		this.edgeTypes = null;
	}

	/**
	 * A constructor.
	 * 
	 * @param edgeType
	 *            an edge type
	 */
	protected AbstractAlgorithm(EdgeType edgeType) {
		this.description = "";
		this.edgeTypes = new EdgeType[] { edgeType };
	}

	/**
	 * A constructor.
	 * 
	 * @param edgeTypes
	 */
	protected AbstractAlgorithm(EdgeType[] edgeTypes) {
		this.description = "";
		this.edgeTypes = edgeTypes;
	}

	/**
	 * A constructor.
	 * 
	 * @param description
	 *            a description
	 * @param edgeType
	 *            an edge type
	 */
	protected AbstractAlgorithm(String description, EdgeType edgeType) {
		this.description = description;
		this.edgeTypes = new EdgeType[] { edgeType };
	}

	/**
	 * A constructor.
	 * 
	 * @param description
	 *            a description
	 * @param edgeTypes
	 *            an edge type array
	 */
	protected AbstractAlgorithm(String description, EdgeType[] edgeTypes) {
		this.description = description;
		this.edgeTypes = edgeTypes;
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
	 * Sets the edgeType.
	 * 
	 * @param edgeType
	 *            the edgeTypes to set
	 */
	protected final void setEdgeType(EdgeType edgeType) {
		this.edgeTypes = new EdgeType[] { edgeType };
	}

	/**
	 * Sets the edgeTypes.
	 * 
	 * @param edgeTypes
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

	@Override
	public void traverse(ITraversableGraph graph) throws AlgorithmException {
		// TODO Auto-generated method stub

	}

}
