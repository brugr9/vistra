package vistra.framework.algorithm.impl;

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
	private final static String DESCRIPTION = "Tiefensuche (depth-first search, DFS)";

	/**
	 * Main constructor.
	 */
	public DFS() {
		super();
		super.setDescription(DESCRIPTION);
		super.setEdgeTypes(new EdgeType[] { EdgeType.UNDIRECTED });
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverse(ITraversableGraph g) throws Exception {
		try {
			for (IVertex v : g.getVertices())
				if (v.isUnexplored())
					dfs(g, v);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Depth-first search, helper method.
	 * 
	 * @param g
	 *            the graph
	 * @param v
	 *            the vertex
	 * @throws Exception
	 */
	private void dfs(ITraversableGraph g, IVertex v) throws Exception {
		try {
			IVertex w;
			g.stepVisit(v);
			for (IEdge e : g.getIncidentEdges(v)) {
				if (e.isUnexplored()) {
					w = g.getOpposite(v, e);
					if (w.isUnexplored()) {
						g.stepVisit(e);
						dfs(g, w);
					} else
						g.stepBackEdge(e);
				}
			}
		} catch (Exception ex) {
			throw ex;
		}
	}

}
