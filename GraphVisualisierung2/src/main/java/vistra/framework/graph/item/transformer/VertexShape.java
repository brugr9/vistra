package vistra.framework.graph.item.transformer;

import java.awt.Shape;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.IVertexLayout;
import vistra.framework.util.ShapePalette;

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
		return ShapePalette.shapeDefault;
	}

}
