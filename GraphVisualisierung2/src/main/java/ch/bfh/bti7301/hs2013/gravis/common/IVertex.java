package ch.bfh.bti7301.hs2013.gravis.common;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IVertex extends IGraphItem {

	/**
	 * Returns <code>true</code> if this is a start.
	 * 
	 * @return <code>true</code> if this is a start
	 */
	public abstract boolean isStart();

	/**
	 * Returns <code>true</code> if this is an end.
	 * 
	 * @return Returns <code>true</code> if this is an end.
	 */
	public abstract boolean isEnd();

	/**
	 * Returns the shape.
	 * 
	 * @return the shape
	 */
	public abstract String getShape();

	/**
	 * Sets the shape.
	 * 
	 * @param shape
	 *            the shape to set
	 */
	public abstract void setShape(String shape);

	/**
	 * Sets the start.
	 * 
	 * @param start
	 *            the start to set
	 */
	public abstract void setStart(boolean start);

	/**
	 * Sets the end.
	 * 
	 * @param end
	 *            the end to set
	 */
	public abstract void setEnd(boolean end);
}
