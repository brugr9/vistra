package vistra.framework.graph.ml;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.EdgeFactory;
import vistra.framework.graph.item.ILayoutEdge;
import vistra.framework.util.Convert;
import edu.uci.ics.jung.io.graphml.HyperEdgeMetadata;

/**
 * A hyper-edge transformer for reading an extended GraphML file.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class HyperEdgeTransformer implements
		Transformer<HyperEdgeMetadata, ILayoutEdge> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ILayoutEdge transform(HyperEdgeMetadata meta) {
		ILayoutEdge layout = EdgeFactory.createEdge();
		layout.setId(meta.getId());
		layout.setWeight(Convert.toInteger(meta
				.getProperty(GraphWriter.E_WEIGHT)));
		return layout;
	}

}
