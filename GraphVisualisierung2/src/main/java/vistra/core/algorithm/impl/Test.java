package vistra.core.algorithm.impl;

import java.util.ArrayList;

import vistra.core.algorithm.AlgorithmException;
import vistra.core.algorithm.IAlgorithm;
import vistra.core.graph.ITraversableGraph;
import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.IVertex;
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
		graph.stepInitVertices(vertices);

		ArrayList<IEdge> edges = new ArrayList<IEdge>(graph.getEdges());
		graph.stepCrossEdge(edges.get(2));
		graph.stepBackEdge(edges.get(1));
	}
}
