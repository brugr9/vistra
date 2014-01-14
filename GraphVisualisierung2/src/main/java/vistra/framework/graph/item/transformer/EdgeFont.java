package vistra.framework.graph.item.transformer;

import java.awt.Font;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.ILayoutEdge;

/**
 * An edge transformer: font style.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeFont implements Transformer<ILayoutEdge, Font> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Font transform(ILayoutEdge layout) {
		return layout.getFont();
	}

}
