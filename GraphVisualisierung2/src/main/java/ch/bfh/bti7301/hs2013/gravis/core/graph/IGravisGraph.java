package ch.bfh.bti7301.hs2013.gravis.core.graph;

import ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm.GraphType;
import ch.bfh.bti7301.hs2013.gravis.common.IEdge;
import ch.bfh.bti7301.hs2013.gravis.common.IVertex;
import edu.uci.ics.jung.graph.Graph;

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
	public abstract String getGraphName();

	/**
	 * 
	 * @param graphName
	 */
	public abstract void setGraphName(String graphName);

	/**
	 * 
	 * @return graphId
	 */
	public abstract String getGraphId();

	/**
	 * 
	 * @param graphId
	 */
	public abstract void setGraphId(String graphId);

	/**
	 * 
	 * @return GraphType[]
	 */
	public abstract GraphType[] getType();

	/**
	 * 
	 * @param graphType
	 */
	public abstract void setType(GraphType[] graphType);
}
