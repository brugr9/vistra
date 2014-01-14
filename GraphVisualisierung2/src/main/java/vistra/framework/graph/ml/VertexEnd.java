package vistra.framework.graph.ml;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.ILayoutVertex;

/**
 * A transformer for writing a GraphML file: vertex end value.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexEnd implements Transformer<ILayoutVertex, String> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String transform(ILayoutVertex vertex) {
		return String.valueOf(vertex.isEnd());
	}

}
