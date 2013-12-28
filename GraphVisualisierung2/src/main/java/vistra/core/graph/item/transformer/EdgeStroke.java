package vistra.core.graph.item.transformer;

import java.awt.BasicStroke;
import java.awt.Stroke;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.ItemLayoutConstants;

/**
 * An edge transformer: stroke.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeStroke implements Transformer<IEdgeLayout, Stroke> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Stroke transform(IEdgeLayout edge) {

		if (edge.getDash() == null)
			return new BasicStroke(edge.getLineWidth());
		else
			return new BasicStroke(edge.getLineWidth(), BasicStroke.CAP_SQUARE,
					BasicStroke.JOIN_MITER, 10.0f, edge.getDash(),
					ItemLayoutConstants.E_DASH_PHASE);
	}
}
