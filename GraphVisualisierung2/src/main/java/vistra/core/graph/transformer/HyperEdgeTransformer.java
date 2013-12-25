package vistra.core.graph.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphMeta;
import vistra.core.graph.item.edge.EdgeFactory;
import vistra.core.graph.item.edge.ILayoutEdge;
import vistra.util.Convert;
import edu.uci.ics.jung.io.graphml.HyperEdgeMetadata;

/**
 * A hyper-edge transformer for reading a GraphML file.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class HyperEdgeTransformer implements
		Transformer<HyperEdgeMetadata, ILayoutEdge> {

	@Override
	public ILayoutEdge transform(HyperEdgeMetadata meta) {
		ILayoutEdge layout = EdgeFactory.createEdgeLayout();

		layout.setId(meta.getId());
		layout.setWeight(Convert.toInt(meta.getProperty(GraphMeta.E_WEIGHT)));

		return layout;
	}

}
