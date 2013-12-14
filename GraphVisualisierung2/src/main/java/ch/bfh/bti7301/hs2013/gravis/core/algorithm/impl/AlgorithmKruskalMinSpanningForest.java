package ch.bfh.bti7301.hs2013.gravis.core.algorithm.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.apache.commons.collections15.map.HashedMap;

import ch.bfh.bti7301.hs2013.gravis.core.algorithm.AbstractAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.core.algorithm.AlgorithmException;
import ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.Partition;
import ch.bfh.bti7301.hs2013.gravis.core.util.comparator.EdgeWeightComparator;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.graph.util.Pair;
import static ch.bfh.bti7301.hs2013.gravis.core.util.GraphItemUtils.setGraphItemValues;
import static ch.bfh.bti7301.hs2013.gravis.core.util.transformer.ValueTransformer.toArray;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class AlgorithmKruskalMinSpanningForest extends AbstractAlgorithm
		implements IAlgorithm {

	private final static String DIRECTED_EDGE = "Kruskal algorithm: DIRECTED "
			+ "edges are not allowed!";

	private final static String ALGO_NAME = "Algorithmus von Kruskal";
	private final static String ALGO_DESCRIPTION = "Diese Implementation "
			+ "berechnet einen minimalen Spannwald für einen gegebenen Graphen. "
			+ "Der Graph muss ungerichtet sein. Ein Start- und Endknoten muss nicht "
			+ "angegeben werden. Die Kanten der Lösung zeigen neben dem Gewicht auch "
			+ "an, in welcher Reihenfolge sie zur Lösung hinzugefügt wurden.";
	private final static String MIN_EDGE = "Die aktuelle Kante mit dem kleinsten "
			+ "Gewicht: %s";
	private final static String CIRCLE_EDGE = "Die Kante %s kann nicht zur Lösung "
			+ "hinzugefügt werden, da sonst ein Kreis ensteht.";
	private final static String END_MSG = "Der minimale Spannwald wurde erfolgreich "
			+ "berechnet.";

	private int counter = 0;

	public AlgorithmKruskalMinSpanningForest() {
		super();
		super.setName(ALGO_NAME);
		super.setDescription(ALGO_DESCRIPTION);

		// super.setName("Kruskal algorithm");
		// super.setDescription("Kruskal algorithm: Calculates a minimal spanning forest from a "
		// + "given graph. The graph must be UNDIRECTED.");
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
		this.checkEdgeType(graph);

		this.counter = 0;
		Map<IRestrictedVertex, Partition<IRestrictedVertex>> partitionMap = new HashedMap<>();
		Collection<? extends IRestrictedVertex> vertices = graph.getVertices();
		PriorityQueue<IRestrictedEdge> prioQueue = new PriorityQueue<>(
				vertices.size(), new EdgeWeightComparator());
		List<IRestrictedGraphItem> itemList = new ArrayList<IRestrictedGraphItem>();
		IRestrictedEdge selectedEdge = null;

		for (IRestrictedVertex vertex : vertices) {
			partitionMap.put(vertex, Partition.singleton(vertex));
		}

		prioQueue.addAll(graph.getEdges());
		selectedEdge = buildSpanningForrest(graph, partitionMap, prioQueue,
				itemList);

		if (selectedEdge != null) {
			selectedEdge.appendToNewComment(END_MSG);
			itemList.add(selectedEdge);
			graph.updateState(toArray(itemList));
		}
	}

	/**
	 * @param graph
	 * @param partitionMap
	 * @param prioQueue
	 * @param itemList
	 */
	private IRestrictedEdge buildSpanningForrest(IRestrictedGraph graph,
			Map<IRestrictedVertex, Partition<IRestrictedVertex>> partitionMap,
			PriorityQueue<IRestrictedEdge> prioQueue,
			List<IRestrictedGraphItem> itemList) {
		IRestrictedEdge selectedEdge = null;

		while (!prioQueue.isEmpty()) {
			selectedEdge = prioQueue.poll();
			Pair<? extends IRestrictedVertex> pair = graph
					.getEndpoints(selectedEdge);

			setGraphItemValues(selectedEdge, true, true,
					String.format(MIN_EDGE, selectedEdge.getId()),
					State.ACTIVATION);
			itemList.add(selectedEdge);
			setGraphItemValues(pair.getFirst(), true, false, State.ACTIVATION);
			itemList.add(pair.getFirst());
			setGraphItemValues(pair.getSecond(), true, false, State.ACTIVATION);
			itemList.add(pair.getSecond());
			graph.updateState(toArray(itemList));
			itemList.clear();

			setGraphItemValues(pair.getFirst(), false, false);
			itemList.add(pair.getFirst());
			setGraphItemValues(pair.getSecond(), false, false);
			itemList.add(pair.getSecond());
			if (!Partition.areMerged(partitionMap.get(pair.getFirst()).find(),
					partitionMap.get(pair.getSecond()).find())) {
				setGraphItemValues(selectedEdge, ++this.counter, true, true,
						State.SOLUTION);
				itemList.add(selectedEdge);
				if (!pair.getFirst().isDone()) {
					pair.getFirst().setDone(true);
					setGraphItemValues(pair.getFirst(), true, true,
							State.SOLUTION);
				} else {
					setGraphItemValues(pair.getFirst(), true, false,
							State.SOLUTION);
				}
				if (!pair.getSecond().isDone()) {
					pair.getSecond().setDone(true);
					setGraphItemValues(pair.getSecond(), true, true,
							State.SOLUTION);
				} else {
					setGraphItemValues(pair.getSecond(), true, false,
							State.SOLUTION);
				}
				itemList.add(pair.getFirst());
				itemList.add(pair.getSecond());
				graph.updateState(toArray(itemList));
				itemList.clear();

				setGraphItemValues(pair.getFirst(), false, false);
				itemList.add(pair.getFirst());
				setGraphItemValues(pair.getSecond(), false, false);
				itemList.add(pair.getSecond());
				partitionMap.get(pair.getFirst()).merge(
						partitionMap.get(pair.getSecond()));
			} else {
				this.showCircle(graph, partitionMap, itemList, selectedEdge);
			}
		}

		return selectedEdge;
	}

	/**
	 * @param graph
	 * @param itemList
	 * @param partitionMap
	 * @param selectedEdge
	 * 
	 */
	private void showCircle(IRestrictedGraph graph,
			Map<IRestrictedVertex, Partition<IRestrictedVertex>> partitionMap,
			List<IRestrictedGraphItem> itemList, IRestrictedEdge selectedEdge) {
		Pair<? extends IRestrictedVertex> pair = graph
				.getEndpoints(selectedEdge);

		setGraphItemValues(selectedEdge, true, false,
				String.format(CIRCLE_EDGE, selectedEdge.getId()), State.VISIT);
		itemList.add(selectedEdge);
		setGraphItemValues(pair.getFirst(), true, false, State.VISIT);
		itemList.add(pair.getFirst());
		setGraphItemValues(pair.getSecond(), true, false, State.VISIT);
		itemList.add(pair.getSecond());
		graph.updateState(toArray(itemList));
		itemList.clear();

		selectedEdge.setVisible(false);
		setGraphItemValues(selectedEdge, false, false, State.INITIAL);
		itemList.add(selectedEdge);
		setGraphItemValues(pair.getFirst(), false, false, State.SOLUTION);
		itemList.add(pair.getFirst());
		setGraphItemValues(pair.getSecond(), false, false, State.SOLUTION);
		itemList.add(pair.getSecond());

		// for (IRestrictedEdge edge : graph.getEdges()) {
		// Pair<? extends IRestrictedVertex> pair = graph.getEndpoints(edge);
		//
		// if (edge.getCurrentState() == State.SOLUTION
		// && Partition.areMerged(partitionMap.get(currentVertex)
		// .find(), partitionMap.get(pair.getFirst()).find())) {
		//
		// setGraphItemValues(edge, true, false, State.ACTIVATION);
		// itemList.add(edge);
		// setGraphItemValues(pair.getFirst(), true, false,
		// State.ACTIVATION);
		// itemList.add(pair.getFirst());
		// setGraphItemValues(pair.getSecond(), true, false,
		// State.ACTIVATION);
		// itemList.add(pair.getSecond());
		// }
		// }
	}

	/**
	 * @param graph
	 * @throws AlgorithmException
	 */
	private void checkEdgeType(IRestrictedGraph graph)
			throws AlgorithmException {

		if (graph.getEdgeType() == EdgeType.DIRECTED) {
			throw new AlgorithmException(DIRECTED_EDGE);
		}

	}

}
