package vistra.framework.graph.ml;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.GraphFactory;
import vistra.framework.graph.ILayoutGraph;
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
		Transformer<GraphMetadata, ILayoutGraph> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ILayoutGraph transform(GraphMetadata meta) {
		EdgeType edgeType = meta.getEdgeDefault() == EdgeDefault.UNDIRECTED ? EdgeType.UNDIRECTED
				: EdgeType.DIRECTED;
		ILayoutGraph graph = GraphFactory.create(edgeType);
		return graph;
	}

}
