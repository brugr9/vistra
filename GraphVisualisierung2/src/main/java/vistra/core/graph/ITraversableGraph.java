package vistra.core.graph;

import java.util.Collection;
import java.util.List;

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
public interface ITraversableGraph extends Graph<IVertex, IEdge> {

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
	 * Returns the visited state of a vertex.
	 * 
	 * @param vertex
	 *            the vertex to check
	 * @return {@code true} if already visited
	 */
	abstract boolean isVisited(IVertex vertex);

	/**
	 * Adds {@code listener} as a listener to this graph.
	 */
	abstract void addTraversalEventListener(
			ITraversableGraphEventListener listener);

	/**
	 * Removes {@code listener} as a listener from this graph.
	 */
	abstract void removeTraversalEventListener(
			ITraversableGraphEventListener listener);

	/**
	 * A step method: initialises the vertices.
	 * 
	 * @param vertices
	 *            the vertices to initialise
	 */
	abstract void stepInitVertices(List<IVertex> vertices);

	/**
	 * A step method: updates the vertices with values as given.
	 * 
	 * @param vertices
	 *            the vertices
	 * @param values
	 *            the values
	 */
	abstract void stepUpdateVertices(List<IVertex> vertices,
			List<Integer> values);

	/**
	 * A step method: visits a vertex over an edge as given.
	 * 
	 * @param edge
	 *            the edge to discover
	 * @param vertex
	 *            the vertex to visit
	 */
	abstract void stepVisitVertex(IEdge edge, IVertex vertex);

	/**
	 * A step method: visits a vertex over an edge as given and sets both as
	 * solution.
	 * 
	 * @param edge
	 *            the edge
	 * @param vertex
	 *            the vertex
	 */
	abstract void stepSolutionVertex(IEdge edge, IVertex vertex);

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

	/**
	 * A step method: sets an edge as solution edge.
	 * 
	 * @param edge
	 *            the edge to set as solution edge
	 */
	abstract void stepSolutionEdge(IEdge edge);

}
