package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import org.apache.commons.collections15.map.HashedMap;

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
public class AlgorithmKruskalMinSpanningForest extends AbstractAlgorithm {

	private final static String DIRECTED_EDGE = "Kruskal algorithm: DIRECTED "
			+ "edges are not allowed!";

	private final static String ALGO_NAME = "Algorithmus von Kruskal";
	private final static String ALGO_DESCRIPTION = "Diese Implementation "
			+ "berechnet einen minimalen Spann-Wald für einen gegebenen Graphen. "
			+ "Der Graph muss ungerichtet sein. Ein Start- und Endknoten muss nicht "
			+ "angegeben werden. Die Kanten der Lösung zeigen neben dem Gewicht auch "
			+ "an, in welcher Reihenfolge sie zur Lösung hinzugefügt wurden.";
	private final static String MIN_EDGE = "Die aktuelle Kante mit dem kleinsten "
			+ "Gewicht: %s";
	private final static String CIRCLE_EDGE = "Die Kante %s kann nicht zur Lösung "
			+ "hinzugefügt werden, da sonst ein Kreis ensteht.";
	private final static String END_MSG = "Der minimale Spann-Wald wurde erfolgreich "
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
		super.setGraphTypes(new GraphType[] {});
		// TODO init id
		super.setId(3);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.algorithm.AbstractAlgorithm#execute
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph)
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
			graph.updateState(toArray(itemList));
			itemList.clear();

			if (!partitionMap.get(pair.getFirst()).find()
					.equals(partitionMap.get(pair.getSecond()).find())) {

				setGraphItemValues(selectedEdge, ++this.counter, true, true);
				itemList.add(selectedEdge);
				if (!pair.getFirst().isDone()) {
					pair.getFirst().setDone(true);
					setGraphItemValues(pair.getFirst(), false, true);
					itemList.add(pair.getFirst());
				}
				if (!pair.getSecond().isDone()) {
					pair.getSecond().setDone(true);
					setGraphItemValues(pair.getSecond(), false, true);
					itemList.add(pair.getSecond());
				}
				graph.updateState(State.SOLUTION, toArray(itemList));
				itemList.clear();

				partitionMap.get(pair.getFirst()).merge(
						partitionMap.get(pair.getSecond()));
			} else {
				setGraphItemValues(selectedEdge, true, false,
						String.format(CIRCLE_EDGE, selectedEdge.getId()),
						State.VISIT);
				itemList.add(selectedEdge);
				graph.updateState(toArray(itemList));
				itemList.clear();

				selectedEdge.setVisible(false);
				setGraphItemValues(selectedEdge, false, false, State.INITIAL);
				itemList.add(selectedEdge);
			}
		}

		return selectedEdge;
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
