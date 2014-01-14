package vistra.framework.graph.ml;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.ILayoutEdge;

/**
 * A transformer for writing a GraphML file: edge weight.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeWeight implements Transformer<ILayoutEdge, String> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String transform(ILayoutEdge edge) {
		return Integer.toString(edge.getWeight());
	}

}
