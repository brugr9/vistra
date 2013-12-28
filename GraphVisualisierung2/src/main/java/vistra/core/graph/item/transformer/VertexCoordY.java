package vistra.core.graph.item.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.IVertexLayout;

/**
 * A vertex transformer: y-coordinate.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexCoordY implements Transformer<IVertexLayout, String> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String transform(IVertexLayout layout) {
		return String.valueOf(new Double(layout.getLocation().getY())
				.intValue());
	}

}
