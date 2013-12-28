package vistra.core.graph.item;

import org.apache.commons.collections15.Factory;

import vistra.core.graph.item.state.IVertexStateHandler;
import vistra.core.graph.item.state.VertexStateHandler;

/**
 * A vertex factory.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexFactory implements Factory<IVertexLayout> {

	/**
	 * Creates a vertex.
	 * 
	 * @return the vertex.
	 */
	@Override
	public IVertexLayout create() {
		return createVertexLayout();
	}

	/**
	 * Creates a vertex layout.
	 * 
	 * @return the vertex layout
	 */
	public static IVertexLayout createVertexLayout() {
		IVertexStateHandler vertex = new VertexStateHandler();
		try {
			vertex.handleUnexplored();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (IVertexLayout) vertex;
	}
}
