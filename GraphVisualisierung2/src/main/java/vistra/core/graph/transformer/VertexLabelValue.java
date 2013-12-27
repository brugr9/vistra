package vistra.core.graph.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.IVertexLayout;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexLabelValue implements Transformer<IVertexLayout, String> {

	@Override
	public String transform(IVertexLayout layout) {
		String value = "";
		if (layout.getValue() != 0.0)
			value = ": " + layout.getValue();
		return layout.getId() + value;
	}
}
