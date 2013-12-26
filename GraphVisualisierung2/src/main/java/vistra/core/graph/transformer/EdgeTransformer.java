package vistra.core.graph.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphMeta;
import vistra.core.graph.item.edge.EdgeFactory;
import vistra.core.graph.item.edge.IEdgeLayout;
import vistra.util.Convert;
import edu.uci.ics.jung.io.graphml.EdgeMetadata;

/**
 * An edge transformer for reading a GraphML file.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeTransformer implements Transformer<EdgeMetadata, IEdgeLayout> {

	@Override
	public IEdgeLayout transform(EdgeMetadata edgeMeta) {
		IEdgeLayout layout = EdgeFactory.createEdgeLayout();

		layout.setId(edgeMeta.getId());
		layout.setWeight(Convert.toInt(edgeMeta.getProperty(GraphMeta.E_WEIGHT)));

		return layout;
	}

}
