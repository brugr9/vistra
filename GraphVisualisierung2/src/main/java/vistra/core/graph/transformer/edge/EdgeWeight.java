package vistra.core.graph.transformer.edge;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.edge.IEdge;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeWeight implements Transformer<IEdge, String> {

	@Override
	public String transform(IEdge edge) {
		return Double.toString(edge.getValue());
	}

}
