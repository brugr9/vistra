package vistra.core.graph.transformer.vertex;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.vertex.IVertex;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexValue implements Transformer<IVertex, String> {

	@Override
	public String transform(IVertex vertex) {
		return Double.toString(vertex.getValue());
	}

}
