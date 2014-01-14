package vistra.framework.graph.ml;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.ILayoutVertex;
import vistra.framework.graph.item.VertexFactory;
import vistra.framework.util.Convert;
import edu.uci.ics.jung.io.graphml.NodeMetadata;

/**
 * A vertex transformer for reading an extended GraphML file.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexTransformer implements
		Transformer<NodeMetadata, ILayoutVertex> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ILayoutVertex transform(NodeMetadata meta) {
		ILayoutVertex layout = VertexFactory.createVertex();
		layout.setId(meta.getId());
		layout.setLocation(Convert.toPoint2D(
				meta.getProperty(GraphWriter.V_LOC_X),
				meta.getProperty(GraphWriter.V_LOC_Y)));
		layout.setStart(Boolean.parseBoolean(meta
				.getProperty(GraphWriter.V_START)));
		layout.setEnd(Boolean.parseBoolean(meta
				.getProperty(GraphWriter.V_END)));
		return layout;
	}

}
