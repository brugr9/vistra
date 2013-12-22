package vistra.core.graph.transformer.edge;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.edge.IEdge;
import vistra.util.Convert;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeLabel implements Transformer<IEdge, String> {

	@Override
	public String transform(IEdge edge) {
		return edge.getId()
				+ (Double.isNaN(edge.getWeight()) ? "" : " | "
						+ Convert.toRounded2Decimals(edge.getWeight()));
	}
}
