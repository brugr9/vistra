package vistra.core.graph;

import java.util.Collection;

import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.IVertex;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * A traversable graph.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IRenderGraph extends Graph<IVertex, IEdge> {

	/**
	 * 
	 * Unsupported operation.
	 * 
	 */
	@Override
	abstract boolean addEdge(IEdge e, IVertex v1, IVertex v2);

	/**
	 * 
	 * Unsupported operation.
	 * 
	 */
	@Override
	abstract boolean addEdge(IEdge e, IVertex v1, IVertex v2, EdgeType edgeType);

	/**
	 * 
	 * Unsupported operation.
	 * 
	 */
	@Override
	abstract boolean addVertex(IVertex vertex);

	/**
	 * 
	 * Unsupported operation.
	 * 
	 */
	@Override
	abstract boolean addEdge(IEdge edge, Collection<? extends IVertex> vertices);

	/**
	 * 
	 * Unsupported operation.
	 * 
	 */
	@Override
	abstract boolean addEdge(IEdge edge,
			Collection<? extends IVertex> vertices, EdgeType edge_type);

	/**
	 * 
	 * Unsupported operation.
	 * 
	 */
	@Override
	abstract boolean removeVertex(IVertex vertex);

	/**
	 * 
	 * Unsupported operation.
	 * 
	 */
	@Override
	abstract boolean removeEdge(IEdge edge);

	/**
	 * Returns the edge type.
	 * 
	 * @return the edge type
	 */
	abstract EdgeType getEdgeType();

	/**
	 * Returns a previously as start vertex signed item.
	 * 
	 * @param vertex
	 *            the start vertex if any, <code>null</code> otherwise
	 */
	abstract IVertex getStart();

	/**
	 * Returns a previously as end vertex signed item.
	 * 
	 * @param vertex
	 *            the end vertex if any, <code>null</code> otherwise
	 */
	abstract IVertex getEnd();

	/**
	 * A step method: visits a vertex over an edge as given.
	 * 
	 * @param edge
	 *            the edge to discover
	 * @param vertex
	 *            the vertex to visit
	 */
	abstract void stepVisit(IEdge edge, IVertex vertex);

	/**
	 * A step method: sets an edge as back edge.
	 * 
	 * @param edge
	 *            the edge to set as back edge
	 */
	abstract void stepBackEdge(IEdge edge);

	/**
	 * A step method: sets an edge as forward edge.
	 * 
	 * @param edge
	 *            the edge to set as forward edge
	 */
	abstract void stepForwardEdge(IEdge edge);

	/**
	 * A step method: sets an edge as cross edge.
	 * 
	 * @param edge
	 *            the edge to set as cross edge
	 */
	abstract void stepCrossEdge(IEdge edge);

	/**
	 * A step method: sets an edge as dicarded edge.
	 * 
	 * @param edge
	 *            the edge to set as discarded edge
	 */
	abstract void stepDiscardedEdge(IEdge edge);

}
