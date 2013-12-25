package vistra.core.graph.transformer.vertex;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.vertex.ILayoutVertex;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexID implements Transformer<ILayoutVertex, String> {

	@Override
	public String transform(ILayoutVertex layout) {
		return layout.getId();
	}

}
