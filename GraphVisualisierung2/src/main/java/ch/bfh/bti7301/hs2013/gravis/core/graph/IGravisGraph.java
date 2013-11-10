package ch.bfh.bti7301.hs2013.gravis.core.graph;

import ch.bfh.bti7301.hs2013.gravis.common.IEdge;
import ch.bfh.bti7301.hs2013.gravis.common.IVertex;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
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
	 * 
	 * @return true, if this graph contains no edges and vertices, false
	 *         otherwise.
	 */
	public abstract boolean isEmpty();

	/**
	 * 
	 * @return String
	 */
	public abstract String getDescription();

	/**
	 * 
	 * @param graphName
	 */
	public abstract void setDescription(String graphDescription);

	/**
	 * 
	 * @return graphId
	 */
	public abstract String getId();

	/**
	 * 
	 * @param graphId
	 */
	public abstract void setId(String graphId);

	/**
	 * 
	 * @return EdgeType
	 */
	public abstract EdgeType getEdgeType();
	
	/**
	 * 
	 * @param edgeType
	 */
	public abstract void setEdgeType(EdgeType edgeType);

}
