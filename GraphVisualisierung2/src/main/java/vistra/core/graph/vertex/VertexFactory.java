package vistra.core.graph.vertex;

import org.apache.commons.collections15.Factory;

/**
 * A vertex factory.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexFactory implements Factory<IVertex> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.collections15.Factory#create()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IVertex create() {
		return new Vertex();
	}

	/**
	 * Creates an restricted vertex out of a vertex as given.
	 * 
	 * @param vertex
	 *            the vertex
	 * @return an restricted vertex
	 */
	public static IRestrictedVertex createRestrictedVertex(IVertex vertex) {
		return new RestrictedVertex(vertex);
	}
}
