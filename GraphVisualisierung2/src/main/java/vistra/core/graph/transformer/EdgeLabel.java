package vistra.core.graph.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.IEdgeLayout;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeLabel implements Transformer<IEdgeLayout, String> {

	@Override
	public String transform(IEdgeLayout edge) {
		String id = "";
		if (edge.getId() != "")
			id = edge.getId() + ": ";
		return id + edge.getWeight();
	}

}
