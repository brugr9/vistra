package vistra.framework.graph.ml.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.IVertexLayout;

/**
 * A vertex transformer: x-coordinate.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexCoordX implements Transformer<IVertexLayout, String> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String transform(IVertexLayout vertex) {
		return String.valueOf((int) vertex.getLocation().getX());
	}

}
