package ch.bfh.bti7301.hs2013.gravis.core.graph.item;

import java.awt.Color;

/**
 * An restricted item.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public abstract class AbstractRestrictedGraphItem implements
		IRestrictedGraphItem {

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
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#getColor()
	 */
	@Override
	public Color getCurrentColor() {
		return this.item.getCurrentColor();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#getComment()
	 */
	@Override
	public String getNewComment() {
		return this.item.getNewComment();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#setComment(java
	 * .lang.String)
	 */
	@Override
	public void setNewComment(String comment) {
		this.item.setNewComment(comment);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#
	 * appendComment(java.lang.String)
	 */
	@Override
	public void appendToNewComment(String comment) {
		this.item.appendToNewComment(comment);
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
	public State getCurrentState() {
		return this.item.getCurrentState();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#
	 * getTraversalState()
	 */
	@Override
	public State getNewState() {
		return this.item.getNewState();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#
	 * setTraversalState
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem.State)
	 */
	@Override
	public void setNewState(State traversalState) {
		this.item.setNewState(traversalState);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#getTempResult()
	 */
	@Override
	public double getNewResult() {
		return this.item.getNewResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#setTempResult
	 * (double)
	 */
	@Override
	public void setNewResult(double value) {
		this.item.setNewResult(value);
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
	public double getCurrentResult() {
		return this.item.getCurrentResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#getValue
	 * ()
	 */
	@Override
	public Object getValue() {
		return this.item.getValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#setValue
	 * (java.lang.Object)
	 */
	@Override
	public void setValue(Object value) {
		this.item.setValue(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#setVisible
	 * (boolean)
	 */
	@Override
	public void setVisible(boolean visible) {
		this.item.setVisible(visible);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#isVisible
	 * ()
	 */
	@Override
	public boolean isVisible() {
		return this.item.isVisible();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#setTagged
	 * (boolean)
	 */
	@Override
	public void setTagged(boolean tagged) {
		this.item.setTagged(tagged);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#isTagged
	 * ()
	 */
	@Override
	public boolean isTagged() {
		return this.item.isTagged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#
	 * setStateCommentEnabled(boolean)
	 */
	@Override
	public void setStateCommentEnabled(boolean value) {
		this.item.setStateCommentEnabled(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem#
	 * isStateCommentEnabled()
	 */
	@Override
	public boolean isStateCommentEnabled() {
		return this.item.isStateCommentEnabled();
	}

}
