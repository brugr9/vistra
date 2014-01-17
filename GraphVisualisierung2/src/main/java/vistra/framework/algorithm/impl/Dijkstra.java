package vistra.framework.algorithm.impl;

import net.datastructures.AdaptablePriorityQueue;
import net.datastructures.DefaultComparator;
import net.datastructures.HeapAdaptablePriorityQueue;
import vistra.framework.algorithm.AlgorithmException;
import vistra.framework.algorithm.IAlgorithm;
import vistra.framework.graph.ITraversableGraph;
import vistra.framework.graph.item.IVertex;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * Dijkstra algorithm.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class Dijkstra extends AbstractAlgorithm implements IAlgorithm {

	/**
	 * A field for a description.
	 */
	private final static String DESCRIPTION = "Dijkstra's algorithm "
			+ "for the single-source shortest path problem "
			+ "in an undirected graph whose edges have integer weights.";

	/**
	 * A field for a vertex distances decoration key.
	 */
	private static Object DIST;
	/**
	 * A field for a decoration key for entries in the priority queue.
	 */
	private static Object ENTRY;
	/**
	 * An auxiliary priority queue.
	 */
	private AdaptablePriorityQueue<Integer, IVertex> Q;

	/**
	 * Main constructor.
	 */
	public Dijkstra() {
		super();
		super.setDescription(DESCRIPTION);
		super.setEdgeTypes(new EdgeType[] { EdgeType.UNDIRECTED,
				EdgeType.DIRECTED });

		DIST = new Object();
		ENTRY = new Object();
		DefaultComparator<?> comparator = new DefaultComparator<Object>();
		Q = new HeapAdaptablePriorityQueue<Integer, IVertex>(comparator);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverse(ITraversableGraph g) throws AlgorithmException {
		try {
			IVertex s = g.getStart();

			// store all the vertices in priority queue Q
			for (IVertex u : g.getVertices()) {
				int u_dist;
				if (u == s)
					u_dist = 0;
				else
					u_dist = 0;// TODO INFINITE;
				Entry<Integer, IVertex> u_entry = Q.insert(u_dist, u);
				// autoboxing
				// TODO u.put(ENTRY, u_entry);
			}

			// grow the cloud, one vertex at a time
			while (!Q.isEmpty()) {
				// remove from Q and insert into cloud a vertex with minimum
				// distance
				Entry<Integer, IVertex> u_entry = Q.min();
				IVertex u = u_entry.getValue();
				int u_dist = u_entry.getKey();
				Q.remove(u_entry); // remove u from the priority queue
				// TODO u.put(DIST, u_dist); // the distance of u is final
				// TODO u.remove(ENTRY); // remove the entry decoration of u
				if (u_dist == 0)// TODO == INFINITE)
					continue; // unreachable vertices are not processed
				// examine all the neighbors of u and update their distances
				for (IEdge e : g.getIncidentEdges(u)) {
					IVertex z = g.getOpposite(u, e);
					Entry<Integer, IVertex> z_entry = null; // TODO =
					// (Entry<Integer,
					// IVertex>)
					// z.get(ENTRY);
					if (z_entry != null) { // check that z is in Q, i.e., not in
						// the
						// cloud
						int e_weight = (Integer) e.getWeight();
						int z_dist = z_entry.getKey();
						if (u_dist + e_weight < z_dist) // relaxation of edge e
							// =
							// (u,z)
							Q.replaceKey(z_entry, u_dist + e_weight);
					}
				}
			}

		} catch (Exception e) {
			throw new AlgorithmException(e);
		}

	}

}
