package vistra.core.graph.item.transformer;

import java.awt.Stroke;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.IVertexLayout;

/**
 * A vertex transformer: stroke.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexStroke implements Transformer<IVertexLayout, Stroke> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Stroke transform(IVertexLayout layout) {
		return layout.getStroke();
	}

}
