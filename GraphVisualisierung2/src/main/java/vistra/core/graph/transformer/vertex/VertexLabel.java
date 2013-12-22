package vistra.core.graph.transformer.vertex;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.vertex.IVertex;
import vistra.util.Convert;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexLabel implements Transformer<IVertex, String> {

	@Override
	public String transform(IVertex vertex) {
		String value = "";
		if (Double.isNaN(vertex.getValue()) && vertex.getValue() != 0.0)
			value = ": " + Convert.toRounded2Decimals(vertex.getValue());
		return vertex.getId() + value;
	}
}
