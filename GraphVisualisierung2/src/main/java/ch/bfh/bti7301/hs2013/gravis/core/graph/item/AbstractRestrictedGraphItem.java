package ch.bfh.bti7301.hs2013.gravis.core.graph.item;

import java.awt.Color;

import ch.bfh.bti7301.hs2013.gravis.common.IGraphItem;

/**
 * An restricted item.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public abstract class AbstractRestrictedGraphItem implements IGraphItem {

	// TODO bitte an dieser Klasse nichts ändern (pk)

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
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#getName()
	 */
	@Override
	public String getName() {
		return this.item.getName();
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#isVisited()
	 */
	@Override
	public boolean isVisited() {
		return this.item.isVisited();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#setVisited(boolean )
	 */
	@Override
	public void setVisited(boolean value) {
		this.item.setVisited(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#setState(ch.bfh
	 * .bti7301.hs2013.gravis.core.graph.item.IGraphItem.ItemState)
	 */
	@Override
	public void setState(State state) {
		this.item.setState(state);
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
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#setId(java.lang
	 * .String)
	 */
	@Override
	public void setId(String id) {
		// TODO Exception handling
		throw new UnsupportedOperationException("setId: Unsupported operation!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#setInfo(java.
	 * lang.String)
	 */
	@Override
	public void setInfo(String info) {
		// TODO Exception handling
		throw new UnsupportedOperationException(
				"setInfo: Unsupported operation!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#setColor(java
	 * .awt.Color)
	 */
	@Override
	public void setColor(Color color) {
		// TODO Exception handling
		throw new UnsupportedOperationException(
				"setColor: Unsupported operation!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem#setName(java.
	 * lang.String)
	 */
	@Override
	public void setName(String name) {
		// TODO Exception handling
		throw new UnsupportedOperationException(
				"setName: Unsupported operation!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.common.IGraphItem#setPaintedResult(double)
	 */
	@Override
	public void setPaintedResult(double result) {
		// TODO Exception handling
		throw new UnsupportedOperationException(
				"setPaintedResult: Unsupported operation!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return this.item.equals(obj);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return this.item.hashCode();
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
