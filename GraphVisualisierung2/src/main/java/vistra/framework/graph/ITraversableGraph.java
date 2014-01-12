package vistra.framework.graph;

import java.util.Collection;

import vistra.framework.graph.item.IEdge;
import vistra.framework.graph.item.IVertex;
import vistra.framework.traversal.Traversal;
import vistra.framework.traversal.step.IStep;
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
	 * @param v
	 *            the vertex to check
	 * @return {@code true} if visited
	 */
	boolean isVisited(IVertex v);

	/**
	 * A step method: executes a step and adds the step to the traversal.
	 * 
	 * @param s
	 *            the step
	 * @throws Exception
	 */
	void stepBy(IStep s) throws Exception;

}
