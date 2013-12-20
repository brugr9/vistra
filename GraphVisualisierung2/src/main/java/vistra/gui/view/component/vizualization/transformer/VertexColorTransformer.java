package vistra.gui.view.component.vizualization.transformer;

import java.awt.Paint;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.vertex.IVertex;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 */
public class VertexColorTransformer implements Transformer<IVertex, Paint> {

	@Override
	public Paint transform(IVertex vertex) {
		return vertex.getLineColor();
	}

}