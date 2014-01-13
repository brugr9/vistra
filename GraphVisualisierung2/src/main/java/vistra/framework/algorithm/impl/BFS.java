package vistra.framework.algorithm.impl;

import java.util.HashSet;
import java.util.Set;

import net.datastructures.NodeQueue;
import net.datastructures.Queue;
import vistra.framework.algorithm.AlgorithmException;
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
	private final static String DESCRIPTION = "Die Breitensuche ist als Schleife "
			+ "implementiert. Es sind sowohl gerichtete als auch ungerichtete Graphen "
			+ "zulässig. Die Breitensuche wird für jede (schwache) Zusammenhangskomponente "
			+ "separat durchgefürt.";

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
	public void traverse(ITraversableGraph g) throws AlgorithmException {
		try {
			/* Input: A graph g and a root v of g */
			IVertex v = g.getStart();
			Queue<IVertex> Q = new NodeQueue<IVertex>();
			Set<IVertex> V = new HashSet<IVertex>();
			Q.enqueue(v);
			V.add(v);

			IVertex tempV, useV;
			IEdge e = null;
			while (!Q.isEmpty()) {
				tempV = Q.dequeue();
				if (g.isSuccessor(tempV, v)) {
					v = tempV;
					g.stepVisit(v, e); // visit vertex via edge
				}
				for (IEdge outE : g.getOutEdges(tempV)) {// adjacent edges of
															// tempV
					useV = g.getOpposite(tempV, outE); // adjacent vertex of
														// tempV
					if (!V.contains(useV)) {
						V.add(useV);
						Q.enqueue(useV);
					} else
						g.stepBackEdge(outE); // back-edge
				}
			}
		} catch (Exception ex) {
			throw new AlgorithmException(ex);
		}
	}

}
