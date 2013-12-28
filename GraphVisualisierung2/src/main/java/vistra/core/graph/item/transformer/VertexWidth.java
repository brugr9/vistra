package vistra.core.graph.item.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.item.IVertex;

/**
 * A vertex transformer: width.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexWidth implements Transformer<IVertex, String> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String transform(IVertex vertex) {
		return String.valueOf(GraphFactory.V_WIDTH_DEFAULT);
	}

}
