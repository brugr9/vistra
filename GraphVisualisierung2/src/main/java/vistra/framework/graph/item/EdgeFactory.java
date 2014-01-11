package vistra.framework.graph.item;

import org.apache.commons.collections15.Factory;

import vistra.framework.graph.item.state.EdgeStateHandler;

/**
 * An edge factory.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeFactory implements Factory<IEdgeLayout> {

	/**
	 * Creates an edge.
	 * 
	 * @return the edge
	 */
	@Override
	public IEdgeLayout create() {
		return createEdge();
	}

	/**
	 * Creates an edge.
	 * 
	 * @return the edge
	 */
	public static IEdgeLayout createEdge() {
		return (IEdgeLayout) new EdgeStateHandler();
	}
}
