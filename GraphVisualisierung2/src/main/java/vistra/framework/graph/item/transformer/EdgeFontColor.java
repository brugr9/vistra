package vistra.framework.graph.item.transformer;

import java.awt.Color;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.ILayoutEdge;

/**
 * An edge transformer: font color.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeFontColor implements Transformer<ILayoutEdge, Color> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color transform(ILayoutEdge layout) {
		return layout.getFontColor();
	}

}
