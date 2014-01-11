package vistra.framework.graph.item.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.IEdgeLayout;

/**
 * An edge transformer: label.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeLabel implements Transformer<IEdgeLayout, String> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String transform(IEdgeLayout edge) {
		String label = "", id = "", value = "";
		if (edge.getId() != null)
			id = edge.getId();
		value = Integer.toString(edge.getWeight());
		if (id != "" && value != "")
			label = id + ": " + value;
		else
			label = id + value;
		return label;
	}

}
