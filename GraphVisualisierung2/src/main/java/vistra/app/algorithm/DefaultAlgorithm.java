package vistra.app.algorithm;

import vistra.framework.algorithm.AlgorithmException;
import vistra.framework.algorithm.IAlgorithm;
import vistra.framework.graph.ITraversableGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * A default algorithm implementing the interface {@code IAlgorithm} by
 * extending {@code AbstractAlgorithm}. Does nothing on traverse().
 * <p>
 * This algorithm is used as default choice in an algorithm-combo-box.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class DefaultAlgorithm implements IAlgorithm {

	/**
	 * A filed for the description.
	 */
	private String description;

	/**
	 * A field for the edge type(s).
	 */
	private EdgeType[] edgeTypes;

	/**
	 * Main Constructor.
	 */
	public DefaultAlgorithm() {
		this.description = " ";
		this.edgeTypes = new EdgeType[] { EdgeType.UNDIRECTED,
				EdgeType.DIRECTED };
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return "-------";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return this.description;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EdgeType[] getEdgeTypes() {
		return this.edgeTypes;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverse(ITraversableGraph g) throws AlgorithmException {
		// Does nothing.
	}

}
