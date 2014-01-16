package vistra.framework.algorithm.impl;

import java.util.HashSet;
import java.util.Set;

import net.datastructures.NodeStack;
import net.datastructures.Stack;
import vistra.framework.algorithm.AlgorithmException;
import vistra.framework.algorithm.IAlgorithm;
import vistra.framework.graph.ITraversableGraph;
import vistra.framework.graph.item.IEdge;
import vistra.framework.graph.item.IVertex;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * Depth-first search (DFS), preorder.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class DFS extends AbstractAlgorithm implements IAlgorithm {

	/**
	 * A description.
	 */
	private final static String DESCRIPTION = "Tiefensuche (depth-first search, DFS): "
			+ "Der Graph wird in Preorder traversiert. "
			+ "Der Algorithmus verwendet einen Stack.";

	/**
	 * Main constructor.
	 */
	public DFS() {
		super();
		super.setDescription(DESCRIPTION);
		super.setEdgeTypes(new EdgeType[] { EdgeType.UNDIRECTED,
				EdgeType.DIRECTED });
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverse(ITraversableGraph g) throws AlgorithmException {
		try {
			/* Input: A graph g and a root v of g */
			IVertex v = g.getStart();
			g.stepVisit(v);

			Stack<IVertex> S = new NodeStack<IVertex>();
			Set<IVertex> V = new HashSet<IVertex>();
			S.push(v);
			V.add(v);

			IVertex t, u = null;
			while (!S.isEmpty()) {
				t = S.pop();
				if (g.isSuccessor(t, u)) {
					if (t.isVisited())
						t = S.pop();
				}
				for (IEdge outE : g.getOutEdges(t)) {// adjacent edges of t
					u = g.getOpposite(t, outE); // adjacent vertex of t
					if (!V.contains(u)) {
						V.add(u);
						S.push(u);
					} else {
						// if (!u.isVisited())
						g.stepVisit(t, g.findEdge(t, u));
					}
				}
			}
		} catch (Exception e) {
			throw new AlgorithmException(e);
		}

	}

}
