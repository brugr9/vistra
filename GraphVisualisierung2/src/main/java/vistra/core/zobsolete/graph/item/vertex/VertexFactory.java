package vistra.core.zobsolete.graph.item.vertex;

import org.apache.commons.collections15.Factory;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class VertexFactory implements Factory<IVertex> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.collections15.Factory#create()
	 */
	@Override
	public IVertex create() {
		return new GravisVertex();
	}

	/**
	 * @param vertex
	 * @return the restricted vertex
	 */
	public static IRestrictedVertex createRestrictedVertex(IVertex vertex) {
		return new RestrictedVertex(vertex);
	}

}
