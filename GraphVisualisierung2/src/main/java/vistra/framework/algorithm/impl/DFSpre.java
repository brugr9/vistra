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
public class DFSpre extends AbstractAlgorithm implements IAlgorithm {

	/**
	 * A description.
	 */
	private final static String DESCRIPTION = "Der Graph wird in Preorder traversiert.";

	/**
	 * Main constructor.
	 */
	public DFSpre() {
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
			Stack<IVertex> S = new NodeStack<IVertex>();
			Set<IVertex> V = new HashSet<IVertex>();
			S.push(v);
			V.add(v);

			IVertex tempV, useV;
			IEdge e = null;
			while (!S.isEmpty()) {
				tempV = S.pop();
				if (g.isSuccessor(tempV, v)) {
					v = tempV;
					g.stepVisit(v, e);
				}
				for (IEdge outE : g.getOutEdges(tempV)) {// adjacent edges of
															// tempV
					useV = g.getOpposite(tempV, outE); // adjacent vertex of
														// tempV
					if (!V.contains(useV)) {
						V.add(useV);
						S.push(useV);
					} else
						g.stepBackEdge(outE);
				}
			}
		} catch (Exception e) {
			throw new AlgorithmException(e);
		}

	}

}
