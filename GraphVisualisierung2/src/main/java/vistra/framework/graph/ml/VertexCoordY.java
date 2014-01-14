package vistra.framework.graph.ml;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.ILayoutVertex;

/**
 * A transformer for writing a GraphML file: vertex y-coordinate.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexCoordY implements Transformer<ILayoutVertex, String> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String transform(ILayoutVertex vertex) {
		return String.valueOf(vertex.getLocation().getY());
	}

}
