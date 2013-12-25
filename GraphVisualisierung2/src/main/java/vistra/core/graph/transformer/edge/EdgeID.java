package vistra.core.graph.transformer.edge;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.edge.ILayoutEdge;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeID implements Transformer<ILayoutEdge, String> {

	@Override
	public String transform(ILayoutEdge layout) {
		return layout.getId();
	}

}
