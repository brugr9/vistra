package vistra.core.graph.transformer.edge;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.edge.IEdge;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeID implements Transformer<IEdge, String> {

	@Override
	public String transform(IEdge edge) {
		return edge.getId();
	}

}