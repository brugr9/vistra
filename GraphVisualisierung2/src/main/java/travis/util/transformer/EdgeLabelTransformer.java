package travis.util.transformer;

import org.apache.commons.collections15.Transformer;

import travis.core.graph.item.edge.IEdge;


/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public class EdgeLabelTransformer implements Transformer<IEdge, String> {

	/* (non-Javadoc)
	 * @see org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public String transform(IEdge edge) {
		return edge.isVisible() ? (edge.getWeight()
				+ (Double.isNaN(edge.getCurrentResult()) ? "" : " | "
						+ ValueTransformer.round2Decimals(
								edge.getCurrentResult()))) : "";
	}

}
