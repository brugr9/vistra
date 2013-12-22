package vistra.core.graph.transformer.edge;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphMLMeta;
import vistra.core.graph.item.edge.EdgeFactory;
import vistra.core.graph.item.edge.IEdge;
import vistra.util.ColorPalette;
import vistra.util.Convert;
import edu.uci.ics.jung.io.graphml.HyperEdgeMetadata;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class HyperEdgeTransformer implements
		Transformer<HyperEdgeMetadata, IEdge> {

	@Override
	public IEdge transform(HyperEdgeMetadata meta) {
		IEdge edge = EdgeFactory.createEdge();

		edge.setId(meta.getId());
		edge.setLineColor(ColorPalette.toColor(meta
				.getProperty(GraphMLMeta.E_COLOR)));
		edge.setWeight(Convert.toDouble(meta.getProperty(GraphMLMeta.E_WEIGHT)));

		return edge;
	}

}
