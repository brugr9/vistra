package vistra.core.graph.transformer.vertex;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.vertex.ILayoutVertex;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexCoordY implements Transformer<ILayoutVertex, String> {

	@Override
	public String transform(ILayoutVertex layout) {
		return String.valueOf(new Double(layout.getLocation().getY())
				.intValue());
	}

}
