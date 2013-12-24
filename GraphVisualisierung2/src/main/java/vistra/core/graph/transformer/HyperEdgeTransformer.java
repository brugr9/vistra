package vistra.core.graph.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphMeta;
import vistra.core.graph.item.edge.EdgeFactory;
import vistra.core.graph.item.edge.IEdgeLayout;
import vistra.util.Convert;
import edu.uci.ics.jung.io.graphml.HyperEdgeMetadata;

/**
 * A hyper-edge transformer for reading a GraphML file.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class HyperEdgeTransformer implements
		Transformer<HyperEdgeMetadata, IEdgeLayout> {

	@Override
	public IEdgeLayout transform(HyperEdgeMetadata meta) {
		IEdgeLayout layout = EdgeFactory.createEdgeLayout();

		layout.setId(meta.getId());
		layout.setValue(Convert.toInt(meta.getProperty(GraphMeta.E_WEIGHT)));

		return layout;
	}

}
