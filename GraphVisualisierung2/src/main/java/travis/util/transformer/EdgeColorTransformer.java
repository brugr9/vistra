package travis.util.transformer;

import java.awt.Paint;

import org.apache.commons.collections15.Transformer;

import travis.core.graph.item.edge.IEdge;


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
		return edge.getCurrentColor();
	}

}
