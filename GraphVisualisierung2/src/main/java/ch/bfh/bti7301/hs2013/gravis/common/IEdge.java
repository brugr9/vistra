package ch.bfh.bti7301.hs2013.gravis.common;

import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public interface IEdge extends IGraphItem {

	/**
	 * 
	 * @return double weight
	 */
	public abstract double getWeight();

	/**
	 * 
	 * @return EdgeType
	 */
	public abstract EdgeType getEdgeType();

	/**
	 * 
	 * @param weight
	 */
	public abstract void setWeight(double weight);

	/**
	 * @param edgeType
	 */
	public abstract void setEdgeType(EdgeType edgeType);

}
