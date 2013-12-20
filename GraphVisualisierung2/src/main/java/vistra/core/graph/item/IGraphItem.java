package vistra.core.graph.item;

/**
 * A graph item.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IGraphItem {

	/**
	 * Sets an identifier.
	 * 
	 * @param id
	 *            the identifier to set
	 */
	abstract void setId(String id);

	/**
	 * Returns an identifier.
	 * 
	 * @return the identifier
	 */
	abstract String getId();

}
