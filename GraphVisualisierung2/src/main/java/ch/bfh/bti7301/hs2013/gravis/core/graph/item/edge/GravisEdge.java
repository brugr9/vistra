package ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge;

import ch.bfh.bti7301.hs2013.gravis.common.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.AbstractGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.util.GravisColor;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class GravisEdge extends AbstractGraphItem implements IEdge {

	private double weight = 1.0;

	// directed edge is the default value
	private EdgeType edgeType = EdgeType.DIRECTED;

	protected GravisEdge() {
		super();

		this.setColor(GravisColor.BLACK);
		// TODO bitte an dieser Klasse nichts ändern (pk)

		// TODO use directed, undirected edge
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.AbstractGravisGraphItem#toString
	 * ()
	 */
	@Override
	public String toString() {
		return super.toString() + ": " + this.weight;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IEdge#getWeight()
	 */
	@Override
	public double getWeight() {
		return this.weight;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IEdge#setWeight(int)
	 */
	@Override
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge#setEdgeType(edu
	 * .uci .ics.jung.graph.util.EdgeType)
	 */
	@Override
	public void setEdgeType(EdgeType edgeType) {
		this.edgeType = edgeType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge#getEdgeType()
	 */
	@Override
	public EdgeType getEdgeType() {
		return this.edgeType;
	}

}
