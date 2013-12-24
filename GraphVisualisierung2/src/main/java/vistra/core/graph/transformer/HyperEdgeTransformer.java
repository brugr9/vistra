package vistra.core.graph.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphMeta;
import vistra.core.graph.item.edge.EdgeFactory;
import vistra.core.graph.item.edge.IEdge;
import vistra.util.Convert;
import edu.uci.ics.jung.io.graphml.HyperEdgeMetadata;

/**
 * A hyper-edge transformer for reading a GraphML file.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class HyperEdgeTransformer implements
		Transformer<HyperEdgeMetadata, IEdge> {

	@Override
	public IEdge transform(HyperEdgeMetadata meta) {
		IEdge edge = EdgeFactory.createEdge();

		edge.setId(meta.getId());
		edge.setValue(Convert.toInt(meta.getProperty(GraphMeta.E_WEIGHT)));

		return edge;
	}

}
