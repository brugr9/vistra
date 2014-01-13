package vistra.framework.algorithm.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import net.datastructures.Entry;
import net.datastructures.HashTableMap;
import net.datastructures.Map;
import vistra.framework.algorithm.AlgorithmException;
import vistra.framework.algorithm.IAlgorithm;
import vistra.framework.graph.ITraversableGraph;
import vistra.framework.graph.item.IEdge;
import vistra.framework.graph.item.IVertex;
import vistra.framework.step.BackEdgeStep;
import vistra.framework.step.CrossEdgeStep;
import vistra.framework.step.DiscardedEdgeStep;
import vistra.framework.step.ForwardEdgeStep;
import vistra.framework.step.InitialisedVertexStep;
import vistra.framework.step.SolutionMemberStep;
import vistra.framework.step.UpdatedVertexStep;
import vistra.framework.step.VisitStep;
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

			Map<IVertex, IEdge> items = new HashTableMap<IVertex, IEdge>();
			List<IVertex> v = new ArrayList<IVertex>(g.getVertices());
			List<IEdge> e = new ArrayList<IEdge>(g.getEdges());
			for (int i = 0; i < v.size(); i++)
				items.put(v.get(i), e.get(i));

			/* init */
			g.stepInitializedVertex(v.get(0), g.getVertices());
			/* value */
			g.stepUpdatedVertex(v.get(1), 5);
			/* visit */
			g.stepVisit(items.entrySet());
			/* edge */
			g.stepBackEdge(e.get(1));
			g.stepForwardEdge(e.get(2));
			g.stepCrossEdge(e.get(3));
			g.stepDiscardedEdge(e.get(4));
			/* solution */
			g.stepSolutionMember(v.get(4), e.get(0));
		} catch (Exception e) {
			throw new AlgorithmException(e);
		}
	}
}
