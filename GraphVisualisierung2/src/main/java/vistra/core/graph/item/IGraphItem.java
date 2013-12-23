package vistra.core.graph.item;

/**
 * A graph item interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IGraphItem extends IGraphItemLayout {

	/**
	 * Returns an identifier.
	 * 
	 * @return the identifier
	 */
	abstract String getId();

	/**
	 * Sets an identifier.
	 * 
	 * @param id
	 *            the identifier to set
	 */
	abstract void setId(String id);

	/**
	 * Returns an value.
	 * 
	 * @return the value
	 */
	public double getValue();

	/**
	 * Sets a value.
	 * 
	 * @param value
	 *            the value to set
	 */
	public void setValue(double value);


}
