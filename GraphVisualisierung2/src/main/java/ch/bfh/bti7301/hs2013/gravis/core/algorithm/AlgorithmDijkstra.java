package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.comparator.VertexPaintedResultComparator;
import static ch.bfh.bti7301.hs2013.gravis.core.util.transformer.ValueTransformer.toArray;
import edu.uci.ics.jung.algorithms.util.MapBinaryHeap;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class AlgorithmDijkstra extends AbstractAlgorithm {

	private final static String NEG_WEIGHT = "Dijkstra algorithm: "
			+ "negative weights are not allowed!";
	private final static String NO_START_VERTEX = "Dijkstra algorithm: no start vertex "
			+ "found in graph %s!";

	private final static String START_VERTEX = "%s ist der Startknoten.";
	private final static String SHORTEST_PATH = "Für den Knoten %s wurde der kürzeste Weg "
			+ "berechnet: %.1f";
	private final static String SHORTEST_PATH_OK = "Der kürzeste Weg von %s nach " + 
			"%s wurde gefunden.";

	private final VertexPaintedResultComparator vertexResultComparator;

	protected AlgorithmDijkstra() {
		super();
		super.setName("Dijkstra algorithm");
		super.setDescription("Dijkstra algorithm for DIRECTED and UNDIRECTED edges. "
				+ "Negative weights and multi-edges are not allowed.");
		// TODO annotations
		super.setGraphTypes(new GraphType[] {});
		// TODO init id
		super.setId(2);

		this.vertexResultComparator = new VertexPaintedResultComparator();
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
	public void execute(IRestrictedGraph graph) throws AlgorithmException {
		this.checkPositiveWeights(graph.getEdges());
		
		Collection<? extends IRestrictedVertex> vertices = graph.getVertices();
		IRestrictedVertex startVertex = graph.getStartVertex();

		if (startVertex == null) {
			throw new AlgorithmException(String.format(NO_START_VERTEX, graph));
		}

		startVertex.setNewComment(String.format(START_VERTEX,
				startVertex.getId()));
		startVertex.setNewResult(0.0);
		graph.updateState(State.VISIT, startVertex);

		// start vertex has distance 0
		startVertex.setNewComment(String.format(SHORTEST_PATH,
				startVertex.getId(), startVertex.getCurrentResult()));
		startVertex.setDone(true);
		if (this.updateEndVertexMessage(graph, startVertex, startVertex)) {
			return;
		}
		graph.updateState(State.SOLUTION, startVertex);
		vertices.remove(startVertex);

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
			vertex.setNewResult(Double.POSITIVE_INFINITY);
			vertex.setNewComment("Der Knoten " + vertex.getId()
					+ " wurde mit folgendem Wert initialisiert: "
					+ vertex.getNewResult());
			graph.updateState(State.ACTIVATION, vertex);
		}

		this.setSuccessorMessage(graph, startVertex);
		graph.updateState(State.ACTIVATION, startVertex);
		graph.updateState(State.SOLUTION, startVertex);

		// init edge weight as distance for all successors of start vertex
		for (IRestrictedVertex vertex : graph.getSuccessors(startVertex)) {
			IRestrictedEdge edge = graph.findEdge(startVertex, vertex);
			edge.setTagged(true);
			graph.updateState(State.VISIT, edge);

			graph.updateState(State.VISIT, vertex);

			vertex.setValue(startVertex);
			vertex.setNewResult(this.findMinEdge(graph, startVertex, vertex)
					.getWeight());
			vertex.setNewComment("Der neue kürzeste Weg vom Startknoten zum Knoten "
					+ vertex.getId() + " ist: " + vertex.getNewResult());

			List<IRestrictedGraphItem> visited = new ArrayList<>();
			visited.add(vertex);
			// this.updatePathColor(graph, vertex, visited);
			graph.updateState(State.VISIT, toArray(visited));

			graph.updateState(State.VISIT, edge);

			graph.updateState(State.SOLUTION, startVertex);
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

		MapBinaryHeap<IRestrictedVertex> prioQueue = new MapBinaryHeap<>(
				this.vertexResultComparator);
		prioQueue.addAll(vertices);

		while (!prioQueue.isEmpty()) {
			IRestrictedVertex selectedVertex = prioQueue.poll();

			selectedVertex
					.setNewComment("Das Minimum aller noch nicht zur Lösung gehörenden"
							+ " Knoten ist "
							+ selectedVertex.getId()
							+ " mit der aktuellen Distanz: "
							+ selectedVertex.getCurrentResult());
			graph.updateState(State.ACTIVATION, selectedVertex);

			this.setSuccessorMessage(graph, selectedVertex);
			selectedVertex.setDone(true);
			if (this.updateEndVertexMessage(graph, startVertex, selectedVertex)) {
				this.showShortestPath(graph, selectedVertex);
				return;
			}

			List<IRestrictedGraphItem> solved = new ArrayList<>();
			solved.add(selectedVertex);
			this.updatePathColor(graph, selectedVertex, solved);
			graph.updateState(State.SOLUTION, toArray(solved));

			this.updateAdjacentVertexDistances(graph, selectedVertex, prioQueue);
		}
	}

	/**
	 * @param graph
	 * @param vertex
	 * @param prioQueue
	 */
	private void updateAdjacentVertexDistances(IRestrictedGraph graph,
			IRestrictedVertex vertex, MapBinaryHeap<IRestrictedVertex> prioQueue) {

		double newDistance = 0.0;
		double oldDistance = 0.0;

		for (IRestrictedVertex adjacentVertex : graph.getSuccessors(vertex)) {

			if (!adjacentVertex.isDone()) {
				IRestrictedEdge edge = graph.findEdge(vertex, adjacentVertex);
				graph.updateState(State.VISIT, edge);

				// graph.updateState(State.VISIT, adjacentVertex);

				newDistance = vertex.getCurrentResult()
						+ this.findMinEdge(graph, vertex, adjacentVertex)
								.getWeight();
				oldDistance = adjacentVertex.getCurrentResult();

				// set new predecessor for shortest path
				if (newDistance < oldDistance) {
					adjacentVertex.setValue(vertex);
				}

				adjacentVertex.setNewResult(Math.min(newDistance, oldDistance));
				adjacentVertex
						.setNewComment("Der neue kürzeste Weg vom Startknoten zum Knoten "
								+ adjacentVertex.getId()
								+ " ist: "
								+ adjacentVertex.getNewResult());

				List<IRestrictedGraphItem> visited = new ArrayList<>();
				visited.add(adjacentVertex);
				this.updatePathColor(graph, adjacentVertex, visited);
				graph.updateState(State.VISIT, toArray(visited));

				// graph.updateState(State.ACTIVATION, edge);
				// graph.updateState(State.ACTIVATION, vertex);

				if (Double.compare(newDistance, oldDistance) != 0) {
					prioQueue.update(adjacentVertex);
				}
			}
		}
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
			vertex.setNewComment("Der Knoten " + vertex.getId()
					+ " hat die folgenden Nachfolger: " + successors);
		}
	}

	/**
	 * @param graph
	 * @param startVertex
	 * @param endVertex
	 */
	private boolean updateEndVertexMessage(IRestrictedGraph graph,
			IRestrictedVertex startVertex, IRestrictedVertex endVertex) {

		if (endVertex.isEnd()) {
			List<IRestrictedGraphItem> solved = new ArrayList<>();
			solved.add(endVertex);
			this.updatePathColor(graph, endVertex, solved);

			endVertex.appendToNewComment(String.format(SHORTEST_PATH_OK, 
					startVertex.getId(), endVertex.getId()));
			graph.updateState(State.SOLUTION, toArray(solved));
			return true;
		}
		return false;
	}

	/**
	 * @param graph
	 * @param vertex1
	 * @param vertex2
	 * @return IRestrictedEdge
	 */
	private IRestrictedEdge findMinEdge(IRestrictedGraph graph,
			IRestrictedVertex vertex1, IRestrictedVertex vertex2) {

		Collection<? extends IRestrictedEdge> edgeSet = graph.findEdgeSet(
				vertex1, vertex2);
		IRestrictedEdge minEdge = graph.findEdge(vertex1, vertex2);

		for (IRestrictedEdge edge : edgeSet) {
			minEdge = edge.getWeight() < minEdge.getWeight() ? edge : minEdge;
		}

		return minEdge;
	}

	/**
	 * @param edges
	 * @throws AlgorithmException
	 */
	private void checkPositiveWeights(
			Collection<? extends IRestrictedEdge> edges)
			throws AlgorithmException {

		for (IRestrictedEdge edge : edges) {
			if (edge.getWeight() < 0) {
				throw new AlgorithmException(NEG_WEIGHT);
			}
		}
	}

	/**
	 * @param graph
	 * @param selectedVertex
	 */
	private void showShortestPath(IRestrictedGraph graph,
			IRestrictedVertex selectedVertex) {

		List<IRestrictedGraphItem> edgeList = new ArrayList<>();

		// for (IRestrictedEdge edge : graph.getEdges()) {
		// edge.setTagged(true);
		// edge.setVisible(false);
		// edgeList.add(edge);
		// }
		// graph.updateState(State.SOLUTION, toArray(edgeList));

		// edgeList = new ArrayList<>();
		IRestrictedVertex currentVertex = null;
		while (selectedVertex.getValue() != null) {
			currentVertex = (IRestrictedVertex) selectedVertex.getValue();
			IRestrictedEdge edge = this.findMinEdge(graph, currentVertex,
					selectedVertex);
			edge.setTagged(true);
			edgeList.add(edge);
			selectedVertex = currentVertex;
		}
		graph.updateState(State.SOLUTION, toArray(edgeList));
	}

	/**
	 * 
	 * @param graph
	 * @param selectedVertex
	 * @param graphItems
	 */
	private void updatePathColor(IRestrictedGraph graph,
			IRestrictedVertex selectedVertex,
			List<IRestrictedGraphItem> graphItems) {

		Collection<? extends IRestrictedVertex> predecessors = graph
				.getPredecessors(selectedVertex);
		
		// TODO Kanten und Knoten zurück zu init zustand
		for (IRestrictedVertex vertex : predecessors) {
			if (vertex.isDone()) {
				IRestrictedEdge edge = graph.findEdge(vertex, selectedVertex);
				edge.setTagged(true);
				graphItems.add(edge);
			}
		}
	}

}
