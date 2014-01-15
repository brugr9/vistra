package vistra.framework.graph.item.transformer;

import java.awt.Color;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.ILayoutVertex;

/**
 * A vertex transformer: font color.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexFontColor implements Transformer<ILayoutVertex, Color> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color transform(ILayoutVertex layout) {
		return layout.getFontColor();
	}

}
