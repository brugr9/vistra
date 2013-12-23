package vistra.core.graph.item;

/**
 * An interface for an item state handler.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IItemStateHandler {

	/**
	 * Handles previous.
	 * 
	 * @throws Exception
	 */
	abstract void handlePrevious() throws Exception;

}
