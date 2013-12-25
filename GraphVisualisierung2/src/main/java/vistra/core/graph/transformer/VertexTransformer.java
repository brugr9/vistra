package vistra.core.graph.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphMeta;
import vistra.core.graph.item.vertex.ILayoutVertex;
import vistra.core.graph.item.vertex.VertexFactory;
import vistra.util.Convert;
import edu.uci.ics.jung.io.graphml.NodeMetadata;

/**
 * A vertex transformer. Use it for reading a graphML file.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexTransformer implements
		Transformer<NodeMetadata, ILayoutVertex> {

	@Override
	public ILayoutVertex transform(NodeMetadata vertexMeta) {
		ILayoutVertex layout = VertexFactory.createVertexLayout();

		layout.setId(vertexMeta.getId());
		layout.setLocation(Convert.toPoint2D(
				vertexMeta.getProperty(GraphMeta.V_LOC_X),
				vertexMeta.getProperty(GraphMeta.V_LOC_Y)));
		layout.setStart(Convert.toBoolean(vertexMeta
				.getProperty(GraphMeta.V_START)));
		layout.setEnd(Convert.toBoolean(vertexMeta.getProperty(GraphMeta.V_END)));

		return layout;
	}

}
