package vistra.framework.graph.item;

/**
 * A graph item interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IItem {

	/**
	 * Returns {@code true} if visited.
	 *
	 * @return {@code true} if visited
	 */
	public boolean isVisited();

	/**
	 * Returns {@code true} if unexplored.
	 *
	 * @return {@code true} if unexplored
	 */
	public boolean isUnexplored();

}
