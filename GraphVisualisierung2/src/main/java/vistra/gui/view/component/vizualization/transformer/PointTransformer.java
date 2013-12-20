package vistra.gui.view.component.vizualization.transformer;

import java.awt.geom.Point2D;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.vertex.IVertex;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class PointTransformer implements Transformer<IVertex, Point2D> {

	@Override
	public Point2D transform(IVertex vertex) {
		return vertex.getLocation();
	}

}
