package vistra.core.graph.item.edge;

import vistra.core.graph.item.AbstractGraphItem;

/**
 * An abstract edge layout.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
abstract class AbstractEdgeLayout extends AbstractGraphItem implements
		IEdgeLayout {

	/**
	 * Main constructor.
	 * 
	 * @param value
	 *            a value
	 */
	AbstractEdgeLayout(double value) {
		super(value);
	}

}
