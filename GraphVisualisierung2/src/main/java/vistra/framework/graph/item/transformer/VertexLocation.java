package vistra.framework.graph.item.transformer;

import java.awt.geom.Point2D;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.IVertexLayout;

/**
 * A vertex transformer: location.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexLocation implements Transformer<IVertexLayout, Point2D> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Point2D transform(IVertexLayout layout) {
		return layout.getLocation();
	}

}
