package ch.bfh.bti7301.hs2013.gravis.core.util.transformer;

import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.EdgeFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.util.GraphPropertyConstants;
import edu.uci.ics.jung.io.graphml.HyperEdgeMetadata;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public class HyperEdgeTransformer implements Transformer<HyperEdgeMetadata, IEdge> {

	private final EdgeFactory edgeFactory;
	
	public HyperEdgeTransformer() {
		this.edgeFactory = new EdgeFactory();
	}
	
	/* (non-Javadoc)
	 * @see org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public IEdge transform(HyperEdgeMetadata hEdgeMeta) {
		IEdge edge = this.edgeFactory.create();

		edge.setId(hEdgeMeta.getId());
		edge.setCurrentColor(ValueTransformer.transformStringToColor(hEdgeMeta
				.getProperty(GraphPropertyConstants.E_COLOR)));
		edge.setWeight(ValueTransformer.transformDouble(hEdgeMeta
				.getProperty(GraphPropertyConstants.E_WEIGHT)));
		return edge;
	}

}
