package vistra.framework.graph.item.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.ILayoutVertex;

/**
 * A vertex transformer: label.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexLabel implements Transformer<ILayoutVertex, String> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String transform(ILayoutVertex vertex) {
		String label = "", id = "", value = "";
		if (vertex.getId() != null)
			id = vertex.getId();
		value = vertex.getValue();
		if (id != "" && value != "")
			label = id + ": " + value;
		else
			label = id + value;
		return label;
	}

}
