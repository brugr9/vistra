package vistra.framework.algorithm.impl;

import java.util.ArrayList;

import net.datastructures.HashTableMap;
import net.datastructures.Map;

import vistra.framework.algorithm.AlgorithmException;
import vistra.framework.algorithm.IAlgorithm;
import vistra.framework.graph.ITraversableGraph;
import vistra.framework.graph.item.IEdge;
import vistra.framework.graph.item.IVertex;
import vistra.framework.traversal.step.BackEdgeStep;
import vistra.framework.traversal.step.CrossEdgeStep;
import vistra.framework.traversal.step.DiscardedEdgeStep;
import vistra.framework.traversal.step.ForwardEdgeStep;
import vistra.framework.traversal.step.InitialisedVertexStep;
import vistra.framework.traversal.step.SolutionMemberStep;
import vistra.framework.traversal.step.UpdatedVertexStep;
import vistra.framework.traversal.step.VisitStep;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * Breadth-first search (BFS).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class Test extends AbstractAlgorithm implements IAlgorithm {

	/**
	 * A field for a description.
	 */
	private final static String ALGO_DESCRIPTION = "Test";

	/**
	 * Main constructor.
	 */
	public Test() {
		super();
		super.setDescription(ALGO_DESCRIPTION);
		super.setEdgeTypes(new EdgeType[] { EdgeType.UNDIRECTED,
				EdgeType.DIRECTED });
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverse(ITraversableGraph graph) throws AlgorithmException {
		ArrayList<IVertex> vertices = new ArrayList<IVertex>(
				graph.getVertices());
		ArrayList<IEdge> edges = new ArrayList<IEdge>(graph.getEdges());

		/* vertex */
		// init
		graph.stepBy(new InitialisedVertexStep(graph.getVertices()));
		// value
		graph.stepBy(new UpdatedVertexStep(graph.getVertices(), "5"));
		/* vertex/edge combined */

		Map<IEdge, IVertex> map = new HashTableMap<IEdge, IVertex>();
		for (int i = 0; i < edges.size(); i++)
			map.put(edges.get(i), vertices.get(i));
		graph.stepBy(new VisitStep(map));
		graph.stepBy(new SolutionMemberStep(edges.get(5), vertices.get(6)));
		/* edge */
		graph.stepBy(new BackEdgeStep(edges.get(1)));
		graph.stepBy(new ForwardEdgeStep(edges.get(2)));
		graph.stepBy(new CrossEdgeStep(edges.get(3)));
		graph.stepBy(new DiscardedEdgeStep(edges.get(4)));
	}
}
