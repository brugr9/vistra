package ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex;

import java.awt.geom.Point2D;

import ch.bfh.bti7301.hs2013.gravis.common.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.AbstractRestrictedGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
final class RestrictedGravisVertex extends AbstractRestrictedGraphItem
		implements IVertex {

	// TODO bitte an dieser Klasse nichts ändern (pk)

	private IVertex vertex;

	protected RestrictedGravisVertex(IVertex vertex) {
		super(vertex);
		this.vertex = vertex;
	}

	@Override
	public boolean isStart() {
		return this.vertex.isStart();
	}

	@Override
	public boolean isEnd() {
		return this.vertex.isEnd();
	}

	@Override
	public String getShape() {
		return this.vertex.getShape();
	}

	@Override
	public void setShape(String shape) {
		// TODO: handle exception
		throw new UnsupportedOperationException(
				"setShape: Unsupported operation!");
	}

	@Override
	public void setStart(boolean start) {
		// TODO: handle exception
		throw new UnsupportedOperationException(
				"setStart: Unsupported operation!");
	}

	@Override
	public void setEnd(boolean end) {
		// TODO: handle exception
		throw new UnsupportedOperationException(
				"setEnd: Unsupported operation!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.common.IVertex#getLocation()
	 */
	@Override
	public Point2D getLocation() {
		// TODO: handle exception
		throw new UnsupportedOperationException(
				"getLocation: Unsupported operation!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.common.IVertex#setLocation(java.awt.geom
	 * .Point2D)
	 */
	@Override
	public void setLocation(Point2D location) {
		// TODO: handle exception
		throw new UnsupportedOperationException(
				"setLocation: Unsupported operation!");
	}
}
