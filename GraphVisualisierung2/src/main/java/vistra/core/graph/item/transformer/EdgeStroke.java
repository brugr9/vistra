package vistra.core.graph.item.transformer;

import java.awt.Stroke;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.IEdgeLayout;

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
		return edge.getStroke();
	}
}
