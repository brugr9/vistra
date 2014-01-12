package vistra.framework.graph.item;

/**
 * A vertex interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IVertex extends IItem {

	/**
	 * Returns {@code true} if this vertex is set as the start.
	 * 
	 * @return {@code true} if this vertex is set as the start
	 */
	boolean isStart();

	/**
	 * Returns {@code true} if this vertex is set as the end.
	 * 
	 * @return {@code true} if this vertex is set as the end
	 */
	boolean isEnd();

	/**
	 * Returns the value. If the vertex is initialized, the sign for infinity
	 * will be returned ( {@code SigmaPalette.infinity}). If the vertex is
	 * whether initialized nor holding a value, an empty string will be
	 * returned.
	 * 
	 * @return the value
	 */
	String getValue();

}