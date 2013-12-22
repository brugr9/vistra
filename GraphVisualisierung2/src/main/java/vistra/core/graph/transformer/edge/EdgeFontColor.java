package vistra.core.graph.transformer.edge;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.edge.IEdge;
import vistra.util.ColorPalette;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeFontColor implements Transformer<IEdge, String> {

	@Override
	public String transform(IEdge edge) {
		return ColorPalette.toString(edge.getFontColor());
	}

}
