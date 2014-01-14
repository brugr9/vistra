package vistra.framework.graph.item;

import org.apache.commons.collections15.Factory;

import vistra.framework.graph.item.state.EdgeStateHandler;

/**
 * An edge factory.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeFactory implements Factory<ILayoutEdge> {

	/**
	 * Creates a layout edge.
	 * 
	 * @return the edge
	 */
	@Override
	public ILayoutEdge create() {
		return createEdge();
	}

	/**
	 * Creates a layout edge.
	 * 
	 * @return the edge
	 */
	public static ILayoutEdge createEdge() {
		return (ILayoutEdge) new EdgeStateHandler();
	}
}
