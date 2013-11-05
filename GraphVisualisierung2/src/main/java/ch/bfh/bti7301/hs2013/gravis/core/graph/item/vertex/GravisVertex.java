package ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex;

import ch.bfh.bti7301.hs2013.gravis.common.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.AbstractGraphItem;

/**
 * A vertex.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class GravisVertex extends AbstractGraphItem implements IVertex {

	/**
	 * A field for the start status.
	 */
	private boolean start;
	/**
	 * A field for the end status.
	 */
	private boolean end;
	/**
	 * A field for a shape.
	 */
	private String shape;

	/**
	 * Main constructor setting start and end to false both by default.
	 */
	protected GravisVertex() {
		super();
		this.start = false;
		this.end = false;
		this.shape = "";
	}

	@Override
	public boolean isStart() {
		return this.start;
	}

	@Override
	public boolean isEnd() {
		return this.end;
	}

	@Override
	public String getShape() {
		return this.shape;
	}

	@Override
	public void setStart(boolean start) {
		this.start = start;
	}

	@Override
	public void setEnd(boolean end) {
		this.end = end;
	}

	@Override
	public void setShape(String shape) {
		this.shape = shape;
	}

}
