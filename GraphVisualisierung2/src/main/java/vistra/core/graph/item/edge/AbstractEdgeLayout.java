package vistra.core.graph.item.edge;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.item.AbstractItem;

/**
 * An abstract edge layout.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
abstract class AbstractEdgeLayout extends AbstractItem implements IEdgeLayout {

	/**
	 * A field for a dash.
	 */
	private float[] dash;

	/**
	 * Main constructor.
	 * 
	 * @param value
	 *            a value
	 */
	AbstractEdgeLayout(int value) {
		super(value);
		this.dash = GraphFactory.E_SOLID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public float[] getDash() {
		return dash;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDash(float[] dash) {
		this.dash = dash;
	}

}
