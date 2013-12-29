package vistra.core.graph.item.transformer;

import java.awt.Font;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.IVertexLayout;
import vistra.core.graph.item.ItemLayoutConstant;

/**
 * A vertex transformer: font style.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexFont implements Transformer<IVertexLayout, Font> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Font transform(IVertexLayout layout) {
		Font f = new Font("", layout.getFont(),
				ItemLayoutConstant.V_FONT_SIZE_DEFAULT);
		return f;
	}
}
