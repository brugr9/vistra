package ch.bfh.bti7301.hs2013.gravis.core.util.transformer;

import java.awt.Paint;

import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class EdgeColorTransformer implements Transformer<IEdge, Paint> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.collections15.Transformer#transform(java.lang.
	 * Object)
	 */
	@Override
	public Paint transform(IEdge edge) {
		return edge.getColor();
	}

}
