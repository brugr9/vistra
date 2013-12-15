package ch.bfh.bti7301.hs2013.gravis.core.graph;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An interface for a graph adapting a JUNG graph for GRAVIS.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public interface IGravisGraph extends Graph<IVertex, IEdge> {

	/**
	 * Removes all vertices and edges from the graph. After the call of this
	 * method the method isEmpty() returns true.
	 */
	public abstract void clear();

	/**
	 * Returns the is empty status.
	 * 
	 * @return <code>true</code> if the graph contains neither edges nor
	 *         vertices, <code>false</code> otherwise
	 */
	public abstract boolean isEmpty();

	/**
	 * Returns the graph description.
	 * 
	 * @return the graph description
	 */
	public abstract String getDescription();

	/**
	 * Sets the graph description.
	 * 
	 * @param graphDescription
	 *            the graph description
	 */
	public abstract void setDescription(String graphDescription);

	/**
	 * Returns the graph identifier.
	 * 
	 * @return the graph identifier
	 */
	public abstract String getId();

	/**
	 * 
	 * @param graphId
	 */
	public abstract void setId(String graphId);

	/**
	 * Returns the edge type.
	 * 
	 * @return the edge type
	 */
	public abstract EdgeType getEdgeType();

	/**
	 * Sets the edge type.
	 * 
	 * @param edgeType
	 *            the edge type to set
	 */
	public abstract void setEdgeType(EdgeType edgeType);

	/**
	 * @param vertexId
	 * @return boolean
	 */
	public abstract boolean containsVertexId(String vertexId);

	/**
	 * @param edgeId
	 * @return boolean
	 */
	public abstract boolean containsEdgeId(String edgeId);

	/**
	 * @param itemId
	 * @return boolean
	 */
	public abstract boolean containsItemId(String itemId);

}
