package vistra.core.graph.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphMeta;
import vistra.core.graph.item.edge.EdgeFactory;
import vistra.core.graph.item.edge.IEdge;
import vistra.util.Convert;
import edu.uci.ics.jung.io.graphml.EdgeMetadata;

/**
 * An edge transformer for reading a GraphML file.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeTransformer implements Transformer<EdgeMetadata, IEdge> {

	@Override
	public IEdge transform(EdgeMetadata edgeMeta) {
		IEdge edge = EdgeFactory.createEdge();

		edge.setId(edgeMeta.getId());
		edge.setValue(Convert.toDouble(edgeMeta.getProperty(GraphMeta.E_WEIGHT)));

		return edge;
	}

}
