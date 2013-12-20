package vistra.gui.view.component.vizualization.transformer;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import org.apache.commons.collections15.Transformer;
import vistra.core.graph.GraphPropertyConstants;
import vistra.core.graph.item.vertex.IVertex;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class ShapeTransformer implements Transformer<IVertex, Shape> {

	@Override
	public Shape transform(IVertex vertex) {
		double width = GraphPropertyConstants.V_WIDTH_DEFAULT;
		double height = GraphPropertyConstants.V_HEIGHT_DEFAULT;
		return new Ellipse2D.Double(-width / 2.0, -width / 2.0, width, height);
	}

}
