package vistra.framework.graph.item.transformer;

import java.awt.Paint;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.IEdgeLayout;

/**
 * An edge transformer: font colour.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeFontColor implements Transformer<IEdgeLayout, Paint> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Paint transform(IEdgeLayout layout) {
		return layout.getFontColor();
	}

}