package vistra.core.graph.item.edge;

import vistra.core.graph.item.IRestrictedGraphItem;

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
