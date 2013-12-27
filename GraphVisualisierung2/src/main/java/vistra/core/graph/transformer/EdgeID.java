package vistra.core.graph.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.IEdgeLayout;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeID implements Transformer<IEdgeLayout, String> {

	@Override
	public String transform(IEdgeLayout layout) {
		return layout.getId();
	}

}
