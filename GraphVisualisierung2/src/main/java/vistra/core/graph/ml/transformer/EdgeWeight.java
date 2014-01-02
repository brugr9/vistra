package vistra.core.graph.ml.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.IEdgeLayout;

/**
 * An edge transformer: weight.
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
