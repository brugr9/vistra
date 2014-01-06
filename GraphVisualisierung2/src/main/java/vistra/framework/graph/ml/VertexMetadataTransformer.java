package vistra.framework.graph.ml;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.IVertexLayout;
import vistra.framework.graph.item.VertexFactory;
import vistra.framework.util.Convert;
import edu.uci.ics.jung.io.graphml.NodeMetadata;

/**
 * A vertex metadata transformer for reading an extended GraphML file.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexMetadataTransformer implements
		Transformer<NodeMetadata, IVertexLayout> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IVertexLayout transform(NodeMetadata meta) {
		IVertexLayout layout = VertexFactory.createVertex();
		layout.setId(meta.getId());
		layout.setLocation(Convert.toPoint2D(
				meta.getProperty(ExtendedGraphMLWriter.V_LOC_X),
				meta.getProperty(ExtendedGraphMLWriter.V_LOC_Y)));
		layout.setStart(Boolean.parseBoolean(meta
				.getProperty(ExtendedGraphMLWriter.V_START)));
		layout.setEnd(Boolean.parseBoolean(meta
				.getProperty(ExtendedGraphMLWriter.V_END)));
		return layout;
	}

}
