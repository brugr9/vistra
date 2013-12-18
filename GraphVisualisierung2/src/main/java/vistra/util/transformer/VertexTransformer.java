package vistra.util.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.vertex.IVertex;
import vistra.core.graph.item.vertex.VertexFactory;
import vistra.core.util.GraphPropertyConstants;

import edu.uci.ics.jung.io.graphml.NodeMetadata;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public class VertexTransformer implements Transformer<NodeMetadata, IVertex> {

	private final VertexFactory vertexFactory;
	
	public VertexTransformer() {
		this.vertexFactory = new VertexFactory();
	}
	
	/* (non-Javadoc)
	 * @see org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public IVertex transform(NodeMetadata vertexMeta) {
		IVertex vertex = this.vertexFactory.create();

		vertex.setId(vertexMeta.getId());
		vertex.setCurrentColor(ValueTransformer.transformStringToColor(vertexMeta
				.getProperty(GraphPropertyConstants.V_COLOR)));
		
		vertex.setLocation(ValueTransformer.transformLocation(vertexMeta
				.getProperty(GraphPropertyConstants.V_LOC_X), vertexMeta
				.getProperty(GraphPropertyConstants.V_LOC_Y)));
		vertex.setStart(ValueTransformer.transformBoolean(vertexMeta
				.getProperty(GraphPropertyConstants.V_START)));
		vertex.setEnd(ValueTransformer.transformBoolean(vertexMeta
				.getProperty(GraphPropertyConstants.V_END)));
		vertex.setWidth(ValueTransformer.transformDouble(vertexMeta
				.getProperty(GraphPropertyConstants.V_WIDTH)));
		vertex.setHeight(ValueTransformer.transformDouble(vertexMeta
				.getProperty(GraphPropertyConstants.V_HEIGHT)));
		
		return vertex;
	}

}
