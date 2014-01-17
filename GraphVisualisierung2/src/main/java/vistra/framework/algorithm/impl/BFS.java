package vistra.framework.algorithm.impl;

import vistra.framework.algorithm.IAlgorithm;
import vistra.framework.graph.ITraversableGraph;
import vistra.framework.graph.item.IVertex;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * Breadth-first search (BFS).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class BFS extends AbstractAlgorithm implements IAlgorithm {

	/**
	 * A description.
	 */
	private final static String DESCRIPTION = "Breitensuche (breadth-first search, BFS)";

	/**
	 * Main constructor.
	 */
	public BFS() {
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
				if (!v.isVisited())
					bfs(g, v);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Helper method.
	 * 
	 * @param g
	 *            the graph
	 * @param v
	 *            the vertex
	 * @throws Exception
	 */
	private void bfs(ITraversableGraph g, IVertex s) throws Exception {
		try {
			// TODO
			// int i = 0;
			// ArrayList<IVertex> l(i) = new ArrayList<IVertex>();
			// l(i).add(s);
			// g.stepVisit(s);
			// IVertex w;
			// while (!l(i).isEmpty()) {
			// ArrayList<IVertex> l(i+1) = new ArrayList<IVertex>();
			// for (IVertex v : l(i)) {
			// for (IEdge e : g.getIncidentEdges(v)) {
			// if (!e.isVisited()) {
			// w = g.getOpposite(v, e);
			// if (!w.isVisited()) {
			// g.stepUpdatedVertex(w, i); // level
			// g.stepVisit(w, e);
			// l(i+1).add(w);
			// } else
			// g.stepCrossEdge(e);
			// }
			// }
			// }
			// i++;
			// }
		} catch (Exception ex) {
			throw ex;
		}
	}
}
