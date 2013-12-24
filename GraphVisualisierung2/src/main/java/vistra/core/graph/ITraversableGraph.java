package vistra.core.graph;

import edu.uci.ics.jung.graph.Graph;
import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;

/**
 * A traversable graph.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface ITraversableGraph extends Graph<IVertex, IEdge> {

	/**
	 * A step: visits a vertex over an edge as given.
	 * 
	 * @param edge
	 *            the edge to discover
	 * @param vertex
	 *            the vertex to visit
	 */
	abstract void visit(IEdge edge, IVertex vertex);

}
