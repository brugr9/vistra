package vistra.core.graph.ml;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.EdgeFactory;
import vistra.core.graph.item.IEdgeLayout;
import vistra.util.Convert;
import edu.uci.ics.jung.io.graphml.HyperEdgeMetadata;

/**
 * A hyper-edge metadata transformer for reading an extended GraphML file.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class HyperEdgeMetadataTransformer implements
		Transformer<HyperEdgeMetadata, IEdgeLayout> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IEdgeLayout transform(HyperEdgeMetadata meta) {
		IEdgeLayout layout = EdgeFactory.createEdgeLayout();
		layout.setId(meta.getId());
		layout.setWeight(Convert.toInteger(meta
				.getProperty(ExtendedGraphMLWriter.E_WEIGHT)));
		return layout;
	}

}
