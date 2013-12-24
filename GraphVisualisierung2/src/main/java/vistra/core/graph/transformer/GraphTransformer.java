package vistra.core.graph.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.IGraphLayout;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.io.graphml.GraphMetadata;
import edu.uci.ics.jung.io.graphml.GraphMetadata.EdgeDefault;

/**
 * An graph transformer for reading a GraphML file.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class GraphTransformer implements
		Transformer<GraphMetadata, IGraphLayout> {

	@Override
	public IGraphLayout transform(GraphMetadata graphMeta) {
		IGraphLayout graph = GraphFactory.createGraph();
		graph.setName(graphMeta.getId());
		EdgeType edgeType = graphMeta.getEdgeDefault() == EdgeDefault.UNDIRECTED ? EdgeType.UNDIRECTED
				: EdgeType.DIRECTED;
		graph.setEdgeType(edgeType);

		return graph;
	}

}
