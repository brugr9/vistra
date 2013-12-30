package vistra.core.graph.item.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.IVertexLayout;

/**
 * A vertex transformer: label.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexLabel implements Transformer<IVertexLayout, String> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String transform(IVertexLayout layout) {
		String id = layout.getId();
		String value = layout.getValue();
		if (id != "" && value != "")
			id += ": ";
		return id + value;
	}
}
