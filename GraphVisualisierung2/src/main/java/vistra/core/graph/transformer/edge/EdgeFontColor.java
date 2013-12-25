package vistra.core.graph.transformer.edge;

import java.awt.Paint;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.edge.ILayoutEdge;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeFontColor implements Transformer<ILayoutEdge, Paint> {

	@Override
	public Paint transform(ILayoutEdge layout) {
		return layout.getFontColor();
	}

}
