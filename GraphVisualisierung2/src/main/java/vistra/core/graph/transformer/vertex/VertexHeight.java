package vistra.core.graph.transformer.vertex;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.item.IVertex;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexHeight implements Transformer<IVertex, String> {

	@Override
	public String transform(IVertex vertex) {
		return String.valueOf(GraphFactory.V_HEIGHT_DEFAULT);
	}

}
