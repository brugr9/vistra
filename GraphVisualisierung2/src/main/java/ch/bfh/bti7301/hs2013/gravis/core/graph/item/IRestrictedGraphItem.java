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
		INITIAL, ACTIVATION, VISIT, SOLUTION
	}

	/**
	 * 
	 * @return String id
	 */
	public abstract String getId();

	/**
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
	 * @param state
	 */
	public abstract void setState(State state);

	/**
	 * 
	 * @return State
	 */
	public abstract State getState();

}
