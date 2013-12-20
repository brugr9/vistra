package vistra.core.graph.item.edge;

/**
 * An edge factory.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeFactory {

	/**
	 * Creates an edge.
	 * 
	 * @return the edge
	 */
	public static IEdge create() {
		return new Edge();
	}
}
