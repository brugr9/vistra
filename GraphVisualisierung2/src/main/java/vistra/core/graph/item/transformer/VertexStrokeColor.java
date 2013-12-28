package vistra.core.graph.item.transformer;

import java.awt.Paint;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.IVertexLayout;

/**
 * A vertex transformer: stroke colour.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexStrokeColor implements Transformer<IVertexLayout, Paint> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Paint transform(IVertexLayout layout) {
		return layout.getStrokeColor();
	}

}