package ch.bfh.bti7301.hs2013.gravis.core.util;

import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.VertexFactory;
import edu.uci.ics.jung.io.graphml.NodeMetadata;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public class VertexTransformer implements Transformer<NodeMetadata, IVertex> {

	private final static String VERTEX_COLOR_PROPERTY = "vertexColor";
	private final static String VERTEX_LOCATION_X_PROPERTY = "vertexLocation.x";
	private final static String VERTEX_LOCATION_Y_PROPERTY = "vertexLocation.y";
	private final static String START_VERTEX_PROPERTY = "startVertex";
	private final static String END_VERTEX_PROPERTY = "endVertex";
	private final static String VERTEX_WIDTH_PROPERTY = "vertexWidth";
	private final static String VERTEX_HEIGHT_PROPERTY = "vertexHeight";

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
		vertex.setColor(ValueTransformer.transformColor(vertexMeta
				.getProperty(VERTEX_COLOR_PROPERTY)));
		
		vertex.setLocation(ValueTransformer.transformLocation(vertexMeta
				.getProperty(VERTEX_LOCATION_X_PROPERTY), vertexMeta
				.getProperty(VERTEX_LOCATION_Y_PROPERTY)));
		vertex.setStart(ValueTransformer.transformBoolean(vertexMeta
				.getProperty(START_VERTEX_PROPERTY)));
		vertex.setEnd(ValueTransformer.transformBoolean(vertexMeta
				.getProperty(END_VERTEX_PROPERTY)));
		vertex.setWidth(ValueTransformer.transformDouble(vertexMeta
				.getProperty(VERTEX_WIDTH_PROPERTY)));
		vertex.setHeight(ValueTransformer.transformDouble(vertexMeta
				.getProperty(VERTEX_HEIGHT_PROPERTY)));
		
		return vertex;
	}

}
