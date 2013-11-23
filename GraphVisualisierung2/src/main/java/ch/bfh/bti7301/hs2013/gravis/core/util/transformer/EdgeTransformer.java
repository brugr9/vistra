package ch.bfh.bti7301.hs2013.gravis.core.util.transformer;

import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.EdgeFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import edu.uci.ics.jung.io.graphml.EdgeMetadata;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class EdgeTransformer implements Transformer<EdgeMetadata, IEdge> {

	private final static String WEIGHT_PROPERTY = "weight";
	private final static String EDGE_COLOR_PROPERTY = "edgeColor";

	private final EdgeFactory edgeFactory;

	public EdgeTransformer() {
		this.edgeFactory = new EdgeFactory();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public IEdge transform(EdgeMetadata edgeMeta) {
		IEdge edge = this.edgeFactory.create();

		edge.setId(edgeMeta.getId());
		edge.setColor(ValueTransformer.transformColor(edgeMeta
				.getProperty(EDGE_COLOR_PROPERTY)));
		edge.setWeight(ValueTransformer.transformDouble(edgeMeta
				.getProperty(WEIGHT_PROPERTY)));
		return edge;
	}

}
