package vistra.framework.algorithm.impl;

import vistra.framework.algorithm.IAlgorithm;
import vistra.framework.graph.ITraversableGraph;
import vistra.framework.graph.item.IEdge;
import vistra.framework.graph.item.IVertex;
import edu.uci.ics.jung.graph.util.EdgeType;
import java.util.ArrayList;

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
	private final static String DESCRIPTION = "Breitensuche (breadth-first search BFS)";

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
	 * Breadth-first search, helper method.
	 * 
	 * @param g the graph
	 * @param s the vertex
	 * @throws Exception
	 */
	private void bfs(ITraversableGraph g, IVertex s) throws Exception {
		try {
			IVertex w;
			ArrayList<ArrayList<IVertex>> L = new ArrayList<ArrayList<IVertex>>();
			int i = 0;

			// new empty sequence
			ArrayList<IVertex> sQ = new ArrayList<IVertex>();
			L.add(sQ);
			L.get(i).add(s);
			g.stepVisit(s);

			while (!L.get(i).isEmpty()) {
				// new empty sequence
				ArrayList<IVertex> Q = new ArrayList<IVertex>();
				L.add(Q);
				for (IVertex v : L.get(i)) {
					for (IEdge e : g.getIncidentEdges(v)) {
						if (e.isUnexplored()) {
							w = g.getOpposite(v, e);
							if (w.isUnexplored()) {
								g.stepVisit(e);
								g.stepVisit(w);
								L.get(i+1).add(w);
							} else
								g.stepBackEdge(e);
						}
					}
				};
				i++;
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
}
