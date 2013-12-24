package vistra.core.graph.transformer.vertex;

import java.awt.Font;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.item.vertex.IVertex;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexFont implements Transformer<IVertex, Font> {

	@Override
	public Font transform(IVertex vertex) {

		return new Font("", vertex.getFontStyle(),
				GraphFactory.V_FONT_SIZE_DEFAULT);
	}
}
