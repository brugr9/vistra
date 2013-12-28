package vistra.core.graph.ml;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.IExtendedGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.io.graphml.GraphMetadata;
import edu.uci.ics.jung.io.graphml.GraphMetadata.EdgeDefault;

/**
 * An graph metadata transformer for reading an extended GraphML file.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class GraphMetadataTransformer implements
		Transformer<GraphMetadata, IExtendedGraph> {

	@Override
	public IExtendedGraph transform(GraphMetadata meta) {
		IExtendedGraph graph = GraphFactory.createGraph();
		graph.setName(meta.getId());
		EdgeType edgeType = meta.getEdgeDefault() == EdgeDefault.UNDIRECTED ? EdgeType.UNDIRECTED
				: EdgeType.DIRECTED;
		graph.setEdgeType(edgeType);
		return graph;
	}

}
