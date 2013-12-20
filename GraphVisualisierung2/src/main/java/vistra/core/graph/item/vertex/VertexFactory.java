package vistra.core.graph.item.vertex;

import org.apache.commons.collections15.Factory;

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
		return new Vertex();
	}

	/**
	 * Creates a vertex.
	 * 
	 * @return the vertex.
	 */
	public static IVertex createVertex() {
		return new Vertex();
	}
}
