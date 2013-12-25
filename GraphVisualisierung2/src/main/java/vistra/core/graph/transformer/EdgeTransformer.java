package vistra.core.graph.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphMeta;
import vistra.core.graph.item.edge.EdgeFactory;
import vistra.core.graph.item.edge.ILayoutEdge;
import vistra.util.Convert;
import edu.uci.ics.jung.io.graphml.EdgeMetadata;

/**
 * An edge transformer for reading a GraphML file.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeTransformer implements Transformer<EdgeMetadata, ILayoutEdge> {

	@Override
	public ILayoutEdge transform(EdgeMetadata edgeMeta) {
		ILayoutEdge layout = EdgeFactory.createEdgeLayout();

		layout.setId(edgeMeta.getId());
		layout.setWeight(Convert.toInt(edgeMeta.getProperty(GraphMeta.E_WEIGHT)));

		return layout;
	}

}
