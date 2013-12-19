package vistra.util.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.zobsolete.graph.item.vertex.IVertex;


/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class VertexToolTipTransformer implements Transformer<IVertex, String> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public String transform(IVertex vertex) {
		return "Knoten " + vertex.getId() + ": (x = "
				+ new Double(vertex.getLocation().getX()).intValue() + ", y = "
				+ new Double(vertex.getLocation().getY()).intValue() + ")";
	}

}
