package vistra.core.graph.item.vertex;

import org.apache.commons.collections15.Factory;

import vistra.core.graph.item.vertex.state.VertexStateHandler;

/**
 * A vertex factory.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexFactory implements Factory<ILayoutVertex> {

	/**
	 * Creates a vertex.
	 * 
	 * @return the vertex.
	 */
	@Override
	public ILayoutVertex create() {
		return createVertexLayout();
	}

	/**
	 * Creates a vertex layout.
	 * 
	 * @return the vertex layout
	 */
	public static ILayoutVertex createVertexLayout() {
		IVertex vertex = new Vertex();
		ILayoutVertex vertexLayout = new LayoutVertex(vertex);
		try {
			((VertexStateHandler) vertexLayout).handleUnexplored();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vertexLayout;
	}
}
