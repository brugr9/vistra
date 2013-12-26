package vistra.core.graph.transformer.edge;

import java.awt.Paint;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.edge.IEdgeLayout;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeFontColor implements Transformer<IEdgeLayout, Paint> {

	@Override
	public Paint transform(IEdgeLayout layout) {
		return layout.getFontColor();
	}

}
