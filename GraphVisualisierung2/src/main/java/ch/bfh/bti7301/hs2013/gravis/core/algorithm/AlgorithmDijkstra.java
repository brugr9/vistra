package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import java.util.Collection;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.comparator.VertexPaintedResultComparator;
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

		// TODO visualize edges
		// TODO bei Min-Auswahl: alle Auswahlmöglichkeiten fett marieren
		// TODO set comments in calculateDistances()
		// TODO falls kein start vertex, wähle default start

		this.checkPositiveWeights(graph.getEdges());

		Collection<? extends IRestrictedVertex> vertices = graph.getVertices();
		IRestrictedVertex startVertex = graph.getStartVertex();

		startVertex.setComment(startVertex.getId() + " ist der Startknoten.");
		graph.updateState(startVertex, State.ACTIVATION);

		// start vertex has distance 0
		startVertex.setResult(0.0);
		this.setSuccessorMessage(graph, startVertex);
		startVertex.appendComment("Für den Knoten " + startVertex.getId()
				+ " wurde der kürzeste Weg berechnet: "
				+ startVertex.getResult());
		startVertex.setDone(true);

		if (this.updateEndVertexMessage(graph, startVertex, startVertex)) {
			return;
		}

		graph.updateState(startVertex, State.SOLUTION);
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
			graph.updateState(vertex, State.ACTIVATION);
		}

		startVertex.setComment("Rückkehr zum Startknoten "
				+ startVertex.getId() + ".");
		graph.updateState(startVertex, State.ACTIVATION);

		// init edge weight as distance for all successors of start vertex
		for (IRestrictedVertex vertex : graph.getSuccessors(startVertex)) {
			IRestrictedEdge edge = graph.findEdge(startVertex, vertex);
			graph.updateState(edge, State.ACTIVATION);
			
			vertex.setComment("Der Knoten " + vertex.getId()
					+ " wird aktiviert.");
			graph.updateState(vertex, State.ACTIVATION);
			
			vertex.setResult(this.findMinEdge(graph, startVertex, vertex)
					.getWeight());
			vertex.setComment("Der Knoten " + vertex.getId()
					+ " wurde als besucht markiert. "
					+ "Der neue kürzeste Weg vom Startknoten aus ist: "
					+ vertex.getResult());
			graph.updateState(vertex, State.VISIT);

			edge = graph.findEdge(startVertex, vertex);
			graph.updateState(edge, State.ACTIVATION);
			
			startVertex.setComment("Der Knoten " + startVertex.getId()
					+ " wird aktiviert.");
			graph.updateState(startVertex, State.ACTIVATION);
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

			graph.updateState(selectedVertex, State.ACTIVATION);

			this.setSuccessorMessage(graph, selectedVertex);
			selectedVertex.setDone(true);
			if (this.updateEndVertexMessage(graph, startVertex, selectedVertex)) {
				return;
			}
			graph.updateState(selectedVertex, State.SOLUTION);
			
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
				graph.updateState(adjacentVertex, State.ACTIVATION);

				newDistance = vertex.getPaintedResult()
						+ this.findMinEdge(graph, vertex, adjacentVertex)
								.getWeight();
				oldDistance = adjacentVertex.getPaintedResult();

				adjacentVertex.setResult(Math.min(newDistance, oldDistance));
				graph.updateState(adjacentVertex, State.VISIT);

				if (Double.compare(newDistance, oldDistance) != 0) {
					prioQueue.update(adjacentVertex);
				}

				graph.updateState(vertex, State.ACTIVATION);
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
			endVertex.appendComment("Der kürzeste Weg von " + startVertex.getId()
					+ " nach " + endVertex.getId() + " wurde gefunden.");
			graph.updateState(endVertex, State.SOLUTION);
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

}
