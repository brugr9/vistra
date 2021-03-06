package vistra.framework.graph;

import java.util.Collection;
import java.util.SortedSet;

import net.datastructures.Entry;
import vistra.framework.graph.item.IEdge;
import vistra.framework.graph.item.IVertex;
import vistra.framework.traversal.ITraversal;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * A traversable graph interface. The graph delegates most of its method calls
 * to a constructor-specified {@code Graph}.
 * <ul>
 * <li>Modifiers are not supported anymore: vertices and edges can neither been
 * added nor removed.
 * <li>In addition, this graph serves with a 'step'-method which an
 * {@code IAlgorithm}-developer can use for traversing over the graph and
 * generating a {@code Traversal}.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see ITraversal
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
	 * Returns a view of all vertices in this graph. The ordering of the
	 * vertices within the set is guaranteed to be in alphabetical order of the
	 * vertices id.
	 * 
	 * @return a {@code SortedSet} view of all vertices in this graph
	 */
	SortedSet<IVertex> getVerticesSorted();

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
	 * @param v
	 *            the vertex to check
	 * @return {@code true} if visited
	 */
	boolean isVisited(IVertex v);

	/**
	 * A step method: Back edge.
	 * 
	 * @param e
	 *            the edge
	 * @throws Exception
	 */
	void stepBackEdge(IEdge e) throws Exception;

	/**
	 * A step method: Back edge.
	 * 
	 * @param e
	 *            the edges
	 * @throws Exception
	 */
	void stepBackEdge(Iterable<IEdge> e) throws Exception;

	/**
	 * A step method: Cross edge.
	 * 
	 * @param e
	 *            the edge
	 * @throws Exception
	 */
	void stepCrossEdge(IEdge e) throws Exception;

	/**
	 * A step method: Cack edge.
	 * 
	 * @param e
	 *            the edges
	 * @throws Exception
	 */
	void stepCrossEdge(Iterable<IEdge> e) throws Exception;

	/**
	 * A step method: Forward edge.
	 * 
	 * @param e
	 *            the edge
	 * @throws Exception
	 */
	void stepForwardEdge(IEdge e) throws Exception;

	/**
	 * A step method: Forward edge.
	 * 
	 * @param e
	 *            the edges
	 * @throws Exception
	 */
	void stepForwardEdge(Iterable<IEdge> e) throws Exception;

	/**
	 * A step method: Discarded edge.
	 * 
	 * @param e
	 *            the edge
	 * @throws Exception
	 */
	void stepDiscardedEdge(IEdge e) throws Exception;

	/**
	 * A step method: Discarded edge.
	 * 
	 * @param e
	 *            the edges
	 * @throws Exception
	 */
	void stepDiscardedEdge(Iterable<IEdge> e) throws Exception;

	/**
	 * A step method: Initialized vertex.
	 * 
	 * The start vertex value will be set as {@code 0}, the other vertices value
	 * as {@code SigmaPalette.infinity}.
	 * 
	 * @param i
	 *            the vertices
	 * @throws Exception
	 */
	void stepInitializedVertex(Iterable<IVertex> i) throws Exception;

	/**
	 * A step method: Initialized vertex.
	 * 
	 * The start vertex value will be set as {@code 0}, the other vertices value
	 * as {@code SigmaPalette.infinity}.
	 * 
	 * @param s
	 *            the start vertex
	 * @param i
	 *            the other vertices
	 * @throws Exception
	 */
	void stepInitializedVertex(IVertex s, Iterable<IVertex> i) throws Exception;

	/**
	 * A step method: Updated vertex.
	 * 
	 * @param u
	 *            the vertex to update
	 * @param value
	 *            the value to set
	 * @throws Exception
	 */
	void stepUpdatedVertex(IVertex u, Integer value) throws Exception;

	/**
	 * A step method: Updated vertex.
	 * 
	 * @param u
	 *            the vertices to update with a value as given
	 * @throws Exception
	 */
	void stepUpdatedVertex(Entry<Integer, IVertex> u) throws Exception;

	/**
	 * A step method: Visit vertex.
	 * 
	 * @param v
	 *            the vertex to visit
	 * @throws Exception
	 */
	void stepVisit(IVertex v) throws Exception;

	/**
	 * A step method: Visit edge.
	 * 
	 * @param e
	 *            the edge to discover
	 * @throws Exception
	 */
	void stepVisit(IEdge e) throws Exception;

	/**
	 * A step method: Visit vertex over edge.
	 * 
	 * @param v
	 *            the vertex to visit
	 * @param e
	 *            the edge to discover
	 * @throws Exception
	 */
	void stepVisit(IVertex v, IEdge e) throws Exception;

	/**
	 * A step method: Solution-member vertex.
	 * 
	 * @param v
	 *            a vertex
	 * @throws Exception
	 */
	void stepSolutionMember(IVertex v) throws Exception;

	/**
	 * A step method: Solution-member vertex over edge.
	 * 
	 * @param v
	 *            a vertex
	 * @param e
	 *            an edge
	 * @throws Exception
	 */
	void stepSolutionMember(IVertex v, IEdge e) throws Exception;

	/**
	 * A step method: Solution-member vertex over edge.
	 * 
	 * @param items
	 *            the vertices and edges
	 * @throws Exception
	 */
	void stepSolutionMember(Iterable<Entry<IVertex, IEdge>> items)
			throws Exception;

}
