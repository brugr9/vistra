package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import java.util.Collection;
import java.util.PriorityQueue;

import ch.bfh.bti7301.hs2013.gravis.common.IGraphItem.State;
import ch.bfh.bti7301.hs2013.gravis.common.IImmutableGraph;
import ch.bfh.bti7301.hs2013.gravis.common.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.ItemResultComparator;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class AlgorithmDijkstra extends AbstractAlgorithm {

	protected AlgorithmDijkstra() {
		super();
		super.setName("AlgorithmDijkstra");
		super.setDescription("AlgorithmDijkstra");
		// TODO annotations
		super.setGraphTypes(new GraphType[] {});
		// TODO init id
		super.setId(2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.algorithm.AbstractAlgorithm#execute
	 * (ch.bfh.bti7301.hs2013.gravis.common.IImmutableGraph,
	 * java.util.PriorityQueue)
	 */
	@Override
	public void execute(IImmutableGraph graph) throws Exception {

		// TODO bitte an dieser Methode nichts ändern (pk)
		// TODO AlgorithmDijkstra with undirected and unweighted eddges

		Collection<? extends IVertex> vertices = graph.getVertices();
		IVertex startVertex = graph.getStartVertex();
		vertices.remove(startVertex);

		// init distance from start vertex
		for (IVertex vertex : graph.getPredecessors(startVertex)) {
			vertex.setResult(graph.findEdge(startVertex, vertex).getWeight());
		}

		PriorityQueue<IVertex> prioQueue = new PriorityQueue<>(vertices.size(),
				new ItemResultComparator());
		prioQueue.addAll(vertices);

		while (!prioQueue.isEmpty()) {
			IVertex selectedVertex = prioQueue.poll();

			selectedVertex.setState(State.ACTIVATION);
			graph.updateState(selectedVertex);
			selectedVertex.setState(State.SOLUTION);
			graph.updateState(selectedVertex);

			for (IVertex currentVertex : graph.getSuccessors(selectedVertex)) {

				currentVertex.setState(State.ACTIVATION);
				graph.updateState(currentVertex);
				currentVertex.setState(State.VISIT);
				graph.updateState(currentVertex);

				double newDistance = selectedVertex.getResult()
						+ graph.findEdge(selectedVertex, currentVertex)
								.getWeight();
				double oldDistance = currentVertex.getResult();

				currentVertex.setResult(newDistance < oldDistance ? newDistance
						: oldDistance);
			}
		}
	}
}
