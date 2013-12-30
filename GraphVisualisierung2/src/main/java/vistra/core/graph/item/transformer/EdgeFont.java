package vistra.core.graph.item.transformer;

import java.awt.Font;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.IEdgeLayout;

/**
 * An edge transformer: font style.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeFont implements Transformer<IEdgeLayout, Font> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Font transform(IEdgeLayout layout) {
		return layout.getFont();
	}

}
