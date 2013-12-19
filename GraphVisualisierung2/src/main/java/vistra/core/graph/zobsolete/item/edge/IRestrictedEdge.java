package vistra.core.graph.zobsolete.item.edge;

import vistra.core.graph.zobsolete.item.IRestrictedGraphItem;

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
