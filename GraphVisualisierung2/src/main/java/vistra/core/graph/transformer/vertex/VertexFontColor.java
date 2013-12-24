package vistra.core.graph.transformer.vertex;

import java.awt.Paint;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.vertex.IVertexLayout;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexFontColor implements Transformer<IVertexLayout, Paint> {

	@Override
	public Paint transform(IVertexLayout layout) {
		return layout.getFontColor();
	}

}
