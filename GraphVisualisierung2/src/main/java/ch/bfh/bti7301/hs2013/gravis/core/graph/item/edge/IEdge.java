package ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;

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
