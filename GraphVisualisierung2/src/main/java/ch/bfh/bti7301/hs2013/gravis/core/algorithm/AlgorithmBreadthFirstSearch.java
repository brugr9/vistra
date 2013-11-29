package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class AlgorithmBreadthFirstSearch extends AbstractAlgorithm {

	private int counter = 0;

	public AlgorithmBreadthFirstSearch() {
		super();
		super.setName("Breadth-first search (BFS)");
		super.setDescription("Breadth-first search (BFS) for DIRECTED and UNDIRECTED edges.");
		// TODO annotations
		super.setGraphTypes(new GraphType[] {});
		// TODO init id
		super.setId(4);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.algorithm.AbstractAlgorithm#execute
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph)
	 */
	@Override
	public void execute(IRestrictedGraph graph) throws Exception {
		// TODO bitte an dieser Methode nichts ändern (pk)

		this.counter = 0;
		Queue<IRestrictedVertex> vertexQueue = new LinkedList<>();
		Collection<? extends IRestrictedVertex> vertices = graph.getVertices();
		IRestrictedVertex startVertex = graph.getStartVertex();

		startVertex.setDone(true);
		vertexQueue.offer(startVertex);
		vertices.remove(startVertex);

		for (IRestrictedVertex rVertex : vertices) {
			while (!vertexQueue.isEmpty()) {
				IRestrictedVertex selectedVertex = vertexQueue.poll();

				graph.updateState(State.ACTIVATION, selectedVertex);

				selectedVertex.setResult(++this.counter);
				if (this.updateEndVertexMessage(graph, selectedVertex)) {
					return;
				}
				graph.updateState(State.SOLUTION, selectedVertex);

				for (IRestrictedVertex successor : graph
						.getSuccessors(selectedVertex)) {
					if (!successor.isDone()) {
						graph.updateState(State.ACTIVATION, successor);

						successor.setDone(true);
						graph.updateState(State.VISIT, successor);

						vertexQueue.offer(successor);
					}
				}
			}
			
			if (!rVertex.isDone()) {
				vertexQueue.offer(rVertex);
			}
		}
	}

	/**
	 * @param graph
	 * @param endVertex
	 */
	private boolean updateEndVertexMessage(IRestrictedGraph graph,
			IRestrictedVertex endVertex) {
		if (endVertex.isEnd()) {
			endVertex.appendComment("Der Endknoten " + endVertex.getId()
					+ " wurde erreicht.");
			graph.updateState(State.SOLUTION, endVertex);
			return true;
		}
		return false;
	}
}
