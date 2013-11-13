/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.core.algorithm;


import ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph;
import ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm;


/**
 * Abstract algorithm, does nothing on execute().
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
abstract class AbstractAlgorithm implements IAlgorithm {

	/**
	 * A filed for the name.
	 */
	private String name;

	/**
	 * A filed for the description.
	 */
	private String description;

	/**
	 * A filed for the id.
	 */
	private int id;

	/**
	 * A field for the graphtypes.
	 */
	private GraphType[] graphtypes;
	
	/**
	 * true: the algorithm activates the animation of edges (edge colors, edge 
	 * results, edge comments changes)
	 * false: the algorithm does not need animation of edges
	 */
	private boolean enableEdges;

	/**
	 * 
	 */
	protected AbstractAlgorithm() {
		this.name = "";
		this.description = "";
		this.id = -1;
		this.graphtypes = new GraphType[] {};
		this.enableEdges = true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm#getName()
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
	@Override
	public final String getDescription() {
		return this.description;
	}

	@Override
	public final GraphType[] getGraphTypes() {
		return this.graphtypes;
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
	 * Sets the id.
	 * 
	 * @param id
	 *            the id to set
	 */
	protected final void setId(int id) {
		this.id = id;
	}

	/**
	 * Sets the graphtypes.
	 * 
	 * @param graphtypes
	 *            the graphtypes to set
	 */
	protected final void setGraphTypes(GraphType[] annotations) {
		this.graphtypes = annotations;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.processing.algorithms.IGraphAlgorithm
	 * #execute(edu.uci.ics.jung.graph.Graph)
	 */
	@Override
	public void execute(IRestrictedGraph graph) throws Exception {
		// Does nothing on execute.
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm#isEnableEdges()
	 */
	@Override
	public boolean isEnableEdges() {
		return this.enableEdges;
	}

	/**
	 * 
	 * @param enableEdges
	 */
	protected void setEnableEdges(boolean enableEdges) {
		this.enableEdges = enableEdges;
	}
	
}
