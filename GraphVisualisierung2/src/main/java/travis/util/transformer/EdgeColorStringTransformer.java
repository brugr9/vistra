package travis.util.transformer;

import org.apache.commons.collections15.Transformer;

import travis.core.graph.item.edge.IEdge;


/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public class EdgeColorStringTransformer implements Transformer<IEdge, String> {

	/* (non-Javadoc)
	 * @see org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public String transform(IEdge edge) {
		return ValueTransformer.transformColorToString(edge.getCurrentColor());
	}

}
