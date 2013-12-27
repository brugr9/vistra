package vistra.core.algorithm;

import vistra.core.graph.IRenderGraph;
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
		super(" ", new EdgeType[] { EdgeType.UNDIRECTED, EdgeType.DIRECTED });
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
	public void traverse(IRenderGraph graph) throws AlgorithmException {
		// Does nothing on execute.
	}

}
