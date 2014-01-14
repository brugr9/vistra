package vistra.framework.graph.item.transformer;

import java.awt.Paint;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.ILayoutVertex;

/**
 * A vertex transformer: font colour.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexFontColor implements Transformer<ILayoutVertex, Paint> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Paint transform(ILayoutVertex layout) {
		return layout.getFontColor();
	}

}
