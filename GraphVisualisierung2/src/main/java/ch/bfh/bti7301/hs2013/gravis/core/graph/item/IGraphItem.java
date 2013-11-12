package ch.bfh.bti7301.hs2013.gravis.core.graph.item;

import java.awt.Color;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IGraphItem extends IRestrictedGraphItem {

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
	
}