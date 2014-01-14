package vistra.framework.graph.item.transformer;

import java.awt.Stroke;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.ILayoutEdge;

/**
 * An edge transformer: stroke.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeStroke implements Transformer<ILayoutEdge, Stroke> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Stroke transform(ILayoutEdge edge) {
		return edge.getStroke();
	}
}
