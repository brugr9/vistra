package vistra.core.graph.transformer.vertex;

import java.awt.BasicStroke;
import java.awt.Stroke;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.vertex.ILayoutVertex;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexStroke implements Transformer<ILayoutVertex, Stroke> {

	@Override
	public Stroke transform(ILayoutVertex layout) {
		return new BasicStroke(layout.getLineWidth());
	}

}
