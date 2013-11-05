package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import ch.bfh.bti7301.hs2013.gravis.common.IGraphItem.State;
import ch.bfh.bti7301.hs2013.gravis.common.IImmutableGraph;
import ch.bfh.bti7301.hs2013.gravis.common.IVertex;

/**
 * Depth-first search (DFS) algorithm, implemented recursively
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class AlgorithmDFSRecursive extends AbstractAlgorithm {

	private int counter = 0;

	/**
	 * Constructor
	 */
	protected AlgorithmDFSRecursive() {
		super();
		super.setName("Depth-first search (DFS), recursive");
		super.setDescription("Depth-first search (DFS), implemented recursively.");
		// TODO annotations
		super.setGraphTypes(new GraphType[] {});
		// TODO init id
		super.setId(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.processing.algorithms.IGraphAlgorithm
	 * #execute(edu.uci.ics.jung.graph.Graph)
	 */
	@Override
	public void execute(IImmutableGraph graph) {
		// TODO bitte an dieser Methode nichts ändern (pk)

		this.counter = 0;

		for (IVertex vertex : graph.getVertices()) {
			if (!vertex.isVisited()) {
				this.visit(graph, vertex);
			}
		}
	}

	/**
	 * @param graph
	 * @param vertex1
	 */
	private void visit(IImmutableGraph graph, IVertex vertex1) {
		vertex1.setVisited(true);
		vertex1.setState(State.ACTIVATION);
		vertex1.setResult(++this.counter);
		graph.updateState(vertex1);
		vertex1.setState(State.SOLUTION);
		graph.updateState(vertex1);

		for (IVertex vertex2 : graph.getSuccessors(vertex1)) {
			if (!vertex2.isVisited()) {
				this.visit(graph, vertex2);
				vertex1.setState(State.ACTIVATION);
				graph.updateState(vertex1);
			}
		}
	}
}
