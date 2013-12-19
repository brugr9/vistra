package vistra.util.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.zobsolete.graph.item.edge.EdgeFactory;
import vistra.core.zobsolete.graph.item.edge.IEdge;
import vistra.core.zobsolete.graph.util.GraphPropertyConstants;
import edu.uci.ics.jung.io.graphml.EdgeMetadata;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class EdgeTransformer implements Transformer<EdgeMetadata, IEdge> {

	private final EdgeFactory edgeFactory;

	public EdgeTransformer() {
		this.edgeFactory = new EdgeFactory();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public IEdge transform(EdgeMetadata edgeMeta) {
		IEdge edge = this.edgeFactory.create();

		edge.setId(edgeMeta.getId());
		edge.setCurrentColor(ValueTransformer.transformStringToColor(edgeMeta
				.getProperty(GraphPropertyConstants.E_COLOR)));
		edge.setWeight(ValueTransformer.transformDouble(edgeMeta
				.getProperty(GraphPropertyConstants.E_WEIGHT)));
		return edge;
	}

}
