package travis.core.graph.item;

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
	public abstract void setCurrentResult(double result);
	
	/**
	 * 
	 * @param id
	 */
	public abstract void setId(String id);

	/**
	 * 
	 * @param currentColor
	 */
	public abstract void setCurrentColor(Color currentColor);
	
	/**
	 * 
	 * @param newColor
	 */
	public abstract void setNewColor(Color newColor);
	
	/**
	 * 
	 * @return Color
	 */
	public abstract Color getNewColor();

	public abstract void resetVisualizationValues();

	/**
	 * @return boolean
	 */
	public abstract boolean hasNoResult();

	/**
	 * 
	 * @param currentState
	 */
	public abstract void setCurrentState(State currentState);
	
	/**
	 * @return float
	 */
	public abstract float getCurrentStrokeWidth();
	
	/**
	 * 
	 * @param width
	 */
	public abstract void setCurrentStrokeWidth(float width);
	
	/**
	 * @return float
	 */
	public abstract float getNewStrokeWidth();
	
	/**
	 * 
	 * @param width
	 */
	public abstract void setNewStrokeWidth(float width);
	
	/**
	 * 
	 * @return clone
	 * @throws CloneNotSupportedException
	 */
	public IGraphItem clone() throws CloneNotSupportedException;
}