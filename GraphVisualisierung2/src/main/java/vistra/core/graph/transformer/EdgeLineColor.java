package vistra.core.graph.transformer;

import java.awt.Paint;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.IEdgeLayout;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeLineColor implements Transformer<IEdgeLayout, Paint> {

	@Override
	public Paint transform(IEdgeLayout layout) {
		return layout.getLineColor();
	}

}
