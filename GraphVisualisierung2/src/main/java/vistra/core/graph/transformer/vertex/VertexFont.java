package vistra.core.graph.transformer.vertex;

import java.awt.Font;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.item.vertex.ILayoutVertex;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexFont implements Transformer<ILayoutVertex, Font> {

	@Override
	public Font transform(ILayoutVertex layout) {
		return new Font("", layout.getFontStyle(),
				GraphFactory.V_FONT_SIZE_DEFAULT);
	}
}
