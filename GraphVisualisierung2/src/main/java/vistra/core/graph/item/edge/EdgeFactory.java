package vistra.core.graph.item.edge;

import org.apache.commons.collections15.Factory;

import vistra.core.graph.item.edge.state.EdgeStateHandler;

/**
 * An edge factory.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeFactory implements Factory<ILayoutEdge> {

	/**
	 * Creates an edge.
	 * 
	 * @return the edge
	 */
	@Override
	public ILayoutEdge create() {
		return createEdgeLayout();
	}

	/**
	 * Creates an edge layout.
	 * 
	 * @return the edge layout
	 */
	public static ILayoutEdge createEdgeLayout() {
		IEdge edge = new Edge();
		ILayoutEdge edgeLayout = new LayoutEdge(edge);
		try {
			((EdgeStateHandler) edgeLayout).handleUnexplored();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return edgeLayout;
	}
}
