package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class AlgorithmDLSRecursive extends AbstractAlgorithm implements IAlgorithm {

	private int counter = 0;

	protected AlgorithmDLSRecursive() {
		super();
		super.setName("Depth-last search (DLS), recursive");
		super.setDescription("Depth-last search (DLS), implemented recursively.");
		// TODO annotations
		super.setGraphTypes(new GraphType[] {});
		// TODO init id
		super.setId(1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.algorithm.AbstractAlgorithm#execute
	 * (ch.bfh .bti7301.hs2013.gravis.graph.IImmutableGraph)
	 */
	@Override
	public void execute(IRestrictedGraph graph) {
		// TODO bitte an dieser Methode nichts ändern (pk)

		// TODO Implementation für ungerichtete Kanten
		// TODO endVertex 
		
		this.counter = 0;

		for (IRestrictedVertex vertex : graph.getVertices()) {
			if (!vertex.isVisited()) {
				this.visit(graph, vertex);
			}
		}
	}

	/**
	 * @param graph
	 * @param vertex1
	 */
	private void visit(IRestrictedGraph graph, IRestrictedVertex vertex1) {
		vertex1.setComment("Der Knoten " + vertex1 + " wird aktiviert.");
		vertex1.setState(State.ACTIVATION);
		graph.updateState(vertex1);

		vertex1.setVisited(true);
		vertex1.setComment("Der Knoten " + vertex1 + " wurde besucht.");
		vertex1.setState(State.VISIT);
		graph.updateState(vertex1);

		for (IRestrictedVertex vertex2 : graph.getSuccessors(vertex1)) {
			if (!vertex2.isVisited()) {
				this.visit(graph, vertex2);
				
				vertex1.setComment("Der Knoten " + vertex1 + " wird aktiviert.");
				vertex1.setState(State.ACTIVATION);
				graph.updateState(vertex1);
			}
		}

		vertex1.setResult(++this.counter);
		vertex1.setComment("Der Knoten " + vertex1 + " wurde traversiert und zur Lösung "
				+ "hinzugefügt. Er hat die Traversierungs-Nr.: " + vertex1.getResult());
		vertex1.setState(State.SOLUTION);
		graph.updateState(vertex1);
	}

}
