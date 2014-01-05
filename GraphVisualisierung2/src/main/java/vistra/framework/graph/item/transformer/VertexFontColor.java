package vistra.framework.graph.item.transformer;

import java.awt.Paint;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.IVertexLayout;

/**
 * A vertex transformer: font colour.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexFontColor implements Transformer<IVertexLayout, Paint> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Paint transform(IVertexLayout layout) {
		return layout.getFontColor();
	}

}
