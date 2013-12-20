package vistra.core.graph.item;

/**
 * An abstract graph item.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public abstract class AbstractGraphItem implements IGraphItem {

	/**
	 * A field for an identifier.
	 */
	private String id;

	public AbstractGraphItem() {
		this.id = "";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return this.id;
	}

}
