package vistra.core.graph;

import java.io.Serializable;

import vistra.core.graph.item.edge.IEdgeLayout;
import vistra.core.graph.item.vertex.IVertexLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.event.GraphEventListener;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An extended JUNG graph interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IExtendedGraph extends Graph<IVertexLayout, IEdgeLayout>,
		Serializable {

	/**
	 * Returns the name.
	 * 
	 * @return the name
	 */
	public abstract String getName();

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the name to set
	 */
	public abstract void setName(String name);

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
	 * Adds {@code l} as a listener to this graph.
	 */
	public void addGraphEventListener(
			GraphEventListener<IVertexLayout, IEdgeLayout> l);

	/**
	 * Removes {@code l} as a listener to this graph.
	 */
	public void removeGraphEventListener(
			GraphEventListener<IVertexLayout, IEdgeLayout> l);

	/**
	 * Checks for an existing item identifier.
	 * 
	 * @return <code>true</code> if the identifier exists
	 */
	public boolean containsItemId(String id);

}
