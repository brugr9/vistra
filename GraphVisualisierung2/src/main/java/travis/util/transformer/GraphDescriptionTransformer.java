package travis.util.transformer;

import org.apache.commons.collections15.Transformer;

import travis.core.graph.IGravisGraph;
import travis.core.graph.item.edge.IEdge;
import travis.core.graph.item.vertex.IVertex;

import edu.uci.ics.jung.graph.Hypergraph;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public class GraphDescriptionTransformer implements
		Transformer<Hypergraph<IVertex, IEdge>, String> {

	/* (non-Javadoc)
	 * @see org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public String transform(Hypergraph<IVertex, IEdge> graph) {
		if (graph instanceof IGravisGraph) {
			return ((IGravisGraph) graph).getDescription();
		}
		return "";
	}

}
