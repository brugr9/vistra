package ch.bfh.bti7301.hs2013.gravis.core.graph;

import ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm.GraphType;
import ch.bfh.bti7301.hs2013.gravis.common.IEdge;
import ch.bfh.bti7301.hs2013.gravis.common.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.common.IVertex;
import edu.uci.ics.jung.graph.ObservableGraph;

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
	public String getGraphName() {
		return this.gravisGraph.getGraphName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#setGraphName(java
	 * .lang.String)
	 */
	@Override
	public void setGraphName(String graphName) {
		this.gravisGraph.setGraphName(graphName);
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
	public String getGraphId() {
		return this.gravisGraph.getGraphId();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#setGraphId(int)
	 */
	@Override
	public void setGraphId(String graphId) {
		this.gravisGraph.setGraphId(graphId);
	}

	@Override
	public GraphType[] getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setType(GraphType[] graphType) {
		// TODO Auto-generated method stub

	}

}
