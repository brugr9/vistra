package ch.bfh.bti7301.hs2013.gravis.core.util.transformer;

import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.core.graph.GraphFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.io.graphml.GraphMetadata;
import edu.uci.ics.jung.io.graphml.GraphMetadata.EdgeDefault;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public class GraphTransformer implements Transformer<GraphMetadata, IGravisGraph> {

	private final static String DESCRIPTION_PROPERTY = "description";
	
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
		
		if (graphMeta.getProperty(DESCRIPTION_PROPERTY) != null) {
			newGraph.setDescription(graphMeta.getProperty(DESCRIPTION_PROPERTY)
					.trim());
		}
		
		return newGraph;
	}

}
