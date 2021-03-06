package vistra.framework.graph.item.transformer;

import java.awt.Font;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.ILayoutVertex;

/**
 * A vertex transformer: font style.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexFont implements Transformer<ILayoutVertex, Font> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Font transform(ILayoutVertex layout) {
		return layout.getFont();
	}
}
