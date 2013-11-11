package ch.bfh.bti7301.hs2013.gravis.core.graph;

import ch.bfh.bti7301.hs2013.gravis.common.IEdge;
import ch.bfh.bti7301.hs2013.gravis.common.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.common.IVertex;
import edu.uci.ics.jung.graph.ObservableGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class ObservableGravisGraph extends ObservableGraph<IVertex, IEdge> implements
		IObservableGravisGraph {

	private static final long serialVersionUID = -4250831846033989666L;

	private IGravisGraph gravisGraph;

	/**
	 * @param delegate
	 */
	protected ObservableGravisGraph(IGravisGraph delegate) {
		super(delegate);

		this.gravisGraph = delegate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return this.gravisGraph.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#clear()
	 */
	@Override
	public void clear() {
		this.gravisGraph.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#getGraphName()
	 */
	@Override
	public String getDescription() {
		return this.gravisGraph.getDescription();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#setGraphName(java
	 * .lang.String)
	 */
	@Override
	public void setDescription(String graphName) {
		this.gravisGraph.setDescription(graphName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGraphItemUpdate#updateState
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem)
	 */
	@Override
	public void updateState(IGraphItem item) {
		this.fireGraphEvent(GraphFactory.createGraphEvent(this, item));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#getGraphId()
	 */
	@Override
	public String getId() {
		return this.gravisGraph.getId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#setGraphId(int)
	 */
	@Override
	public void setId(String graphId) {
		this.gravisGraph.setId(graphId);
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#getEdgeType()
	 */
	@Override
	public EdgeType getEdgeType() {
		return this.gravisGraph.getEdgeType();
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#setEdgeType(edu.uci.ics.jung.graph.util.EdgeType)
	 */
	@Override
	public void setEdgeType(EdgeType edgeType) {
		this.gravisGraph.setEdgeType(edgeType);
	}

}
