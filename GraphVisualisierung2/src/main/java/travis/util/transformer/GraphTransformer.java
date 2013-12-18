package travis.util.transformer;

import org.apache.commons.collections15.Transformer;

import travis.core.graph.GraphFactory;
import travis.core.graph.IGravisGraph;
import travis.core.util.GraphPropertyConstants;

import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.io.graphml.GraphMetadata;
import edu.uci.ics.jung.io.graphml.GraphMetadata.EdgeDefault;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public class GraphTransformer implements Transformer<GraphMetadata, IGravisGraph> {

	/* (non-Javadoc)
	 * @see org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public IGravisGraph transform(GraphMetadata graphMeta) {
		IGravisGraph newGraph = GraphFactory.createIGravisGraph();
		EdgeType edgeType = graphMeta.getEdgeDefault() == EdgeDefault.DIRECTED ? 
				EdgeType.DIRECTED : EdgeType.UNDIRECTED;
		
		newGraph.setId(graphMeta.getId());
		newGraph.setEdgeType(edgeType);
		
		if (graphMeta.getProperty(GraphPropertyConstants.G_DESCRIPTION) != null) {
			newGraph.setDescription(graphMeta.getProperty(GraphPropertyConstants.G_DESCRIPTION)
					.trim());
		}
		
		return newGraph;
	}

}
