package vistra.core.graph.item;

import java.awt.Color;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public interface IRestrictedGraphItem {

	/**
	 * 
	 * @author Patrick Kofmel (kofmp1@bfh.ch)
	 * 
	 */
	public static enum State {
		INITIAL, ACTIVATION, VISIT, SOLUTION;
	}

	/**
	 * 
	 * @return String id
	 */
	public abstract String getId();

	/**
	 * 
	 * @return current color
	 */
	public abstract Color getCurrentColor();

	/**
	 * The current result of this item.
	 * 
	 * @return double
	 */
	public abstract double getCurrentResult();

	/**
	 * 
	 * @return double value
	 */
	public abstract double getNewResult();

	/**
	 * 
	 * @param value
	 */
	public abstract void setNewResult(double value);

	/**
	 * 
	 * @return comment
	 */
	public abstract String getNewComment();

	/**
	 * 
	 * @param newComment
	 */
	public abstract void setNewComment(String newComment);

	/**
	 * @param comment
	 */
	public abstract void appendToNewComment(String comment);

	/**
	 * @return boolean
	 */
	public abstract boolean isDone();

	/**
	 * 
	 * @param value
	 */
	public abstract void setDone(boolean value);

	/**
	 * 
	 * @return State
	 */
	public abstract State getCurrentState();

	/**
	 * 
	 * @return State
	 */
	public abstract State getNewState();

	/**
	 * 
	 * @param newState
	 */
	public abstract void setNewState(State newState);

	/**
	 * 
	 * @return State
	 */
	public abstract Object getValue();

	/**
	 * 
	 * @param value
	 */
	public abstract void setValue(Object value);

	/**
	 * 
	 * @param visible
	 */
	public abstract void setVisible(boolean visible);

	/**
	 * 
	 * @return boolean
	 */
	public abstract boolean isVisible();

	/**
	 * 
	 * @param tagged
	 */
	public abstract void setTagged(boolean tagged);

	/**
	 * 
	 * @return boolean
	 */
	public abstract boolean isTagged();

	/**
	 * @param value
	 */
	public abstract void setStateCommentEnabled(boolean value);

	/**
	 * 
	 * @return boolean
	 */
	public abstract boolean isStateCommentEnabled();
}
