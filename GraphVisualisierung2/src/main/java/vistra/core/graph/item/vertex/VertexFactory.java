package vistra.core.graph.item.vertex;

import org.apache.commons.collections15.Factory;

import vistra.core.graph.item.vertex.state.VertexStateHandler;

/**
 * A vertex factory.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexFactory implements Factory<IVertex> {

	/**
	 * Creates a vertex.
	 * 
	 * @return the vertex.
	 */
	@Override
	public IVertex create() {
		return createVertex();
	}

	/**
	 * Creates a vertex.
	 * 
	 * @return the vertex.
	 */
	public static IVertex createVertex() {
		IVertex vertex = new Vertex();
		try {
			((VertexStateHandler) vertex).handleUnexplored();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vertex;
	}
}
