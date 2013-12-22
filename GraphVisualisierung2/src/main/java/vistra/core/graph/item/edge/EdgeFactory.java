package vistra.core.graph.item.edge;

import org.apache.commons.collections15.Factory;

/**
 * An edge factory.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeFactory implements Factory<IEdge> {

	/**
	 * Creates an edge.
	 * 
	 * @return the edge
	 */
	@Override
	public IEdge create() {
		IEdge edge = new Edge();
		try {
			edge.handleUnexplored();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return edge;
	}

	/**
	 * Creates an edge.
	 * 
	 * @return the edge
	 */
	public static IEdge createEdge() {
		IEdge edge = new Edge();
		try {
			edge.handleUnexplored();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return edge;
	}
}
