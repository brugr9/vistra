package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import java.util.Collection;
import java.util.PriorityQueue;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.ItemResultComparator;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class AlgorithmDijkstra extends AbstractAlgorithm {

	private final ItemResultComparator itemResultComparator;
	
	protected AlgorithmDijkstra() {
		super();
		super.setName("Dijkstra algorithm");
		super.setDescription("Dijkstra algorithm, multi-edges not supported.");
		// TODO annotations
		super.setGraphTypes(new GraphType[] {});
		// TODO init id
		super.setId(2);
		
		this.itemResultComparator = new ItemResultComparator();
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
	public void execute(IRestrictedGraph graph) throws Exception {

		// TODO bitte an dieser Methode nichts ändern (pk)
		
		// TODO visualize edges
		// TODO helper methods string builder
		// TODO AlgorithmDijkstra with undirected edges
		// TODO end vertex

		Collection<? extends IRestrictedVertex> vertices = graph.getVertices();
		IRestrictedVertex startVertex = graph.getStartVertex();
		StringBuilder successors = new StringBuilder();
		
		startVertex.setState(State.ACTIVATION);
		graph.updateState(startVertex);
		
		
		for (IRestrictedVertex adjacentVertex : graph.getSuccessors(startVertex)) {
			successors.append(adjacentVertex.getId() + ", ");
		}
		successors.delete(Math.max(0, successors.length() - 2), 
				Math.max(0, successors.length()));
		if (successors.length() != 0) {
			startVertex.setComment("Der Knoten "
					+ startVertex.getId()
					+ " hat die folgenden Nachfolger: " + successors);
		}
		startVertex.setResult(0.0);
		startVertex.setState(State.SOLUTION);
		graph.updateState(startVertex);
		
		vertices.remove(startVertex);

		// init infinite distance from start vertex
		for (IRestrictedVertex vertex : vertices) {
			vertex.setResult(Double.POSITIVE_INFINITY);
			vertex.setState(State.ACTIVATION);
			graph.updateState(vertex);
		}
		
		startVertex.setState(State.ACTIVATION);
		graph.updateState(startVertex);
		
		// init edge weight as distance for all successors of start vertex
		for (IRestrictedVertex vertex : graph.getSuccessors(startVertex)) {
			vertex.setState(State.ACTIVATION);
			graph.updateState(vertex);
			
			vertex.setResult(graph.findEdge(startVertex, vertex).getWeight());
			vertex.setState(State.VISIT);
			graph.updateState(vertex);
			
			startVertex.setState(State.ACTIVATION);
			graph.updateState(startVertex);
		}

		PriorityQueue<IRestrictedVertex> prioQueue = new PriorityQueue<>(vertices.size(),
				this.itemResultComparator);
		double newDistance = 0.0;
		double oldDistance = 0.0;
				
		prioQueue.addAll(vertices);

		while (!prioQueue.isEmpty()) {
			IRestrictedVertex selectedVertex = prioQueue.poll();
			
			selectedVertex.setState(State.ACTIVATION);
			graph.updateState(selectedVertex);
			
			successors = new StringBuilder();
			for (IRestrictedVertex adjacentVertex : graph.getSuccessors(selectedVertex)) {
				successors.append(adjacentVertex.getId() + ", ");
			}
			successors.delete(Math.max(0, successors.length() - 2), 
					Math.max(0, successors.length()));
			
			if (successors.length() != 0) {
				selectedVertex.setComment("Der Knoten "
						+ selectedVertex.getId()
						+ " hat die folgenden Nachfolger: " + successors);
			}
			selectedVertex.setState(State.SOLUTION);
			graph.updateState(selectedVertex);

			for (IRestrictedVertex adjacentVertex : graph.getSuccessors(selectedVertex)) {
				if (adjacentVertex.getState() != State.SOLUTION) {
					adjacentVertex.setState(State.ACTIVATION);
					graph.updateState(adjacentVertex);
					
					newDistance = selectedVertex.getPaintedResult()
							+ graph.findEdge(selectedVertex, adjacentVertex)
									.getWeight();
					oldDistance = adjacentVertex.getPaintedResult();
					adjacentVertex
							.setResult(newDistance < oldDistance ? newDistance
									: oldDistance);
					adjacentVertex.setState(State.VISIT);
					graph.updateState(adjacentVertex);
				} 
			}
			
			vertices.remove(selectedVertex);
			if (!vertices.isEmpty()) {
				prioQueue = new PriorityQueue<>(vertices.size(), 
						this.itemResultComparator);
				prioQueue.addAll(vertices);
			}
		}
	}
}
