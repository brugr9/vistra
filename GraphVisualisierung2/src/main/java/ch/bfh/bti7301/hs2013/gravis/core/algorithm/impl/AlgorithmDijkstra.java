package ch.bfh.bti7301.hs2013.gravis.core.algorithm.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ch.bfh.bti7301.hs2013.gravis.core.algorithm.AbstractAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.core.algorithm.AlgorithmException;
import ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.comparator.VertexPaintedResultComparator;
import static ch.bfh.bti7301.hs2013.gravis.core.graph.item.GraphItemUtils.setGraphItemValues;
import static ch.bfh.bti7301.hs2013.gravis.core.graph.item.GraphItemUtils.tagGraphItems;
import static ch.bfh.bti7301.hs2013.gravis.util.transformer.ValueTransformer.toArray;
import edu.uci.ics.jung.algorithms.util.MapBinaryHeap;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class AlgorithmDijkstra extends AbstractAlgorithm implements IAlgorithm {

	private final static String NEG_WEIGHT = "Dijkstra algorithm: "
			+ "negative weights are not allowed!";
	private final static String NO_START_VERTEX = "Dijkstra algorithm: no start vertex "
			+ "found in graph %s!";

	private final static String ALGO_NAME = "Dijkstra-Algorithmus";
	private final static String ALGO_DESCRIPTION = "Der Dijkstra-Algorithmus findet den "
			+ "kürzesten Weg zwischen zwei Knoten. Ein Startknoten muss im Graphen vorhanden "
			+ "sein. Ist kein Endknoten vorhanden, so wird der kürteste Weg vom Startknoten "
			+ "zu allen anderen Knoten berechnet. Diese Implementation des Algorithmus "
			+ "funktioniert mit gerichteten oder ungerichteten Kanten. Negative "
			+ "Kantengewichte und Mehrfachkanten sind nicht erlaubt.";
	private final static String START_VERTEX = "%s ist der Startknoten.";
	private final static String SHORTEST_PATH_OK = "Der kürzeste Weg von %s nach "
			+ "%s wurde gefunden: %.1f";
	private final static String SHORTEST_PATH_UPDATE = "Der neue kürzeste Weg vom "
			+ " Startknoten zum Knoten %s ist: %.1f";
	private final static String RESULT_INIT = "Der Knoten %s wurde mit folgendem Wert "
			+ "initialisiert: %.1f";
	private final static String SUCCESSOR_MSG = "Der Knoten %s hat die folgenden "
			+ "Nachfolger: %s";
	private final static String MIN_MSG = "Der Knoten %s hat die folgende minimale "
			+ "Distanz: %.1f";
	private final static String END_MSG = "Die Berechnung der kürzesten Weges wurde "
			+ "erfolgreich abgeschlossen.";

	private final VertexPaintedResultComparator vertexResultComparator;

	protected AlgorithmDijkstra() {
		super();
		super.setName(ALGO_NAME);
		super.setDescription(ALGO_DESCRIPTION);

		// super.setName("Dijkstra algorithm");
		// super.setDescription("Dijkstra algorithm for DIRECTED and UNDIRECTED edges. "
		// + "Negative weights and multi-edges are not allowed.");
		// TODO annotations
		super.setEdgeTypes(new EdgeType[] {});

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
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(IRestrictedGraph graph) throws AlgorithmException {
		this.checkPositiveWeights(graph.getEdges());

		Collection<? extends IRestrictedVertex> vertices = graph.getVertices();
		IRestrictedVertex startVertex = graph.getStartVertex();

		if (startVertex == null) {
			throw new AlgorithmException(String.format(NO_START_VERTEX, graph));
		}

		// start vertex has distance 0
		setGraphItemValues(startVertex, 0.0, true, true,
				String.format(START_VERTEX, startVertex.getId()));
		graph.updateState(State.VISIT, startVertex);

		startVertex.setDone(true);
		setGraphItemValues(startVertex, true, true);
		if (this.updateEndVertexMessage(graph, startVertex, startVertex, false)) {
			return;
		}
		graph.updateState(State.SOLUTION, startVertex);

		setGraphItemValues(startVertex, false, false);
		List<IRestrictedGraphItem> itemList = this.initializeDistances(graph,
				vertices, startVertex);
		this.calculateDistances(graph, vertices, itemList, startVertex);
		if (!itemList.isEmpty()) {
			graph.updateState(toArray(itemList));
		}
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

		itemList.add(startVertex);
		// initialize infinite distance from start vertex
		for (IRestrictedVertex vertex : vertices) {
			if (vertex != startVertex) {
				setGraphItemValues(vertex, Double.POSITIVE_INFINITY, true,
						false, String.format(RESULT_INIT, vertex.getId(),
								Double.POSITIVE_INFINITY));
				itemList.add(vertex);
			}
		}
		graph.updateState(toArray(itemList));
		itemList.clear();

		tagGraphItems(vertices, itemList, false);
		setGraphItemValues(startVertex, true, false);
		this.setSuccessorMessage(graph, startVertex);
		itemList.add(startVertex);
		graph.updateState(toArray(itemList));
		itemList.clear();

		setGraphItemValues(startVertex, false, false);
		itemList.add(startVertex);
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

		// init edge weight as distance for all successors of start vertex
		for (IRestrictedVertex vertex : graph.getSuccessors(startVertex)) {
			IRestrictedEdge edge = graph.findEdge(startVertex, vertex);
			setGraphItemValues(edge, true, true, State.VISIT);
			itemList.add(edge);
			vertex.setValue(startVertex);
			double newResult = graph.findEdge(startVertex, vertex).getWeight();
			setGraphItemValues(vertex, newResult, true, true, String.format(
					SHORTEST_PATH_UPDATE, vertex.getId(), newResult),
					State.VISIT);
			itemList.add(vertex);
			graph.updateState(toArray(itemList));
			itemList.clear();

			setGraphItemValues(vertex, false, false);
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
			if (selectedVertex == startVertex) {
				continue;
			}

			setGraphItemValues(selectedVertex, true, true, String.format(
					MIN_MSG, selectedVertex.getId(),
					selectedVertex.getCurrentResult()), State.ACTIVATION);
			itemList.add(selectedVertex);
			graph.updateState(toArray(itemList));
			itemList.clear();

			setGraphItemValues(selectedVertex, true, true, State.SOLUTION);
			selectedVertex.setDone(true);
			itemList.add(selectedVertex);
			if (this.updateEndVertexMessage(itemList, graph, startVertex,
					selectedVertex, true)) {
				this.showShortestPath(itemList, graph, selectedVertex);
				return;
			}
			this.setSuccessorMessage(graph, selectedVertex);
			this.updatePathColor(graph, selectedVertex, itemList);
			graph.updateState(toArray(itemList));
			itemList.clear();

			setGraphItemValues(selectedVertex, false, false);
			itemList.add(selectedVertex);
			this.updateAdjacentVertexDistances(graph, selectedVertex,
					prioQueue, itemList);
		}
	}

	/**
	 * @param graph
	 * @param vertex
	 * @param prioQueue
	 * @param itemList
	 */
	private void updateAdjacentVertexDistances(IRestrictedGraph graph,
			IRestrictedVertex vertex,
			MapBinaryHeap<IRestrictedVertex> prioQueue,
			List<IRestrictedGraphItem> itemList) {
		double newDistance = 0.0;
		double oldDistance = 0.0;

		for (IRestrictedVertex adjacentVertex : graph.getSuccessors(vertex)) {
			if (!adjacentVertex.isDone()) {
				IRestrictedEdge edge = graph.findEdge(vertex, adjacentVertex);
				setGraphItemValues(edge, true, true, State.VISIT);
				itemList.add(edge);

				newDistance = vertex.getCurrentResult() + edge.getWeight();
				oldDistance = adjacentVertex.getCurrentResult();
				// set new predecessor for shortest path
				if (newDistance < oldDistance) {
					adjacentVertex.setValue(vertex);
				}
				double min = Math.min(newDistance, oldDistance);
				setGraphItemValues(
						adjacentVertex,
						min,
						true,
						true,
						String.format(SHORTEST_PATH_UPDATE,
								adjacentVertex.getId(), min), State.VISIT);
				itemList.add(adjacentVertex);
				graph.updateState(toArray(itemList));
				itemList.clear();

				setGraphItemValues(adjacentVertex, false, false);
				itemList.add(adjacentVertex);
				if (Double.compare(newDistance, oldDistance) != 0) {
					// adjust the position of adjacentVertex in the proirity
					// queue, if the distance has changed
					prioQueue.update(adjacentVertex);
				}
			}
		}
	}

	/**
	 * 
	 * @param itemList
	 * @param graph
	 * @param startVertex
	 * @param endVertex
	 * @param isStateCommentEnabled
	 * @return boolean
	 */
	private boolean updateEndVertexMessage(List<IRestrictedGraphItem> itemList,
			IRestrictedGraph graph, IRestrictedVertex startVertex,
			IRestrictedVertex endVertex, boolean isStateCommentEnabled) {

		if (endVertex.isEnd()) {
			setGraphItemValues(endVertex, true, isStateCommentEnabled,
					String.format(SHORTEST_PATH_OK, startVertex.getId(),
							endVertex.getId(), endVertex.getCurrentResult()),
					State.SOLUTION);
			itemList.add(endVertex);
			this.updatePathColor(graph, endVertex, itemList);
			graph.updateState(toArray(itemList));
			itemList.clear();
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param graph
	 * @param startVertex
	 * @param endVertex
	 * @param isStateCommentEnabled
	 * @return boolean
	 */
	private boolean updateEndVertexMessage(IRestrictedGraph graph,
			IRestrictedVertex startVertex, IRestrictedVertex endVertex,
			boolean isStateCommentEnabled) {

		return updateEndVertexMessage(new ArrayList<IRestrictedGraphItem>(),
				graph, startVertex, endVertex, isStateCommentEnabled);
	}

	/**
	 * 
	 * @param graph
	 * @param selectedVertex
	 * @param itemList
	 */
	private void updatePathColor(IRestrictedGraph graph,
			IRestrictedVertex selectedVertex,
			List<IRestrictedGraphItem> itemList) {

		Collection<? extends IRestrictedVertex> predecessors = graph
				.getPredecessors(selectedVertex);

		for (IRestrictedVertex vertex : predecessors) {
			if (vertex.isDone()) {
				IRestrictedEdge edge = graph.findEdge(vertex, selectedVertex);
				setGraphItemValues(edge, true, false, State.SOLUTION);
				itemList.add(edge);
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
	 * @param itemList
	 * @param graph
	 * @param selectedVertex
	 */
	private void showShortestPath(List<IRestrictedGraphItem> itemList,
			IRestrictedGraph graph, IRestrictedVertex selectedVertex) {

		for (IRestrictedEdge edge : graph.getEdges()) {
			setGraphItemValues(edge, false, false, State.INITIAL);
			itemList.add(edge);
		}

		for (IRestrictedVertex vertex : graph.getVertices()) {
			setGraphItemValues(vertex, false, false, State.INITIAL);
			itemList.add(vertex);
		}

		IRestrictedVertex currentVertex = null;
		setGraphItemValues(selectedVertex, true, false, END_MSG, State.SOLUTION);
		while (selectedVertex.getValue() != null) {
			currentVertex = (IRestrictedVertex) selectedVertex.getValue();
			IRestrictedEdge edge = graph
					.findEdge(currentVertex, selectedVertex);
			setGraphItemValues(edge, true, false, State.SOLUTION);
			itemList.add(edge);
			setGraphItemValues(currentVertex, true, false, State.SOLUTION);
			selectedVertex = currentVertex;
		}
		graph.updateState(toArray(itemList));
		itemList.clear();
	}

}
