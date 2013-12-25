package vistra.core.graph.transformer.vertex;

import java.awt.Paint;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.vertex.ILayoutVertex;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexFontColor implements Transformer<ILayoutVertex, Paint> {

	@Override
	public Paint transform(ILayoutVertex layout) {
		return layout.getFontColor();
	}

}
