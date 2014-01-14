package vistra.framework.graph.item.transformer;

import java.awt.Paint;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.ILayoutVertex;

/**
 * A vertex transformer: stroke colour.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexStrokeColor implements Transformer<ILayoutVertex, Paint> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Paint transform(ILayoutVertex layout) {
		return layout.getStrokeColor();
	}

}
