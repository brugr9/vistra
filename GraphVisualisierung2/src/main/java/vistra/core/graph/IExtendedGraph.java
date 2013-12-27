package vistra.core.graph;

import java.io.Serializable;

import vistra.core.graph.event.IRenderGraphEventListener;
import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
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
	abstract String getName();

	/**
	 * Sets the name.
	 * 
	 * @param name
	 *            the name to set
	 */
	abstract void setName(String name);

	/**
	 * Returns the edge type.
	 * 
	 * @return the edge type
	 */
	abstract EdgeType getEdgeType();

	/**
	 * Sets the edge type.
	 * 
	 * @param edgeType
	 *            the edge type to set
	 */
	abstract void setEdgeType(EdgeType edgeType);

	/**
	 * Adds {@code listener} as a listener to this graph.
	 */
	abstract void addGraphEventListener(
			GraphEventListener<IVertexLayout, IEdgeLayout> listener);

	/**
	 * Adds {@code listener} as a listener to this graph.
	 */
	abstract void addRenderGraphEventListener(
			IRenderGraphEventListener<IVertexLayout, IEdgeLayout> listener);

	/**
	 * Removes {@code listener} as a listener to this graph.
	 */
	abstract void removeGraphEventListener(
			GraphEventListener<IVertexLayout, IEdgeLayout> listener);

	/**
	 * Removes {@code listener} as a listener to this graph.
	 */
	abstract void removeRenderGraphEventListener(
			IRenderGraphEventListener<IVertexLayout, IEdgeLayout> listener);

	/**
	 * Checks an item identifier.
	 * 
	 * @return <code>true</code> if the identifier is not yet used,
	 *         <code>false</code> otherwise
	 */
	boolean unused(String itemId);

}
