package vistra.gui.view.component.vizualization.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.GraphPropertyConstants;
import vistra.core.graph.item.edge.EdgeFactory;
import vistra.core.graph.item.edge.IEdge;
import edu.uci.ics.jung.io.graphml.HyperEdgeMetadata;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class HyperEdgeTransformer implements
		Transformer<HyperEdgeMetadata, IEdge> {

	@Override
	public IEdge transform(HyperEdgeMetadata hEdgeMeta) {
		IEdge edge = EdgeFactory.createEdge();

		edge.setId(hEdgeMeta.getId());
		edge.setLineColor(ValueTransformer.transformStringToColor(hEdgeMeta
				.getProperty(GraphPropertyConstants.E_COLOR)));
		edge.setWeight(ValueTransformer.transformDouble(hEdgeMeta
				.getProperty(GraphPropertyConstants.E_WEIGHT)));
		return edge;
	}

}
