package vistra.framework.graph.ml;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.GraphFactory;
import vistra.framework.graph.IExtendedGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.io.graphml.GraphMetadata;
import edu.uci.ics.jung.io.graphml.GraphMetadata.EdgeDefault;

/**
 * A graph transformer for reading an extended GraphML file.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class GraphTransformer implements
		Transformer<GraphMetadata, IExtendedGraph> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IExtendedGraph transform(GraphMetadata meta) {
		EdgeType edgeType = meta.getEdgeDefault() == EdgeDefault.UNDIRECTED ? EdgeType.UNDIRECTED
				: EdgeType.DIRECTED;
		IExtendedGraph graph = GraphFactory.create(edgeType);
		return graph;
	}

}
