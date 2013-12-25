package vistra.core.graph.transformer.vertex;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.item.vertex.ILayoutVertex;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexShape implements Transformer<ILayoutVertex, Shape> {

	@Override
	public Shape transform(ILayoutVertex vertex) {
		double width = GraphFactory.V_WIDTH_DEFAULT;
		double height = GraphFactory.V_HEIGHT_DEFAULT;
		return new Ellipse2D.Double(-width / 2.0, -width / 2.0, width, height);
	}

}
