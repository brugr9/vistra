package vistra.framework.graph.ml;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.EdgeFactory;
import vistra.framework.graph.item.IEdgeLayout;
import vistra.framework.util.Convert;
import edu.uci.ics.jung.io.graphml.EdgeMetadata;

/**
 * An edge metadata transformer for reading an extended GraphML file.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeMetadataTransformer implements
		Transformer<EdgeMetadata, IEdgeLayout> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IEdgeLayout transform(EdgeMetadata meta) {
		IEdgeLayout layout = EdgeFactory.createEdgeLayout();
		layout.setId(meta.getId());
		layout.setWeight(Convert.toInteger(meta
				.getProperty(ExtendedGraphMLWriter.E_WEIGHT)));
		return layout;
	}

}
