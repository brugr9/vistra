package ch.bfh.bti7301.hs2013.gravis.core.util;

import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.EdgeFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import edu.uci.ics.jung.io.graphml.HyperEdgeMetadata;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public class HyperEdgeTransformer implements Transformer<HyperEdgeMetadata, IEdge> {

	private final static String WEIGHT_PROPERTY = "weight";
	private final static String EDGE_COLOR_PROPERTY = "edgeColor";

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
		edge.setColor(ValueTransformer.transformColor(hEdgeMeta
				.getProperty(EDGE_COLOR_PROPERTY)));
		edge.setWeight(ValueTransformer.transformDouble(hEdgeMeta
				.getProperty(WEIGHT_PROPERTY)));
		return edge;
	}

}
