package vistra.core.graph.transformer.edge;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.edge.IEdgeLayout;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeWeight implements Transformer<IEdgeLayout, String> {

	@Override
	public String transform(IEdgeLayout edge) {
		return Integer.toString(edge.getValue());
	}

}
