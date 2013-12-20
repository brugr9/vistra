package vistra.gui.view.component.vizualization.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphPropertyConstants;
import vistra.core.graph.item.vertex.IVertex;
import vistra.core.graph.item.vertex.VertexFactory;
import edu.uci.ics.jung.io.graphml.NodeMetadata;

/**
 * A vertex transformer.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexTransformer implements Transformer<NodeMetadata, IVertex> {

	@Override
	public IVertex transform(NodeMetadata vertexMeta) {
		IVertex vertex = VertexFactory.createVertex();

		vertex.setId(vertexMeta.getId());
		vertex.setLineColor(ValueTransformer.transformStringToColor(vertexMeta
				.getProperty(GraphPropertyConstants.V_LINE_COLOR)));
		vertex.setBGColor(ValueTransformer.transformStringToColor(vertexMeta
				.getProperty(GraphPropertyConstants.V_BG_COLOR)));
		vertex.setLocation(ValueTransformer.transformLocation(
				vertexMeta.getProperty(GraphPropertyConstants.V_LOC_X),
				vertexMeta.getProperty(GraphPropertyConstants.V_LOC_Y)));
		vertex.setStart(ValueTransformer.transformBoolean(vertexMeta
				.getProperty(GraphPropertyConstants.V_START)));
		vertex.setEnd(ValueTransformer.transformBoolean(vertexMeta
				.getProperty(GraphPropertyConstants.V_END)));

		return vertex;
	}

}
