package ch.bfh.bti7301.hs2013.gravis.core.util;

import java.awt.geom.Point2D;

import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class PointTransformer implements Transformer<IVertex, Point2D> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public Point2D transform(IVertex vertex) {
		return vertex.getLocation();
	}

}
