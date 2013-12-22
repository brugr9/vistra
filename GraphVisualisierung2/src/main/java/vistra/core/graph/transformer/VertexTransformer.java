package vistra.core.graph.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphMLMeta;
import vistra.core.graph.item.vertex.IVertex;
import vistra.core.graph.item.vertex.VertexFactory;
import vistra.util.ColorPalette;
import vistra.util.Convert;
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
		vertex.setLineColor(ColorPalette.toColor(vertexMeta
				.getProperty(GraphMLMeta.V_COLOR)));
		vertex.setFillColor(ColorPalette.toColor(vertexMeta
				.getProperty(GraphMLMeta.V_COLOR)));
		vertex.setLocation(Convert.toPoint2D(
				vertexMeta.getProperty(GraphMLMeta.V_LOC_X),
				vertexMeta.getProperty(GraphMLMeta.V_LOC_Y)));
		vertex.setStart(Convert.toBoolean(vertexMeta
				.getProperty(GraphMLMeta.V_START)));
		vertex.setEnd(Convert.toBoolean(vertexMeta
				.getProperty(GraphMLMeta.V_END)));

		return vertex;
	}

}
