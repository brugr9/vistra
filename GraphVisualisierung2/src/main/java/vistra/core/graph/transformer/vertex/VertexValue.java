package vistra.core.graph.transformer.vertex;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.vertex.ILayoutVertex;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexValue implements Transformer<ILayoutVertex, String> {

	@Override
	public String transform(ILayoutVertex vertex) {
		return Double.toString(vertex.getValue());
	}

}
