package ch.bfh.bti7301.hs2013.gravis.core.graph.item;

import java.awt.Color;

/**
 * An restricted item.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public abstract class AbstractRestrictedGraphItem implements IRestrictedGraphItem {

	/**
	 * A field for an item.
	 */
	private final IGraphItem item;

	/**
	 * Main constructor.
	 * 
	 * @param item
	 *            the item
	 */
	protected AbstractRestrictedGraphItem(final IGraphItem item) {
		this.item = item;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#getId()
	 */
	@Override
	public String getId() {
		return this.item.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#getInfo()
	 */
	@Override
	public String getInfo() {
		return this.item.getInfo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#getColor()
	 */
	@Override
	public Color getColor() {
		return this.item.getColor();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#getComment()
	 */
	@Override
	public String getComment() {
		return this.item.getComment();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#setComment(java
	 * .lang.String)
	 */
	@Override
	public void setComment(String comment) {
		this.item.setComment(comment);
	}

	
	
	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#appendComment(java.lang.String)
	 */
	@Override
	public void appendComment(String comment) {
		this.item.appendComment(comment);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#isVisited()
	 */
	@Override
	public boolean isDone() {
		return this.item.isDone();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#setVisited(boolean )
	 */
	@Override
	public void setDone(boolean value) {
		this.item.setDone(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#getState()
	 */
	@Override
	public State getState() {
		return this.item.getState();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#getTempResult()
	 */
	@Override
	public double getResult() {
		return this.item.getResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#setTempResult
	 * (double)
	 */
	@Override
	public void setResult(double value) {
		this.item.setResult(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.item.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.common.IGraphItem#getPaintedResult()
	 */
	@Override
	public double getPaintedResult() {
		return this.item.getPaintedResult();
	}

}
