package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
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

	private final VertexPaintedResultComparator vertexResultComparator;

	protected AlgorithmDijkstra() {
		super();
		super.setName("Dijkstra algorithm");
		super.setDescription("Dijkstra algorithm for DIRECTED and UNDIRECTED edges. "
				+ "Negative weights are not allowed.");
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
	public void execute(IRestrictedGraph graph) throws Exception {

		// TODO bitte an dieser Methode nichts ändern (pk)

		// TODO bei Min-Auswahl: alle Auswahlmöglichkeiten fett marieren
		// TODO set comments in calculateDistances()

		this.checkPositiveWeights(graph.getEdges());

		Collection<? extends IRestrictedVertex> vertices = graph.getVertices();
		IRestrictedVertex startVertex = graph.getStartVertex();
		if (startVertex == null) {
			return;
		}

		startVertex.setComment(startVertex.getId() + " ist der Startknoten.");
		graph.updateState(State.ACTIVATION, startVertex);

		// start vertex has distance 0
		startVertex.setResult(0.0);
		startVertex.appendComment("Für den Knoten " + startVertex.getId()
				+ " wurde der kürzeste Weg vom Startknoten zum Endknoten berechnet berechnet: "
				+ startVertex.getResult());
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
			vertex.setResult(Double.POSITIVE_INFINITY);
			vertex.setComment("Der Knoten " + vertex.getId()
					+ " wurde mit folgendem Wert initialisiert: "
					+ vertex.getResult());
			graph.updateState(State.ACTIVATION, vertex);
		}

		this.setSuccessorMessage(graph, startVertex);
		graph.updateState(State.ACTIVATION, startVertex);

		// init edge weight as distance for all successors of start vertex
		for (IRestrictedVertex vertex : graph.getSuccessors(startVertex)) {
			IRestrictedEdge edge = graph.findEdge(startVertex, vertex);
			graph.updateState(State.ACTIVATION, edge);

			graph.updateState(State.ACTIVATION, vertex);

			vertex.setValue(startVertex);
			vertex.setResult(this.findMinEdge(graph, startVertex, vertex)
					.getWeight());
			vertex.setComment("Der neue kürzeste Weg vom Startknoten zum Knoten "
					+ vertex.getId() + " ist: " + vertex.getResult());

			List<IRestrictedGraphItem> visited = new ArrayList<>();
			visited.add(vertex);
			this.updatePathColor(graph, vertex, visited);
			graph.updateState(State.VISIT, toArray(visited));

			graph.updateState(State.ACTIVATION, edge);

			graph.updateState(State.ACTIVATION, startVertex);
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
					.setComment("Das Minimum aller noch nicht zur Lösung gehörenden"
							+ " Knoten ist "
							+ selectedVertex.getId()
							+ " mit der aktuellen Distanz: "
							+ selectedVertex.getPaintedResult());
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
				graph.updateState(State.ACTIVATION, edge);

				graph.updateState(State.ACTIVATION, adjacentVertex);

				newDistance = vertex.getPaintedResult()
						+ this.findMinEdge(graph, vertex, adjacentVertex)
								.getWeight();
				oldDistance = adjacentVertex.getPaintedResult();

				// set new predecessor for shortest path
				if (newDistance < oldDistance) {
					adjacentVertex.setValue(vertex);
				}

				adjacentVertex.setResult(Math.min(newDistance, oldDistance));
				adjacentVertex
						.setComment("Der neue kürzeste Weg vom Startknoten zum Knoten "
								+ adjacentVertex.getId()
								+ " ist: "
								+ adjacentVertex.getResult());

				List<IRestrictedGraphItem> visited = new ArrayList<>();
				visited.add(adjacentVertex);
				this.updatePathColor(graph, adjacentVertex, visited);
				graph.updateState(State.VISIT, toArray(visited));

				graph.updateState(State.ACTIVATION, edge);
				graph.updateState(State.ACTIVATION, vertex);

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
			vertex.setComment("Der Knoten " + vertex.getId()
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
			
			endVertex.appendComment("Der kürzeste Weg von "
					+ startVertex.getId() + " nach " + endVertex.getId()
					+ " wurde gefunden.");
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
				throw new AlgorithmException("Dijkstra algorithm: "
						+ "Negative weights are not allowed!");
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
		
		for (IRestrictedEdge edge : graph.getEdges()) {
//			edge.setTagged(true);
			edge.setVisible(false);
			edgeList.add(edge);
		}
//		graph.updateState(State.SOLUTION, toArray(edgeList));
		
//		edgeList = new ArrayList<>();
		IRestrictedVertex currentVertex = null;
		while (selectedVertex.getValue() != null) {
			currentVertex = (IRestrictedVertex) selectedVertex.getValue();
			IRestrictedEdge edge = this.findMinEdge(graph, currentVertex, selectedVertex);
			edge.setVisible(true);
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
		
		for (IRestrictedVertex vertex : predecessors) {
			
			if (vertex.getState() == State.SOLUTION) {
				Collection<? extends IRestrictedEdge> edgeSet = graph
						.findEdgeSet(vertex, selectedVertex);

				for (IRestrictedEdge edge : edgeSet) {
					edge.setTagged(true);
					graphItems.add(edge);
				}
			}
		}
	}

}
