package ch.bfh.bti7301.hs2013.gravis.data.workbench.algorithm;

import ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph;

/**
 * A dummy algorithm implementing the interface <code>IAlgorithm</code>.
 * <p>
 * Does nothing on execute().
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class AlgorithmDummy implements IAlgorithm {

	/**
	 * A filed for the name.
	 */
	private String name;

	/**
	 * A filed for the description.
	 */
	private String description;

	/**
	 * A field for the annotations.
	 */
	private GraphType[] annotations;

	/**
		 * 
		 */
	public AlgorithmDummy() {
		this.name = "Algorithm Dummy";
		this.description = "A default algorithm just implementing the interface"
				+ "IAlgorithm . Does nothing on execute.";
		this.id = -1;
		this.annotations = new GraphType[] { GraphType.UNDIRECTED,
				GraphType.DIRECTED, GraphType.UNWEIGHTED, GraphType.WEIGHTED,
				GraphType.SINGLEEDGE, GraphType.MULTIEDGE };
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm#getName()
	 */
	@Override
	public final String getName() {
		return this.name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm#getDescription()
	 */
	@Override
	public final String getDescription() {
		return this.description;
	}

	@Override
	public final GraphType[] getGraphTypes() {
		return this.annotations;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.processing.algorithms.IGraphAlgorithm
	 * #execute(edu.uci.ics.jung.graph.Graph)
	 */
	@Override
	public void execute(IImmutableGraph graph) throws Exception {
		// Does nothing on execute.
	}

}
