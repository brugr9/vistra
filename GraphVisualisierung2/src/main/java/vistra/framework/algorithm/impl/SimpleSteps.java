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
public class SimpleSteps extends AbstractAlgorithm implements IAlgorithm {

	/**
	 * A field for a description.
	 */
	private final static String ALGO_DESCRIPTION = "Test";

	/**
	 * Main constructor.
	 */
	public SimpleSteps() {
		super();
		super.setDescription(ALGO_DESCRIPTION);
		super.setEdgeTypes(new EdgeType[] { EdgeType.UNDIRECTED,
				EdgeType.DIRECTED });
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverse(ITraversableGraph g) throws AlgorithmException {
		try {

			// graph.stepBy(new DiscardedEdgeStep(g.getEdges()));
			// graph.stepBy(new InitialisedVertexStep(g.getVertices()));
			// graph.stepBy(new UpdatedVertexStep(g.getVertices(), "5"));

			ArrayList<IVertex> vertices = new ArrayList<IVertex>(
					g.getVertices());
			ArrayList<IEdge> edges = new ArrayList<IEdge>(g.getEdges());

			/* vertex */
			// init
			g.stepBy(new InitialisedVertexStep(g.getVertices()));
			// value
			g.stepBy(new UpdatedVertexStep(g.getVertices(), "5"));
			/* vertex/edge combined */

			Map<IEdge, IVertex> map = new HashTableMap<IEdge, IVertex>();
			for (int i = 0; i < vertices.size(); i++)
				map.put(edges.get(i), vertices.get(i));
			g.stepBy(new VisitStep(map));
			g.stepBy(new SolutionMemberStep(edges.get(5), vertices.get(6)));
			/* edge */
			g.stepBy(new BackEdgeStep(edges.get(1)));
			g.stepBy(new ForwardEdgeStep(edges.get(2)));
			g.stepBy(new CrossEdgeStep(edges.get(3)));
			g.stepBy(new DiscardedEdgeStep(edges.get(4)));
		} catch (Exception e) {
			throw new AlgorithmException(e);
		}
	}
}
