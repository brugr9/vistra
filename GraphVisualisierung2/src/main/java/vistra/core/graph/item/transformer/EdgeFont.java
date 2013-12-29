package vistra.core.graph.item.transformer;

import java.awt.Font;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.ItemLayoutConstant;

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
		return new Font("", layout.getFont(),
				ItemLayoutConstant.E_FONT_SIZE_DEFAULT);
	}

}
