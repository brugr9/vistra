package vistra.util.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.obsolete.item.vertex.IVertex;


/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public class VertexIDTransformer implements Transformer<IVertex, String> {

	/* (non-Javadoc)
	 * @see org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public String transform(IVertex vertex) {
		return vertex.getId();
	}

}
