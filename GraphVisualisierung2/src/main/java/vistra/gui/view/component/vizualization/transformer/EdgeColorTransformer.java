package vistra.gui.view.component.vizualization.transformer;

import java.awt.Paint;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.edge.IEdge;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeColorTransformer implements Transformer<IEdge, Paint> {

	@Override
	public Paint transform(IEdge edge) {
		return edge.getCurrentColor();
	}

}
