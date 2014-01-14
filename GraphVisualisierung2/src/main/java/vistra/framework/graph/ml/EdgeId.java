package vistra.framework.graph.ml;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.ILayoutEdge;

/**
 * A transformer for writing a GraphML file: edge identifier.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeId implements Transformer<ILayoutEdge, String> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String transform(ILayoutEdge layout) {
		return layout.getId();
	}

}
