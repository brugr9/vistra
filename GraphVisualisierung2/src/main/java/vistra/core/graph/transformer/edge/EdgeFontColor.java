package vistra.core.graph.transformer.edge;

import java.awt.Paint;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.edge.IEdge;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeFontColor implements Transformer<IEdge, Paint> {

	@Override
	public Paint transform(IEdge edge) {
		return edge.getFontColor();
	}

}
