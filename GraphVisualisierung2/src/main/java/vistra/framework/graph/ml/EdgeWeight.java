package vistra.framework.graph.ml;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.IEdgeLayout;

/**
 * A transformer for writing a GraphML file: edge weight.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeWeight implements Transformer<IEdgeLayout, String> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String transform(IEdgeLayout edge) {
		return Integer.toString(edge.getWeight());
	}

}
