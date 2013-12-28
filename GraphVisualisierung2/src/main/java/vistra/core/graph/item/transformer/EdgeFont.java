package vistra.core.graph.item.transformer;

import java.awt.Font;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.item.IEdgeLayout;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeFont implements Transformer<IEdgeLayout, Font> {

	@Override
	public Font transform(IEdgeLayout layout) {
		return new Font("", layout.getFontStyle(),
				GraphFactory.E_FONT_SIZE_DEFAULT);
	}

}
