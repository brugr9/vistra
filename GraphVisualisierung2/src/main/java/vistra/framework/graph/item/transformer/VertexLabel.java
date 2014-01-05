package vistra.framework.graph.item.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.IVertexLayout;

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
	public String transform(IVertexLayout vertex) {
		String label = "";
		String id = vertex.getId().trim();
		String value = vertex.getValue();
		if (id != "" && value != "")
			label = id + ": " + value;
		else
			label = id + value;
		return label;
	}
}
