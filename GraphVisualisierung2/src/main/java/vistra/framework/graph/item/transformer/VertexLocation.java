package vistra.framework.graph.item.transformer;

import java.awt.geom.Point2D;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.ILayoutVertex;

/**
 * A vertex transformer: location.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexLocation implements Transformer<ILayoutVertex, Point2D> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Point2D transform(ILayoutVertex layout) {
		return layout.getLocation();
	}

}
