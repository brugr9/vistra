package vistra.core.graph.transformer.edge;

import java.awt.Font;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.item.edge.IEdge;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeFont implements Transformer<IEdge, Font> {

	@Override
	public Font transform(IEdge edge) {

		return new Font("", edge.getFontStyle(),
				GraphFactory.E_FONT_SIZE_DEFAULT);
	}
}
