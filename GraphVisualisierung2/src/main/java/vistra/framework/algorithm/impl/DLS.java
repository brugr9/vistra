package vistra.framework.algorithm.impl;

import vistra.framework.algorithm.AlgorithmException;
import vistra.framework.algorithm.IAlgorithm;
import vistra.framework.graph.ITraversableGraph;
import vistra.framework.graph.item.IVertex;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * Depth-last search (DFS).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class DLS extends AbstractAlgorithm implements IAlgorithm {

	/**
	 * A description.
	 */
	private final static String DESCRIPTION = "Beschränkte Tiefensuche (depth-limited search, DLS): Der Graph wird in Postorder traversiert. "
			+ "Es sind sowohl gerichtete als auch ungerichtete Graphen zulässig.";

	ITraversableGraph g;

	/**
	 * Main constructor.
	 */
	public DLS() {
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
			this.g = g;
			IVertex node = g.getStart();
			IVertex goal = g.getEnd();
			dls(node, goal, 0);

		} catch (Exception e) {
			throw new AlgorithmException(e);
		}
	}

	private void dls(IVertex node, IVertex goal, int depth) throws Exception {
		try {
			if (depth >= 0) {
				if (node == goal) {
					g.stepVisit(node, g.getInEdges(node).iterator().next());
				}
				for (IVertex child : g.getSuccessors(node))
					// for each child in expand(node)
					dls(child, goal, depth - 1);
			}
		} catch (Exception e) {
			throw e;
		}
	}
}
