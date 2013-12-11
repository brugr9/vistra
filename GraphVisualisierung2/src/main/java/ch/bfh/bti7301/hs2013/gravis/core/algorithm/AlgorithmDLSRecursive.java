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
		super.setDescription("Depth-last search (DLS) for DIRECTED and UNDIRECTED edges, "
				+ "implemented recursively.");
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

		this.counter = 0;

		IRestrictedVertex startVertex = graph.getStartVertex();
		if (startVertex != null) {
			startVertex.setNewComment("Die Knoten werden in Postorder-Reihenfolge nummeriert.");
		}
		
		for (IRestrictedVertex vertex : graph.getVertices()) {
			if (!vertex.isDone()) {
				boolean abort = this.visit(graph, vertex);
				
				if (abort) {
					return;
				}
			}
		}
	}

	/**
	 * 
	 * @param graph
	 * @param vertex1
	 * @return boolean
	 */
	private boolean visit(IRestrictedGraph graph, IRestrictedVertex vertex1) {
		vertex1.appendToNewComment("Der Knoten " + vertex1 + " wird aktiviert.");
		graph.updateState(State.ACTIVATION, vertex1);

		vertex1.setDone(true);
		vertex1.setNewComment("Der Knoten " + vertex1 + " wurde besucht.");
		graph.updateState(State.VISIT, vertex1);

		for (IRestrictedVertex vertex2 : graph.getSuccessors(vertex1)) {
			if (!vertex2.isDone()) {
				boolean abort = this.visit(graph, vertex2);
				
				if (abort) {
					return true;
				}
				
				vertex1.setNewComment("Der Knoten " + vertex1 + " wird aktiviert.");
				graph.updateState(State.ACTIVATION, vertex1);
			}
		}

		vertex1.setNewResult(++this.counter);
		vertex1.setNewComment("Der Knoten " + vertex1 + " wurde traversiert und zur Lösung "
				+ "hinzugefügt. Er hat die Traversierungs-Nr.: " + vertex1.getNewResult());
		if (this.updateEndVertexMessage(graph, vertex1)) {
			return true;
		}
		graph.updateState(State.SOLUTION, vertex1);
		
		return false;
	}

	/**
	 * @param graph
	 * @param endVertex
	 */
	private boolean updateEndVertexMessage(IRestrictedGraph graph,
			IRestrictedVertex endVertex) {
		if (endVertex.isEnd()) {
			endVertex.appendToNewComment("Der Endknoten " + endVertex.getId()
					+ " wurde erreicht.");
			graph.updateState(State.SOLUTION, endVertex);
			return true;
		}
		return false;
	}
}
