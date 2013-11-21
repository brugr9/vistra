package ch.bfh.bti7301.hs2013.gravis.core.graph.item;

import java.awt.Color;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IGraphItem extends IRestrictedGraphItem, Cloneable {

	/**
	 * 
	 * @param result
	 */
	public abstract void setPaintedResult(double result);
	
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

	public abstract void resetVisualizationValues();

	/**
	 * @return boolean
	 */
	public abstract boolean hasNoResult();

	/**
	 * @return boolean
	 */
	public abstract boolean hasNoComment();
	
	/**
	 * 
	 * @param state
	 */
	public abstract void setState(State state);
	
	/**
	 * @return
	 */
	public abstract float getStrokeWidth();
	
	/**
	 * 
	 * @param width
	 */
	public abstract void setStrokeWidth(float width);
	
	/**
	 * 
	 * @return clone
	 * @throws CloneNotSupportedException
	 */
	public Object clone() throws CloneNotSupportedException;
}