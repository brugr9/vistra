package vistra.core.zobsolete.graph.item.edge;

import vistra.core.zobsolete.graph.item.IGraphItem;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public interface IEdge extends IGraphItem, IRestrictedEdge {

	/**
	 * 
	 * @param weight
	 */
	public abstract void setWeight(double weight);

}
