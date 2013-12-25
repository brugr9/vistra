package vistra.core.graph.item;

/**
 * An interface for an item state handler. An item state handler has a cellar at
 * it's disposal and is therefore able to hold the state history.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IItemStateHandler {

	/**
	 * Handles setting the previous state as getting it from the state cellar.
	 * 
	 * @throws Exception
	 */
	abstract void handleSetPreviousState() throws Exception;

}
