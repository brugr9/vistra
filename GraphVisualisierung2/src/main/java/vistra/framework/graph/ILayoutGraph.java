package vistra.framework.graph;

import java.io.Serializable;

import vistra.framework.graph.item.ILayoutEdge;
import vistra.framework.graph.item.ILayoutVertex;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.event.GraphEventListener;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An extended JUNG graph interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface ILayoutGraph extends Graph<ILayoutVertex, ILayoutEdge>,
		Serializable {

	/**
	 * Returns the name.
	 * 
	 * @return the name
	 */
	String getName();

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the name to set
	 */
	void setName(String name);

	/**
	 * Returns the edge type.
	 * 
	 * @return the edge type
	 */
	EdgeType getEdgeType();

	/**
	 * Sets the edge type.
	 * 
	 * @param edgeType
	 *            the edge type to set
	 */
	void setEdgeType(EdgeType edgeType);

	/**
	 * Adds {@code listener} as a listener to this graph.
	 */
	void addGraphEventListener(
			GraphEventListener<ILayoutVertex, ILayoutEdge> listener);

	/**
	 * Removes {@code listener} as a listener to this graph.
	 */
	void removeGraphEventListener(
			GraphEventListener<ILayoutVertex, ILayoutEdge> listener);

}
