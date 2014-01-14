package vistra.framework.graph.ml;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.IEdgeLayout;

/**
 * An edge transformer: identifier.
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
