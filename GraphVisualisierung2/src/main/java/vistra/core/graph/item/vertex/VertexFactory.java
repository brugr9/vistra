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
		IVertex vertex = new Vertex();
		try {
			vertex.handleUnexplored();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vertex;
	}

	/**
	 * Creates a vertex.
	 * 
	 * @return the vertex.
	 */
	public static IVertex createVertex() {
		IVertex vertex = new Vertex();
		try {
			vertex.handleUnexplored();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vertex;
	}
}
