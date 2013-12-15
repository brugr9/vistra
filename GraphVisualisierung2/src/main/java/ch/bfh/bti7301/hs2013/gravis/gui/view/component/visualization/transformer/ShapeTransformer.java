package ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.transformer;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class ShapeTransformer implements Transformer<IVertex, Shape> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public Shape transform(IVertex vertex) {
		return new Ellipse2D.Double(-vertex.getWidth() / 2.0,
				-vertex.getWidth() / 2.0, vertex.getWidth(), vertex.getHeight());
	}

}
