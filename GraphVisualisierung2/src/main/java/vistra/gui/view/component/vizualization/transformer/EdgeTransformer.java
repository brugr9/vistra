package vistra.gui.view.component.vizualization.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.edge.EdgeFactory;
import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.GraphPropertyConstants;
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
		edge.setLineColor(ValueTransformer.transformStringToColor(edgeMeta
				.getProperty(GraphPropertyConstants.E_COLOR)));
		edge.setWeight(ValueTransformer.transformDouble(edgeMeta
				.getProperty(GraphPropertyConstants.E_WEIGHT)));
		return edge;
	}

}
