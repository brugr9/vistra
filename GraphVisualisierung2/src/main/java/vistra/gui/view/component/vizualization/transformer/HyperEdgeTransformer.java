package vistra.gui.view.component.vizualization.transformer;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.edge.EdgeFactory;
import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import vistra.core.graph.GraphPropertyConstants;
import edu.uci.ics.jung.io.graphml.HyperEdgeMetadata;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class HyperEdgeTransformer implements
		Transformer<HyperEdgeMetadata, IEdge> {

	@Override
	public IEdge transform(HyperEdgeMetadata hEdgeMeta) {
		IEdge edge = EdgeFactory.create();

		edge.setId(hEdgeMeta.getId());
		edge.setCurrentColor(ValueTransformer.transformStringToColor(hEdgeMeta
				.getProperty(GraphPropertyConstants.E_COLOR)));
		edge.setWeight(ValueTransformer.transformDouble(hEdgeMeta
				.getProperty(GraphPropertyConstants.E_WEIGHT)));
		return edge;
	}

}
