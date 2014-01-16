package vistra.framework.algorithm.impl;

import java.util.HashSet;
import java.util.Set;

import net.datastructures.NodeQueue;
import net.datastructures.Queue;
import vistra.framework.algorithm.IAlgorithm;
import vistra.framework.graph.ITraversableGraph;
import vistra.framework.graph.item.IEdge;
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
	private final static String DESCRIPTION = "Breitensuche (breadth-first search, BFS): "
			+ "Als Schleife implementiert; "
			+ "es sind sowohl gerichtete als auch ungerichtete Graphen zulässig. "
			+ "Der Algorithmus verwendet eine Queue.";

	/**
	 * Main constructor.
	 */
	public BFS() {
		super();
		super.setDescription(DESCRIPTION);
		super.setEdgeTypes(new EdgeType[] { EdgeType.UNDIRECTED,
				EdgeType.DIRECTED });
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverse(ITraversableGraph g) throws Exception {
		try {
			/* Input: A graph g and a root v of g */
			IVertex v = g.getStart();
			g.stepVisit(v);

			Queue<IVertex> Q = new NodeQueue<IVertex>();
			Set<IVertex> V = new HashSet<IVertex>();
			Q.enqueue(v);
			V.add(v);

			IVertex t, u = null;
			while (!Q.isEmpty()) {
				t = Q.dequeue();
				if (g.isSuccessor(t, u)) {
					if (t.isVisited())
						t = Q.dequeue();
				}
				for (IEdge outE : g.getOutEdges(t)) {// adjacent edges of t
					u = g.getOpposite(t, outE); // adjacent vertex of t
					if (!V.contains(u)) {
						V.add(u);
						Q.enqueue(u);
					} else {
						// if (!u.isVisited())
						g.stepVisit(t, g.findEdge(t, u));
					}
				}
			}
		} catch (Exception ex) {
			throw ex;
		}
	}
}
