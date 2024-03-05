package vistra.framework.graph.item;

import java.util.Observable;

/**
 * A graph item.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class Item extends Observable implements IItem {

	/**
	 * A field for a visited value.
	 */
	boolean visited;

	/**
	 * Main constructor.
	 * 
	 */
	Item() {
		this.visited = false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isVisited() {
		return this.visited;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isUnexplored() {
		return !this.visited;
	}

}
