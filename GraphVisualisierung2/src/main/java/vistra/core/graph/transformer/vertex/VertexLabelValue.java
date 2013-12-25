package vistra.core.graph.transformer.vertex;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.vertex.ILayoutVertex;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexLabelValue implements Transformer<ILayoutVertex, String> {

	@Override
	public String transform(ILayoutVertex layout) {
		String value = "";
		if (layout.getValue() != 0.0)
			value = ": " + layout.getValue();
		return layout.getId() + value;
	}
}
