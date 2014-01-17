package vistra.framework.algorithm.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.datastructures.AdaptablePriorityQueue;
import net.datastructures.DefaultComparator;
import net.datastructures.Entry;
import net.datastructures.HeapAdaptablePriorityQueue;
import vistra.framework.algorithm.AlgorithmException;
import vistra.framework.algorithm.IAlgorithm;
import vistra.framework.graph.ITraversableGraph;
import vistra.framework.graph.item.IEdge;
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
	 * Main constructor.
	 */
	public Dijkstra() {
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
			DefaultComparator<?> comparator = new DefaultComparator<Object>();
			AdaptablePriorityQueue<Integer, IVertex> Q = new HeapAdaptablePriorityQueue<Integer, IVertex>(
					comparator);
			//
			IVertex s = g.getStart();
			ArrayList<IVertex> i = new ArrayList<IVertex>();
			i.addAll(g.getVertices());
			g.stepInitializedVertex(s, i);

			// store all the vertices in priority queue Q
			Map<IVertex, Entry<Integer, IVertex>> locator = new HashMap<IVertex, Entry<Integer, IVertex>>();
			for (IVertex u : g.getVertices()) {
				Integer u_dist;
				if (u == s)
					u_dist = 0;
				else
					u_dist = Integer.MAX_VALUE;
				Entry<Integer, IVertex> l = Q.insert(u_dist, u);
				locator.put(u, l);
			}

			// grow the cloud, one vertex at a time
			while (!Q.isEmpty()) {
				// remove from Q and insert into cloud a vertex with minimum
				// distance
				Entry<Integer, IVertex> u_entry = Q.min();
				IVertex u = u_entry.getValue();
				int u_dist = u_entry.getKey();
				Q.remove(u_entry); // remove u from the priority queue
				g.stepUpdatedVertex(u_entry); // the distance of u is final
				g.stepVisit(u); // TODO solution member
				if (u_dist == Integer.MAX_VALUE)
					continue; // unreachable vertices are not processed
				// examine all the neighbors of u and update their distances
				for (IEdge e : g.getIncidentEdges(u)) {
					IVertex z = g.getOpposite(u, e);
					if (!z.isVisited()) { // check that z is in Q, i.e., not in
											// the cloud
						int e_weight = (Integer) e.getWeight();
						int z_dist = z.getDistance();
						if (u_dist + e_weight < z_dist) {// relaxation of edge e
															// = (u,z)
							Entry<Integer, IVertex> z_entry = locator.get(z);
							Q.replaceKey(z_entry, u_dist + e_weight);
							g.stepUpdatedVertex(z, u_dist + e_weight);
						}
					}
				}
			}

		} catch (Exception ex) {
			throw ex;
		}

	}
}
