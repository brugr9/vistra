package travis.core.graph.item.edge;

import travis.core.graph.item.IRestrictedGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public interface IRestrictedEdge extends IRestrictedGraphItem {

	/**
	 * 
	 * @return double weight
	 */
	public abstract double getWeight();
	
}
