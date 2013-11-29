package ch.bfh.bti7301.hs2013.gravis.core.graph.item;

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
	 * The last comment printed in the visualization.
	 * 
	 * @return String info
	 */
	public abstract String getInfo();

	/**
	 * 
	 * @return color
	 */
	public abstract Color getColor();

	/**
	 * The last result printed in the visualization.
	 * 
	 * @return double
	 */
	public abstract double getPaintedResult();
	
	/**
	 * 
	 * @return double value
	 */
	public abstract double getResult();

	/**
	 * 
	 * @param value
	 */
	public abstract void setResult(double value);

	/**
	 * 
	 * @return comment
	 */
	public abstract String getComment();

	/**
	 * 
	 * @param comment
	 */
	public abstract void setComment(String comment);

	/**
	 * @param comment
	 */
	public abstract void appendComment(String comment);
	
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
	public abstract State getState();
	
	/**
	 * 
	 * @return State
	 */
	public abstract State getTraversalState();
	
	/**
	 * 
	 * @param state
	 */
	public abstract void setTraversalState(State state);
	
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
	 * @param notTagged
	 */
	public abstract void setTagged(boolean tagged);
	
	/**
	 * 
	 * @return boolean
	 */
	public abstract boolean isTagged();

	
}
