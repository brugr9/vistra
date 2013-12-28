package vistra.core.graph.item.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.IEdgeLayout;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeWeight implements Transformer<IEdgeLayout, String> {

	@Override
	public String transform(IEdgeLayout edge) {
		return Integer.toString(edge.getWeight());
	}

}
