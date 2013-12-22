package vistra.core.graph.transformer.edge;

import java.awt.BasicStroke;
import java.awt.Stroke;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.edge.IEdge;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeLineWidthTransformer implements Transformer<IEdge, Stroke> {

	@Override
	public Stroke transform(IEdge edge) {
		return new BasicStroke(edge.getLineWidth());
	}

}
