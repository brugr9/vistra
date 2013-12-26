package vistra.core.graph.transformer.vertex;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.vertex.IVertexLayout;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexEnd implements Transformer<IVertexLayout, String> {

	@Override
	public String transform(IVertexLayout vertex) {
		return String.valueOf(vertex.isEnd());
	}

}
