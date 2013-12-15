package ch.bfh.bti7301.hs2013.gravis.core.algorithm.impl;

import static ch.bfh.bti7301.hs2013.gravis.core.graph.item.GraphItemUtils.setGraphItemValues;
import static ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.transformer.ValueTransformer.toArray;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ch.bfh.bti7301.hs2013.gravis.core.algorithm.AbstractAlgorithm;
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
class AlgorithmDLSRecursive extends AbstractAlgorithm implements IAlgorithm {

	private final static String ALGO_NAME = "Rekursiver Depth-Last-Search Algorithmus (DLS)";
	private final static String ALGO_DESCRIPTION = "Der Graph wird in Postorder traversiert. "
			+ "Es sind sowohl gerichtete als auch ungerichtete Graphen zulässig."
			+ "Die Knoten werden in Postorder-Reihenfolge nummeriert.";
	private final static String END_MSG1 = "Der Endknoten %s wurde erreicht.";
	private final static String END_MSG2 = "Die Postorder-Traversierung wurde erfolgreich "
			+ "beendet.";

	private int counter = 0;

	protected AlgorithmDLSRecursive() {
		super();
		super.setName(ALGO_NAME);
		super.setDescription(ALGO_DESCRIPTION);

		// super.setName("Depth-last search (DLS), recursive");
		// super.setDescription("Depth-last search (DLS) for DIRECTED and UNDIRECTED edges, "
		// + "implemented recursively.");
		// TODO annotations
		super.setEdgeTypes(new EdgeType[] {});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.algorithm.AbstractAlgorithm#execute
	 * (ch.bfh .bti7301.hs2013.gravis.graph.IImmutableGraph)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(IRestrictedGraph graph) {
		List<IRestrictedGraphItem> itemList = new ArrayList<IRestrictedGraphItem>();
		this.counter = 0;

		for (IRestrictedVertex vertex : graph.getVertices()) {
			if (!vertex.isDone()) {
				boolean abort = this.visit(graph, itemList, vertex);

				if (abort) {
					return;
				}
			}
		}

		if (!itemList.isEmpty()) {
			itemList.get(itemList.size() - 1).setNewComment(END_MSG2);
		}
		graph.updateState(toArray(itemList));
	}

	/**
	 * 
	 * @param graph
	 * @param itemList
	 * @param vertex1
	 * @return boolean
	 */
	private boolean visit(IRestrictedGraph graph,
			List<IRestrictedGraphItem> itemList, IRestrictedVertex vertex1) {
		vertex1.setDone(true);
		setGraphItemValues(vertex1, true, true, State.VISIT);
		itemList.add(vertex1);
		graph.updateState(toArray(itemList));
		itemList.clear();

		Iterator<? extends IRestrictedVertex> vertexIterator = graph
				.getSuccessors(vertex1).iterator();
		while (vertexIterator.hasNext()) {
			IRestrictedVertex vertex2 = vertexIterator.next();

			if (!vertex2.isDone()) {
				IRestrictedEdge edge = graph.findEdge(vertex1, vertex2);
				setGraphItemValues(edge, true, true, State.VISIT);
				itemList.add(edge);

				boolean abort = this.visit(graph, itemList, vertex2);

				if (abort) {
					return true;
				}

				this.activateVertex(graph, itemList, vertex1, vertexIterator);
			}
		}

		this.tagSolvedEdges(graph, itemList, vertex1);
		setGraphItemValues(vertex1, ++this.counter, true, true, State.SOLUTION);
		itemList.add(vertex1);
		if (this.updateEndVertexMessage(graph, itemList, vertex1)) {
			return true;
		}
		graph.updateState(toArray(itemList));
		itemList.clear();

		setGraphItemValues(vertex1, false, false, State.SOLUTION);
		itemList.add(vertex1);
		return false;
	}

	/**
	 * @param graph
	 * @param itemList
	 * @param vertex1
	 * @param vertexIterator
	 */
	private void activateVertex(IRestrictedGraph graph,
			List<IRestrictedGraphItem> itemList, IRestrictedVertex vertex1,
			Iterator<? extends IRestrictedVertex> vertexIterator) {

		if (vertexIterator.hasNext()) {
			setGraphItemValues(vertex1, true, true, State.ACTIVATION);
			itemList.add(vertex1);
			graph.updateState(toArray(itemList));
			itemList.clear();

			setGraphItemValues(vertex1, false, false, State.VISIT);
			itemList.add(vertex1);
		}
	}

	/**
	 * @param graph
	 * @param itemList
	 * @param vertex1
	 */
	private void tagSolvedEdges(IRestrictedGraph graph,
			List<IRestrictedGraphItem> itemList, IRestrictedVertex vertex1) {

		for (IRestrictedVertex vertex : graph.getSuccessors(vertex1)) {
			if (vertex.getCurrentState() == State.SOLUTION) {
				IRestrictedEdge edge = graph.findEdge(vertex1, vertex);
				setGraphItemValues(edge, true, true, State.SOLUTION);
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
