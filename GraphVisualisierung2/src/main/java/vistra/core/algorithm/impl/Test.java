package vistra.core.algorithm.impl;

import java.util.ArrayList;

import vistra.core.algorithm.AlgorithmException;
import vistra.core.algorithm.IAlgorithm;
import vistra.core.graph.ITraversableGraph;
import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.IVertex;
import vistra.core.traversal.step.BackEdgeStep;
import vistra.core.traversal.step.CrossEdgeStep;
import vistra.core.traversal.step.DiscardedEdgeStep;
import vistra.core.traversal.step.ForwardEdgeStep;
import vistra.core.traversal.step.InitialisedVertexStep;
import vistra.core.traversal.step.SolutionMemberStep;
import vistra.core.traversal.step.UpdatedVertexStep;
import vistra.core.traversal.step.VisitStep;
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
		// tests
		graph.stepBy(new InitialisedVertexStep(vertices));
		graph.stepBy(new VisitStep(edges.get(0), vertices.get(1)));
		graph.stepBy(new BackEdgeStep(edges.get(1)));
		graph.stepBy(new ForwardEdgeStep(edges.get(2)));
		graph.stepBy(new CrossEdgeStep(edges.get(3)));
		graph.stepBy(new DiscardedEdgeStep(edges.get(4)));
		String value = Integer.toString(edges.get(0).getWeight());
		graph.stepBy(new UpdatedVertexStep(vertices.get(2), value));
		graph.stepBy(new SolutionMemberStep(edges.get(5), vertices.get(3)));

	}
}
