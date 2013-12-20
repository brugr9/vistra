package vistra.gui.view.component.vizualization.transformer;

import java.awt.BasicStroke;
import java.awt.Stroke;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.vertex.IVertex;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexStrokeTransformer implements Transformer<IVertex, Stroke> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public Stroke transform(IVertex vertex) {
		return new BasicStroke(vertex.getCurrentStrokeWidth());
	}

}
