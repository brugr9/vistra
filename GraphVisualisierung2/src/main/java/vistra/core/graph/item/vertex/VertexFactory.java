package vistra.core.graph.item.vertex;

import org.apache.commons.collections15.Factory;

import vistra.core.graph.item.vertex.state.VertexStateHandler;

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
		IVertex vertex = new Vertex();
		IVertexLayout vertexLayout = new VertexLayout(vertex);
		try {
			((VertexStateHandler) vertexLayout).handleUnexplored();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vertexLayout;
	}
}
