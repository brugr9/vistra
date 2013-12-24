package vistra.core.graph.item.edge;

import vistra.core.graph.item.IItem;

/**
 * An edge layout interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IEdgeLayout extends IItem {

	/**
	 * Returns an array of float representing a dash pattern (null means solid).
	 * 
	 * @return the dash pattern
	 */
	abstract float[] getDash();

	/**
	 * Sets an array of float representing a dash pattern (null means solid).
	 * 
	 * @param dash
	 *            the dash pattern
	 */
	abstract void setDash(float[] dash);

}
