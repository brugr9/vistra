package vistra.core.graph.transformer.vertex;

import java.awt.Paint;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.vertex.IVertex;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 */
public class VertexFillPaint implements Transformer<IVertex, Paint> {

	@Override
	public Paint transform(IVertex vertex) {
		return vertex.getFillColor();
	}

}