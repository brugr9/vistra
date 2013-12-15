package ch.bfh.bti7301.hs2013.gravis.util.transformer;

import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public class EdgeWeightNumberTransformer implements Transformer<IRestrictedEdge, Number> {

	/* (non-Javadoc)
	 * @see org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public Number transform(IRestrictedEdge edge) {
		return edge.getWeight();
	}

}
