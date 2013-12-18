package vistra.core.graph.item.edge;

import vistra.core.graph.item.AbstractGraphItem;
import vistra.core.util.GraphPropertyConstants;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class GravisEdge extends AbstractGraphItem implements IEdge {

	private double weight;

	protected GravisEdge() {
		super();

		this.weight = GraphPropertyConstants.E_WEIGHT_DEFAULT;
		this.setCurrentColor(GraphPropertyConstants.E_COLOR_DEFAULT);
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
		;
		return super.toString();
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
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.AbstractGraphItem#clone()
	 */
	@Override
	public GravisEdge clone() throws CloneNotSupportedException {
		return (GravisEdge) super.clone();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.item.AbstractGraphItem#
	 * getItemStrokeWidth()
	 */
	@Override
	protected float getDefaultStrokeWidth() {
		return GraphPropertyConstants.E_TAGGED_STROKE;
	}

}