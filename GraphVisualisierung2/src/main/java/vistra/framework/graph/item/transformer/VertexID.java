package vistra.framework.graph.item.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.IVertexLayout;

/**
 * A vertex transformer: identifier.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexID implements Transformer<IVertexLayout, String> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String transform(IVertexLayout layout) {
		return layout.getId();
	}

}
