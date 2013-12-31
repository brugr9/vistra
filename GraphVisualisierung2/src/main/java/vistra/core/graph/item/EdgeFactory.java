package vistra.core.graph.item;

import org.apache.commons.collections15.Factory;

import vistra.core.graph.item.state.EdgeStateHandler;
import vistra.core.graph.item.state.IEdgeStateHandler;

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
		return createEdgeLayout();
	}

	/**
	 * Creates an edge layout.
	 * 
	 * @return the edge layout
	 */
	public static IEdgeLayout createEdgeLayout() {
		IEdgeStateHandler edge = new EdgeStateHandler();
		try {
			edge.handleUnexplored();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (IEdgeLayout) edge;
	}
}
