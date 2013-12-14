package ch.bfh.bti7301.hs2013.gravis.core.algorithm.impl;

import static ch.bfh.bti7301.hs2013.gravis.core.graph.item.GraphItemUtils.setGraphItemValues;
import static ch.bfh.bti7301.hs2013.gravis.core.util.transformer.ValueTransformer.toArray;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ch.bfh.bti7301.hs2013.gravis.core.algorithm.AbstractAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.core.algorithm.AlgorithmException;
import ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class AlgorithmBreadthFirstSearch extends AbstractAlgorithm implements
		IAlgorithm {

	private final static String ALGO_NAME = "Breadth-First-Search Algorithmus (BFS)";
	private final static String ALGO_DESCRIPTION = "Die Breitensuche ist als Schleife "
			+ "implementiert. Es sind sowohl gerichtete als auch ungerichtete Graphen "
			+ "zulässig. Die Breitensuche wird für jede (schwache) Zusammenhangskomponente "
			+ "separat durchgefürt.";
	private final static String END_MSG1 = "Der Endknoten %s wurde erreicht.";
	private final static String END_MSG2 = "Die Breitensuche wurde erfolgreich beendet.";

	private int counter = 0;

	public AlgorithmBreadthFirstSearch() {
		super();
		super.setName(ALGO_NAME);
		super.setDescription(ALGO_DESCRIPTION);

		// super.setName("Breadth-first search (BFS)");
		// super.setDescription("Breadth-first search (BFS) for
		// DIRECTED and UNDIRECTED edges.");
		// Jede Zushang Komp Breitensuche

		// TODO annotations
		super.setEdgeTypes(new EdgeType[] {});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.algorithm.AbstractAlgorithm#execute
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(IRestrictedGraph graph) throws AlgorithmException {
		this.counter = 0;
		Queue<IRestrictedVertex> vertexQueue = new LinkedList<>();
		Collection<? extends IRestrictedVertex> vertices = graph.getVertices();
		IRestrictedVertex startVertex = graph.getStartVertex();
		List<IRestrictedGraphItem> itemList = new ArrayList<IRestrictedGraphItem>();

		startVertex.setDone(true);
		vertexQueue.offer(startVertex);
		vertices.remove(startVertex);

		for (IRestrictedVertex rVertex : vertices) {
			while (!vertexQueue.isEmpty()) {
				IRestrictedVertex selectedVertex = vertexQueue.poll();

				this.tagEdges(graph, itemList, selectedVertex, State.SOLUTION);
				setGraphItemValues(selectedVertex, ++this.counter, true, true,
						State.SOLUTION);
				itemList.add(selectedVertex);
				if (this.updateEndVertexMessage(graph, itemList, selectedVertex)) {
					return;
				}
				graph.updateState(toArray(itemList));
				itemList.clear();

				setGraphItemValues(selectedVertex, false, false, State.SOLUTION);
				itemList.add(selectedVertex);

				this.visitSuccessors(graph, vertexQueue, itemList,
						selectedVertex);
			}

			if (!rVertex.isDone()) {
				rVertex.setDone(true);
				vertexQueue.offer(rVertex);
			}
		}

		if (!itemList.isEmpty()) {
			itemList.get(itemList.size() - 1).setNewComment(END_MSG2);
		}
		graph.updateState(toArray(itemList));
	}

	/**
	 * @param graph
	 * @param vertexQueue
	 * @param itemList
	 * @param selectedVertex
	 */
	private void visitSuccessors(IRestrictedGraph graph,
			Queue<IRestrictedVertex> vertexQueue,
			List<IRestrictedGraphItem> itemList,
			IRestrictedVertex selectedVertex) {

		for (IRestrictedVertex successor : graph.getSuccessors(selectedVertex)) {
			if (!successor.isDone()) {
				this.tagEdges(graph, itemList, successor, State.VISIT);
				successor.setDone(true);
				setGraphItemValues(successor, true, true, State.VISIT);
				itemList.add(successor);
				graph.updateState(toArray(itemList));
				itemList.clear();

				setGraphItemValues(successor, false, false, State.VISIT);
				itemList.add(successor);

				vertexQueue.offer(successor);
			}
		}
	}

	/**
	 * 
	 * @param graph
	 * @param itemList
	 * @param vertex
	 * @param state
	 */
	private void tagEdges(IRestrictedGraph graph,
			List<IRestrictedGraphItem> itemList, IRestrictedVertex vertex,
			State state) {

		for (IRestrictedVertex v : graph.getPredecessors(vertex)) {
			if (v.getCurrentState() == State.SOLUTION) {
				IRestrictedEdge edge = graph.findEdge(v, vertex);
				setGraphItemValues(edge, true, true, state);
				itemList.add(edge);
			}
		}
	}

	/**
	 * @param graph
	 * @param itemList
	 * @param endVertex
	 */
	private boolean updateEndVertexMessage(IRestrictedGraph graph,
			List<IRestrictedGraphItem> itemList, IRestrictedVertex endVertex) {

		if (endVertex.isEnd()) {
			endVertex.setNewComment(String.format(END_MSG1, endVertex.getId()));
			graph.updateState(toArray(itemList));
			itemList.clear();
			return true;
		}
		return false;
	}

}
