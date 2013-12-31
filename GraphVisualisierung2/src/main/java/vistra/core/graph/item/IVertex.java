package vistra.core.graph.item;

/**
 * A vertex interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IVertex extends IItem {

	/**
	 * Returns the start.
	 * 
	 * @return the start
	 */
	boolean isStart();

	/**
	 * Returns the end.
	 * 
	 * @return the end
	 */
	boolean isEnd();

	/**
	 * Returns a value.
	 * 
	 * @return the value
	 */
	String getValue();

}