package travis.core.graph.item.edge;

import travis.core.graph.item.IGraphItem;

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
