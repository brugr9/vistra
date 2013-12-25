package vistra.core.graph.transformer.edge;

import java.awt.Font;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.item.edge.ILayoutEdge;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeFont implements Transformer<ILayoutEdge, Font> {

	@Override
	public Font transform(ILayoutEdge layout) {

		return new Font("", layout.getFontStyle(),
				GraphFactory.E_FONT_SIZE_DEFAULT);
	}
}
