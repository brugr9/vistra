package vistra.framework.graph.ml;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.IEdgeLayout;

/**
 * A transformer for writing a GraphML file: edge identifier.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeId implements Transformer<IEdgeLayout, String> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String transform(IEdgeLayout layout) {
		return layout.getId();
	}

}
