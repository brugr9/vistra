package vistra.core.graph.transformer.vertex;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.vertex.IVertex;
import vistra.util.ColorPalette;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexFontColor implements Transformer<IVertex, String> {

	@Override
	public String transform(IVertex vertex) {
		return ColorPalette.toString(vertex.getFontColor());
	}

}
