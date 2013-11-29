package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import java.util.Collection;
import java.util.Map;
import java.util.PriorityQueue;

import org.apache.commons.collections15.map.HashedMap;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.Partition;
import ch.bfh.bti7301.hs2013.gravis.core.util.comparator.EdgeWeightComparator;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.graph.util.Pair;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class AlgorithmKruskalMinSpanningForest extends AbstractAlgorithm {

	private int counter = 0;

	public AlgorithmKruskalMinSpanningForest() {
		super();
		super.setName("Kruskal algorithm");
		super.setDescription("Kruskal algorithm: Calculates a minimal spanning forest from a "
				+ "given graph. The graph must be UNDIRECTED.");
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
	public void execute(IRestrictedGraph graph) throws Exception {
		// TODO bitte an dieser Methode nichts ändern (pk)

		this.counter = 0;

		this.checkEdgeType(graph);

		Map<IRestrictedVertex, Partition<IRestrictedVertex>> partitionMap = new HashedMap<>();
		Collection<? extends IRestrictedVertex> vertices = graph.getVertices();
		PriorityQueue<IRestrictedEdge> prioQueue = new PriorityQueue<>(
				vertices.size(), new EdgeWeightComparator());

		for (IRestrictedVertex vertex : vertices) {
			partitionMap.put(vertex, Partition.singleton(vertex));

			// this.updateState(graph, vertex, State.ACTIVATION);
		}

		// if (vertices.iterator().hasNext()) {
		// this.updateState(graph, vertices.iterator().next(),
		// State.ACTIVATION);
		// }

		prioQueue.addAll(graph.getEdges());

		while (!prioQueue.isEmpty()) {
			IRestrictedEdge selectedEdge = prioQueue.poll();
			Pair<? extends IRestrictedVertex> pair = graph
					.getEndpoints(selectedEdge);

			graph.updateState(State.ACTIVATION, selectedEdge);

			if (!partitionMap.get(pair.getFirst()).find()
					.equals(partitionMap.get(pair.getSecond()).find())) {

				selectedEdge.setResult(++this.counter);
				selectedEdge.setComment("Die Kante " + selectedEdge.getId()
						+ " wird zur Lösung hinzugefügt.");
				graph.updateState(State.SOLUTION, selectedEdge);

				if (!pair.getFirst().isDone()) {
					pair.getFirst().setDone(true);
					graph.updateState(State.SOLUTION, pair.getFirst());
				}

				if (!pair.getSecond().isDone()) {
					pair.getSecond().setDone(true);
					graph.updateState(State.SOLUTION, pair.getSecond());
				}

				partitionMap.get(pair.getFirst()).merge(
						partitionMap.get(pair.getSecond()));
			} else {
				graph.updateState(State.VISIT, selectedEdge);
			}

		}
	}

	/**
	 * @param graph
	 * @throws AlgorithmException
	 */
	private void checkEdgeType(IRestrictedGraph graph)
			throws AlgorithmException {
		
			if (graph.getEdgeType() == EdgeType.DIRECTED) {
			throw new AlgorithmException(
					"Kruskal algorithm: DIRECTED edges are not allowed!");
		}

	}

}
