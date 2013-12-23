package vistra.core.graph.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.IExtendedGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.io.graphml.GraphMetadata;
import edu.uci.ics.jung.io.graphml.GraphMetadata.EdgeDefault;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class GraphTransformer implements
		Transformer<GraphMetadata, IExtendedGraph> {

	@Override
	public IExtendedGraph transform(GraphMetadata graphMeta) {
		IExtendedGraph newGraph = GraphFactory.create(EdgeType.UNDIRECTED);
		newGraph.setName(graphMeta.getId());
		EdgeType edgeType = graphMeta.getEdgeDefault() == EdgeDefault.UNDIRECTED ? EdgeType.UNDIRECTED
				: EdgeType.DIRECTED;
		newGraph.setEdgeType(edgeType);

		return newGraph;
	}

}
