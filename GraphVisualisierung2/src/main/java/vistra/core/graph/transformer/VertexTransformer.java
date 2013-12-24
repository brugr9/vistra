package vistra.core.graph.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphMeta;
import vistra.core.graph.item.vertex.IVertex;
import vistra.core.graph.item.vertex.VertexFactory;
import vistra.util.Convert;
import edu.uci.ics.jung.io.graphml.NodeMetadata;

/**
 * A vertex transformer. Use it for reading a graphML file.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexTransformer implements Transformer<NodeMetadata, IVertex> {

	@Override
	public IVertex transform(NodeMetadata vertexMeta) {
		IVertex vertex = VertexFactory.createVertex();

		vertex.setId(vertexMeta.getId());
		vertex.setLocation(Convert.toPoint2D(
				vertexMeta.getProperty(GraphMeta.V_LOC_X),
				vertexMeta.getProperty(GraphMeta.V_LOC_Y)));
		vertex.setStart(Convert.toBoolean(vertexMeta
				.getProperty(GraphMeta.V_START)));
		vertex.setEnd(Convert.toBoolean(vertexMeta.getProperty(GraphMeta.V_END)));

		return vertex;
	}

}
