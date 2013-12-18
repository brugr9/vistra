package vistra.util.transformer;

import java.awt.BasicStroke;
import java.awt.Stroke;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.obsolete.item.edge.IEdge;


/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public class EdgeStrokeTransformer implements Transformer<IEdge, Stroke> {

	/* (non-Javadoc)
	 * @see org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public Stroke transform(IEdge edge) {
		return new BasicStroke(edge.getCurrentStrokeWidth());
	}

}
