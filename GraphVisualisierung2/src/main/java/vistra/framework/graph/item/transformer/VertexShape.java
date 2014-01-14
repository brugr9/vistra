package vistra.framework.graph.item.transformer;

import java.awt.Shape;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.ILayoutVertex;
import vistra.framework.util.palette.ShapePalette;

/**
 * A vertex transformer: shape.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexShape implements Transformer<ILayoutVertex, Shape> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Shape transform(ILayoutVertex vertex) {
		return ShapePalette.shapeDefault;
	}

}
