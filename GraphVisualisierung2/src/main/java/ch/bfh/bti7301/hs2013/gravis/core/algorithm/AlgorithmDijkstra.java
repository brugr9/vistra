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
	private final static String SHORTEST_PATH_OK = "Der kürzeste Weg von %s nach "
			+ "%s wurde gefunden: %.1f";
	private final static String SHORTEST_PATH_UPDATE = "Der neue kürzeste Weg von %s nach "
			+ "%s ist: %.1f";
	private final static String RESULT_INIT = "Der Knoten %s wurde mit folgendem Wert "
			+ "initialisiert: %.1f";
	private final static String SUCCESSOR_MSG = "Der Knoten %s hat die folgenden "
			+ "Nachfolger: %s";

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
		startVertex.setTagged(true);
		graph.updateState(State.VISIT, startVertex);

		// start vertex has distance 0
		startVertex.setDone(true);
		if (this.updateEndVertexMessage(graph, startVertex, startVertex)) {
			return;
		}
		graph.updateState(State.SOLUTION, startVertex);
		vertices.remove(startVertex);

		List<IRestrictedGraphItem> itemList = this.initializeDistances(graph,
				vertices, startVertex);
		this.calculateDistances(graph, vertices, itemList, startVertex);
	}

	/**
	 * 
	 * @param graph
	 * @param vertices
	 * @param startVertex
	 * @return List<IRestrictedGraphItem>
	 */
	private List<IRestrictedGraphItem> initializeDistances(
			IRestrictedGraph graph,
			Collection<? extends IRestrictedVertex> vertices,
			IRestrictedVertex startVertex) {
		List<IRestrictedGraphItem> itemList = new ArrayList<IRestrictedGraphItem>();

		this.tagGraphItems(vertices, true);
		startVertex.setTagged(false);
		itemList.add(startVertex);
		// initialize infinite distance from start vertex
		for (IRestrictedVertex vertex : vertices) {
			vertex.setNewResult(Double.POSITIVE_INFINITY);
			vertex.setNewComment(String.format(RESULT_INIT, vertex.getId(),
					vertex.getNewResult()));
			itemList.add(vertex);
		}
		graph.updateState(toArray(itemList));
		itemList.clear();
		
		this.tagGraphItems(vertices, itemList, false);
		startVertex.setTagged(true);
		itemList.add(startVertex);
		this.setSuccessorMessage(graph, startVertex);
		graph.updateState(toArray(itemList));
		itemList.clear();

		this.calculateStartDistances(graph, itemList, startVertex);
		return itemList;
	}

	/**
	 * @param graph
	 * @param itemList
	 * @param startVertex
	 */
	private void calculateStartDistances(IRestrictedGraph graph,
			List<IRestrictedGraphItem> itemList, IRestrictedVertex startVertex) {

		startVertex.setTagged(false);
		itemList.add(startVertex);
		// init edge weight as distance for all successors of start vertex
		for (IRestrictedVertex vertex : graph.getSuccessors(startVertex)) {
			IRestrictedEdge edge = graph.findEdge(startVertex, vertex);
			edge.setTagged(true);
			edge.setNewState(State.VISIT);
			itemList.add(edge);
			vertex.setValue(startVertex);
			vertex.setTagged(true);
			vertex.setNewResult(graph.findEdge(startVertex, vertex).getWeight());
			vertex.setNewComment(String.format(SHORTEST_PATH_UPDATE,
					startVertex.getId(), vertex.getId(), vertex.getNewResult()));
			vertex.setNewState(State.VISIT);
			itemList.add(vertex);
			graph.updateState(toArray(itemList));
			itemList.clear();

			vertex.setTagged(false);
			itemList.add(vertex);
		}
	}

	/**
	 * @param graph
	 * @param vertices
	 * @param itemList
	 * @param startVertex
	 */
	private void calculateDistances(IRestrictedGraph graph,
			Collection<? extends IRestrictedVertex> vertices,
			List<IRestrictedGraphItem> itemList, IRestrictedVertex startVertex) {

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
			itemList.add(selectedVertex);
			selectedVertex.setTagged(true);
			selectedVertex.setNewState(State.ACTIVATION);
			graph.updateState(toArray(itemList));
			itemList.clear();

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
						+ graph.findEdge(vertex, adjacentVertex).getWeight();
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
	 * @param startVertex
	 * @param endVertex
	 */
	private boolean updateEndVertexMessage(IRestrictedGraph graph,
			IRestrictedVertex startVertex, IRestrictedVertex endVertex) {

		if (endVertex.isEnd()) {
			List<IRestrictedGraphItem> solvedItems = new ArrayList<>();
			solvedItems.add(endVertex);
			this.updatePathColor(graph, endVertex, solvedItems);

			endVertex.appendToNewComment(String.format(SHORTEST_PATH_OK,
					startVertex.getId(), endVertex.getId(),
					endVertex.getCurrentResult()));
			graph.updateState(State.SOLUTION, toArray(solvedItems));
			return true;
		}
		return false;
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

		for (IRestrictedVertex vertex : predecessors) {
			if (vertex.isDone()) {
				IRestrictedEdge edge = graph.findEdge(vertex, selectedVertex);
				edge.setTagged(true);
				graphItems.add(edge);
			}
		}
	}

	/**
	 * @param vertices
	 * @param value
	 */
	private void tagGraphItems(
			Collection<? extends IRestrictedVertex> vertices, boolean value) {
		for (IRestrictedVertex vertex : vertices) {
			vertex.setTagged(value);
		}
	}

	/**
	 * @param vertices
	 * @param graphItems
	 * @param value
	 */
	private void tagGraphItems(
			Collection<? extends IRestrictedVertex> vertices,
			List<IRestrictedGraphItem> graphItems, boolean value) {
		for (IRestrictedVertex vertex : vertices) {
			vertex.setTagged(value);
			graphItems.add(vertex);
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
			vertex.setNewComment(String.format(SUCCESSOR_MSG, vertex.getId(),
					successors));
		}
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

		// TODO Kanten und Knoten zurück zu init zustand
		// edgeList = new ArrayList<>();
		IRestrictedVertex currentVertex = null;
		while (selectedVertex.getValue() != null) {
			currentVertex = (IRestrictedVertex) selectedVertex.getValue();
			IRestrictedEdge edge = graph
					.findEdge(currentVertex, selectedVertex);
			edge.setTagged(true);
			edgeList.add(edge);
			selectedVertex = currentVertex;
		}
		graph.updateState(State.SOLUTION, toArray(edgeList));
	}

}
