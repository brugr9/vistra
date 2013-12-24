package vistra.core.graph.transformer.edge;

import java.awt.BasicStroke;
import java.awt.Stroke;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.item.edge.IEdge;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeStroke implements Transformer<IEdge, Stroke> {

	@Override
	public Stroke transform(IEdge edge) {

		if (edge.getDash() == null)
			return new BasicStroke(edge.getLineWidth());
		else
			return new BasicStroke(edge.getLineWidth(), BasicStroke.CAP_SQUARE,
					BasicStroke.JOIN_MITER, 10.0f, edge.getDash(),
					GraphFactory.E_DASH_PHASE);
	}
}
