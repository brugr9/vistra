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
	 * Returns the distance.
	 * <ul>
	 * <li>If the vertex is initialized (infinity), {@code Integer.MAX_VALUE}
	 * will be returned.
	 * <li>If the vertex is not yet initialized (value == ""), {@code null} will
	 * be returned.
	 * 
	 * @return the distance
	 */
	Integer getDistance();

	/**
	 * Returns {@code true} if initialized.
	 * 
	 * @return {@code true} if initialized
	 */
	boolean isInitialized();

	/**
	 * Returns {@code true} if visited.
	 * 
	 * @return {@code true} if visited
	 */
	public boolean isVisited();

}