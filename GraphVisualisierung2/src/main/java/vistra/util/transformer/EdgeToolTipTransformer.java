package vistra.util.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.zobsolete.graph.item.edge.IEdge;


/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public class EdgeToolTipTransformer implements Transformer<IEdge, String> {

	/* (non-Javadoc)
	 * @see org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public String transform(IEdge edge) {
		return "Kante " + edge.getId();
	}

}
