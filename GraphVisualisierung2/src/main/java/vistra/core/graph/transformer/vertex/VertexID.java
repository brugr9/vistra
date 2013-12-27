package vistra.core.graph.transformer.vertex;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.IVertexLayout;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexID implements Transformer<IVertexLayout, String> {

	@Override
	public String transform(IVertexLayout layout) {
		return layout.getId();
	}

}
