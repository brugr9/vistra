package vistra.core.graph;

import java.util.Collection;
import java.util.List;

import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.IVertex;
import vistra.core.traversal.Traversal;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * A traversable graph interface. The graph delegates most of its method calls
 * to a constructor-specified {@code Graph}. Modifiers are not supported
 * anymore: vertices and edges can neither been added nor removed.
 * <p>
 * In addition, this graph serves with some 'step'-methods which an
 * {@code IAlgorithm}-developer can use for generating steps of a traversal.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see Traversal
 */
public interface ITraversableGraph extends Graph<IVertex, IEdge> {

	/**
	 * 
	 * Unsupported operation.
	 * 
	 */
	@Override
	boolean addEdge(IEdge e, IVertex v1, IVertex v2);

	/**
	 * 
	 * Unsupported operation.
	 * 
	 */
	@Override
	boolean addEdge(IEdge e, IVertex v1, IVertex v2, EdgeType edgeType);

	/**
	 * 
	 * Unsupported operation.
	 * 
	 */
	@Override
	boolean addVertex(IVertex vertex);

	/**
	 * 
	 * Unsupported operation.
	 * 
	 */
	@Override
	boolean addEdge(IEdge edge, Collection<? extends IVertex> vertices);

	/**
	 * 
	 * Unsupported operation.
	 * 
	 */
	@Override
	boolean addEdge(IEdge edge, Collection<? extends IVertex> vertices,
			EdgeType edge_type);

	/**
	 * 
	 * Unsupported operation.
	 * 
	 */
	@Override
	boolean removeVertex(IVertex vertex);

	/**
	 * 
	 * Unsupported operation.
	 * 
	 */
	@Override
	boolean removeEdge(IEdge edge);

	/**
	 * Returns the edge type.
	 * 
	 * @return the edge type
	 */
	EdgeType getEdgeType();

	/**
	 * Returns a previously as start vertex signed item.
	 * 
	 * @param vertex
	 *            the start vertex if any, {@code null} otherwise
	 */
	IVertex getStart();

	/**
	 * Returns a previously as end vertex signed item.
	 * 
	 * @param vertex
	 *            the end vertex if any, {@code null} otherwise
	 */
	IVertex getEnd();

	/**
	 * Returns the visited state of a vertex.
	 * 
	 * @param vertex
	 *            the vertex to check
	 * @return {@code true} if already visited
	 */
	boolean isVisited(IVertex vertex);

	/**
	 * Adds {@code listener} as a listener to this graph.
	 */
	void addTraversalEventListener(ITraversableGraphEventListener listener);

	/**
	 * Removes {@code listener} as a listener from this graph.
	 */
	void removeTraversalEventListener(ITraversableGraphEventListener listener);

	/**
	 * A step method: initialises the vertices.
	 * 
	 * @param vertices
	 *            the vertices to initialise
	 */
	void stepInitVertices(List<IVertex> vertices);

	/**
	 * A step method: updates the vertices with values as given.
	 * <p>
	 * TODO a map as parameter
	 * 
	 * @param vertices
	 *            the vertices
	 * @param values
	 *            the values
	 */
	void stepUpdateVertices(List<IVertex> vertices, List<String> values);

	/**
	 * A step method: visits a vertex over an edge as given.
	 * 
	 * @param edge
	 *            the edge to discover
	 * @param vertex
	 *            the vertex to visit
	 */
	void stepVisitVertex(IEdge edge, IVertex vertex);

	/**
	 * A step method: sets a vertex and an edge as solution member.
	 * 
	 * @param edge
	 *            the edge to set as solution member
	 * @param vertex
	 *            the vertex to set as solution member
	 */
	void stepSolutionVertex(IEdge edge, IVertex vertex);

	/**
	 * A step method: sets an edge as discovery-edge.
	 * 
	 * @param edge
	 *            the edge to set as discovery-edge
	 */
	void stepDiscoveryEdge(IEdge edge);

	/**
	 * A step method: sets an edge as back-edge.
	 * 
	 * @param edge
	 *            the edge to set as back-edge
	 */
	void stepBackEdge(IEdge edge);

	/**
	 * A step method: sets an edge as forward-edge.
	 * 
	 * @param edge
	 *            the edge to set as forward-edge
	 */
	void stepForwardEdge(IEdge edge);

	/**
	 * A step method: sets an edge as cross-edge.
	 * 
	 * @param edge
	 *            the edge to set as cross-edge
	 */
	void stepCrossEdge(IEdge edge);

	/**
	 * A step method: sets an edge as discarded.
	 * 
	 * @param edge
	 *            the edge to set as discarded
	 */
	void stepDiscardedEdge(IEdge edge);

	/**
	 * A step method: sets an edge as solution member.
	 * 
	 * @param edge
	 *            the edge to set as solution member
	 */
	void stepSolutionEdge(IEdge edge);

}
