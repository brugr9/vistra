package vistra.core.graph.item.transformer;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.item.IVertexLayout;

/**
 * A vertex transformer: shape.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexShape implements Transformer<IVertexLayout, Shape> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Shape transform(IVertexLayout vertex) {
		double width = GraphFactory.V_WIDTH_DEFAULT;
		double height = GraphFactory.V_HEIGHT_DEFAULT;
		return new Ellipse2D.Double(-width / 2.0, -width / 2.0, width, height);
	}

}
