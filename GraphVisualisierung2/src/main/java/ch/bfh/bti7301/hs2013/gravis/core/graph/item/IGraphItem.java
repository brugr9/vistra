package ch.bfh.bti7301.hs2013.gravis.core.graph.item;

import java.awt.Color;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IGraphItem {

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
	 * @return name as String
	 */
	public abstract String getName();

	/**
	 * 
	 * @param id
	 */
	public abstract void setId(String id);

	/**
	 * 
	 * @param info
	 */
	public abstract void setInfo(String info);

	/**
	 * 
	 * @param color
	 */
	public abstract void setColor(Color color);

	/**
	 * 
	 * @param name
	 */
	public abstract void setName(String name);

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
	 * @return boolean
	 */
	public abstract boolean isVisited();

	/**
	 * 
	 * @param value
	 */
	public abstract void setVisited(boolean value);

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

	/**
	 * 
	 * @return double
	 */
	public abstract double getPaintedResult();

	/**
	 * 
	 * @param result
	 */
	public abstract void setPaintedResult(double result);

}