package vistra.core.graph.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphMLMeta;
import vistra.core.graph.item.edge.EdgeFactory;
import vistra.core.graph.item.edge.IEdge;
import vistra.util.ColorPalette;
import vistra.util.Convert;
import edu.uci.ics.jung.io.graphml.EdgeMetadata;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeTransformer implements Transformer<EdgeMetadata, IEdge> {

	@Override
	public IEdge transform(EdgeMetadata edgeMeta) {
		IEdge edge = EdgeFactory.createEdge();

		edge.setId(edgeMeta.getId());
		edge.setLineColor(ColorPalette.toColor(edgeMeta
				.getProperty(GraphMLMeta.E_COLOR)));
		edge.setWeight(Convert.toDouble(edgeMeta
				.getProperty(GraphMLMeta.E_WEIGHT)));
		return edge;
	}

}
