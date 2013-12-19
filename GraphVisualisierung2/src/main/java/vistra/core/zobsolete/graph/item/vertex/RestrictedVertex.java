package vistra.core.zobsolete.graph.item.vertex;

import java.awt.geom.Point2D;

import vistra.core.zobsolete.graph.item.AbstractRestrictedGraphItem;


/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
final class RestrictedVertex extends AbstractRestrictedGraphItem
		implements IRestrictedVertex {

	private IVertex vertex;

	protected RestrictedVertex(IVertex vertex) {
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

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex#getWidth()
	 */
	@Override
	public double getWidth() {
		return this.vertex.getWidth();
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex#getHeight()
	 */
	@Override
	public double getHeight() {
		return this.vertex.getHeight();
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex#getLocation()
	 */
	@Override
	public Point2D getLocation() {
		return this.vertex.getLocation();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.vertex.toString();
	}

	
}
