package vistra.core.graph.item.edge;

import vistra.core.graph.item.AbstractItem;

/**
 * An abstract edge layout.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
abstract class AbstractEdgeLayout extends AbstractItem implements IEdgeLayout {

	/**
	 * Main constructor.
	 * 
	 * @param value
	 *            a value
	 */
	AbstractEdgeLayout(int value) {
		super(value);
	}

}
