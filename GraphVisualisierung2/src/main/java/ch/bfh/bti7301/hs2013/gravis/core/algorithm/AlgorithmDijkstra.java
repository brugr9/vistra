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
		super.setDescription("Dijkstra algorithm for DIRECTED and UNDIRECTED edges. "
				+ "Multi-edges not supported, negative weights not allowed.");
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
		
		// TODO set comments in calculateDistances()
		// TODO visualize edges
		// TDO bei Min-Auswahl: alle Auswahlmöglichkeiten fett marieren
		// TODO multi-edges: findEdgeSet

		Collection<? extends IRestrictedVertex> vertices = graph.getVertices();
		IRestrictedVertex startVertex = graph.getStartVertex();

		startVertex.setComment(startVertex.getId() + " ist der Startknoten.");
		this.updateState(graph, startVertex, State.ACTIVATION);

		// start vertex has distance 0
		startVertex.setResult(0.0);
		this.setSuccessorMessage(graph, startVertex);
		startVertex.appendComment("Für den Knoten " + startVertex.getId() + 
				" wurde der kürzeste Weg berechnet: " + startVertex.getResult());
		startVertex.setDone(true);
		this.updateState(graph, startVertex, State.SOLUTION);
		vertices.remove(startVertex);

		if (this.updateEndVertexMessage(graph, startVertex, startVertex)) {
			return;
		}

		this.initializeDistances(graph, vertices, startVertex);
		this.calculateDistances(graph, vertices, startVertex);
	}

	/**
	 * @param graph
	 * @param vertices
	 * @param startVertex
	 */
	private void initializeDistances(IRestrictedGraph graph,
			Collection<? extends IRestrictedVertex> vertices,
			IRestrictedVertex startVertex) {

		// initialize infinite distance from start vertex
		for (IRestrictedVertex vertex : vertices) {
			vertex.setResult(Double.POSITIVE_INFINITY);
			vertex.setComment("Der Knoten " + vertex.getId() + 
					" wurde mit folgendem Wert initialisiert: " + vertex.getResult());
			this.updateState(graph, vertex, State.ACTIVATION);
		}

		startVertex.setComment("Rückkehr zum Startknoten " + startVertex.getId() + ".");
		this.updateState(graph, startVertex, State.ACTIVATION);

		// init edge weight as distance for all successors of start vertex
		for (IRestrictedVertex vertex : graph.getSuccessors(startVertex)) {
			vertex.setComment("Der Knoten " + vertex.getId() + 
					" wird aktiviert.");
			this.updateState(graph, vertex, State.ACTIVATION);

			vertex.setResult(graph.findEdge(startVertex, vertex).getWeight());
			vertex.setComment("Der Knoten " + vertex.getId() + 
					" wurde besucht. Der neue kürzeste Weg vom Startknoten aus ist: " +
					vertex.getResult());
			this.updateState(graph, vertex, State.VISIT);
			
			startVertex.setComment("Der Knoten " + startVertex.getId() + 
					" wird aktiviert.");
			this.updateState(graph, startVertex, State.ACTIVATION);
		}
	}
	
	/**
	 * @param graph
	 * @param vertices
	 * @param startVertex
	 */
	private void calculateDistances(IRestrictedGraph graph,
			Collection<? extends IRestrictedVertex> vertices,
			IRestrictedVertex startVertex) {

		PriorityQueue<IRestrictedVertex> prioQueue = new PriorityQueue<>(
				vertices.size(), this.itemResultComparator);
		prioQueue.addAll(vertices);

		while (!prioQueue.isEmpty()) {
			IRestrictedVertex selectedVertex = prioQueue.poll();

			this.updateState(graph, selectedVertex, State.ACTIVATION);

			this.setSuccessorMessage(graph, selectedVertex);
			selectedVertex.setDone(true);
			this.updateState(graph, selectedVertex, State.SOLUTION);

			if (this.updateEndVertexMessage(graph, startVertex, selectedVertex)) {
				return;
			}

			this.updateAdjacentVertexDistances(graph, selectedVertex);

			prioQueue = this.newPriorityQueue(vertices, prioQueue,
					selectedVertex);
		}
	}

	/**
	 * @param graph
	 * @param vertex
	 */
	private void updateAdjacentVertexDistances(IRestrictedGraph graph,
			IRestrictedVertex vertex) {

		double newDistance = 0.0;
		double oldDistance = 0.0;

		for (IRestrictedVertex adjacentVertex : graph
				.getSuccessors(vertex)) {
			
			if (!adjacentVertex.isDone()) {
				this.updateState(graph, adjacentVertex, State.ACTIVATION);

				newDistance = vertex.getPaintedResult()
						+ graph.findEdge(vertex, adjacentVertex)
								.getWeight();
				oldDistance = adjacentVertex.getPaintedResult();

				adjacentVertex
						.setResult(Math.min(newDistance, oldDistance));
				this.updateState(graph, adjacentVertex, State.VISIT);
				
				this.updateState(graph, vertex, State.ACTIVATION);
			}
		}
	}

	/**
	 * @param vertices
	 * @param prioQueue
	 * @param selectedVertex
	 * @return a new instance of PriorityQueue<IRestrictedVertex>
	 */
	private PriorityQueue<IRestrictedVertex> newPriorityQueue(
			Collection<? extends IRestrictedVertex> vertices,
			PriorityQueue<IRestrictedVertex> prioQueue,
			IRestrictedVertex selectedVertex) {

		vertices.remove(selectedVertex);

		if (!vertices.isEmpty()) {
			prioQueue = new PriorityQueue<>(vertices.size(),
					this.itemResultComparator);
			prioQueue.addAll(vertices);
		}

		return prioQueue;
	}

	/**
	 * @param graph
	 * @param vertex
	 */
	private void setSuccessorMessage(IRestrictedGraph graph,
			IRestrictedVertex vertex) {

		StringBuilder successors = new StringBuilder();

		for (IRestrictedVertex adjacentVertex : graph.getSuccessors(vertex)) {
			successors.append(adjacentVertex.getId() + ", ");
		}

		successors.delete(Math.max(0, successors.length() - 2),
				Math.max(0, successors.length()));

		if (successors.length() != 0) {
			vertex.setComment("Der Knoten " + vertex.getId()
					+ " hat die folgenden Nachfolger: " + successors);
		}
	}

	/**
	 * @param graph
	 * @param startVertex
	 * @param selectedVertex
	 */
	private boolean updateEndVertexMessage(IRestrictedGraph graph,
			IRestrictedVertex startVertex, IRestrictedVertex selectedVertex) {

		if (selectedVertex.isEnd()) {
			selectedVertex.setComment("Der kürzeste Weg von "
					+ startVertex.getId() + " nach " + selectedVertex.getId()
					+ " wurde gefunden.");
			graph.updateState(selectedVertex);
			return true;
		}
		return false;
	}
}
