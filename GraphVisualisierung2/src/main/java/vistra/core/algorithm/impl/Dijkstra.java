package vistra.core.algorithm.impl;

import net.datastructures.AdaptablePriorityQueue;
import net.datastructures.DefaultComparator;
import net.datastructures.HeapAdaptablePriorityQueue;
import vistra.core.algorithm.AbstractAlgorithm;
import vistra.core.algorithm.AlgorithmException;
import vistra.core.algorithm.IAlgorithm;
import vistra.core.graph.ITraversableGraph;
import vistra.core.graph.item.vertex.IVertex;
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
	private final static String DESCRIPTION = "Dijkstra's algorithm for the single-source shortest path problem in an undirected graph whose edges have integer weights.";
	// + "Der Dijkstra-Algorithmus findet den "
	// +
	// "kürzesten Weg zwischen zwei Knoten. Ein Startknoten muss im Graphen vorhanden "
	// +
	// "sein. Ist kein Endknoten vorhanden, so wird der kürteste Weg vom Startknoten "
	// +
	// "zu allen anderen Knoten berechnet. Diese Implementation des Algorithmus "
	// +
	// "funktioniert sowohl mit ungerichteten als auch mit gerichteten Kanten. Negative "
	// + "Kantengewichte und Mehrfachkanten sind nicht erlaubt.";

	/**
	 * A field for the graph to traverse.
	 */
	private ITraversableGraph graph;
	/**
	 * A field for an infinity value.
	 */
	protected static final Integer INFINITE = Integer.MAX_VALUE;
	/**
	 * A field for an edge weights decoration key.
	 */
	protected Object WEIGHT;
	/**
	 * A field for a vertex distances decoration key.
	 */
	protected Object DIST = new Object();
	/**
	 * A field for a decoration key for entries in the priority queue.
	 */
	protected Object ENTRY = new Object();
	/**
	 * An auxiliary priority queue.
	 */
	protected AdaptablePriorityQueue<Integer, IVertex> Q;

	/**
	 * Main constructor.
	 */
	public Dijkstra() {
		super();
		super.setDescription(DESCRIPTION);
		super.setEdgeTypes(new EdgeType[] { EdgeType.UNDIRECTED,
				EdgeType.DIRECTED });
		this.graph = null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverse(ITraversableGraph graph) throws AlgorithmException {
		// TODO
		this.graph = graph;
		WEIGHT = new Object();
		// IVertex s = graph.getStart();
		DefaultComparator comparator = new DefaultComparator();
		Q = new HeapAdaptablePriorityQueue<Integer, IVertex>(comparator);
		// dijkstraVisit(s);
	}

	/**
	 * The actual execution of Dijkstra's algorithm.
	 * 
	 * @param v
	 *            source vertex.
	 */
	protected void dijkstraVisit(IVertex v) {
		/*
		 * TODO // store all the vertices in priority queue Q for (IVertex u :
		 * graph.getVertices()) { int u_dist; if (u == v) u_dist = 0; else
		 * u_dist = INFINITE; Entry<Integer, IVertex> u_entry = Q.insert(u_dist,
		 * u); // autoboxing u.put(ENTRY, u_entry); } // grow the cloud, one
		 * vertex at a time while (!Q.isEmpty()) { // remove from Q and insert
		 * into cloud a vertex with minimum // distance Entry<Integer, IVertex>
		 * u_entry = Q.min(); IVertex u = u_entry.getValue(); int u_dist =
		 * u_entry.getKey(); Q.remove(u_entry); // remove u from the priority
		 * queue u.put(DIST, u_dist); // the distance of u is final
		 * u.remove(ENTRY); // remove the entry decoration of u if (u_dist ==
		 * INFINITE) continue; // unreachable vertices are not processed //
		 * examine all the neighbors of u and update their distances for (IEdge
		 * e : graph.getIncidentEdges(u)) { IVertex z = graph.getOpposite(u, e);
		 * Entry<Integer, IVertex> z_entry = (Entry<Integer, IVertex>) z
		 * .get(ENTRY); if (z_entry != null) { // check that z is in Q, i.e.,
		 * not in the // cloud int e_weight = (Integer) e.get(WEIGHT); int
		 * z_dist = z_entry.getKey(); if (u_dist + e_weight < z_dist) //
		 * relaxation of edge e = // (u,z) Q.replaceKey(z_entry, u_dist +
		 * e_weight); } } }
		 */
	}

}
