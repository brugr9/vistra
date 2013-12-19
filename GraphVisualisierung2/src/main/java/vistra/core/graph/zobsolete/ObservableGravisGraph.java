package vistra.core.graph.zobsolete;

import vistra.core.graph.GraphFactory;
import vistra.core.graph.zobsolete.item.IGraphItem;
import vistra.core.graph.zobsolete.item.IRestrictedGraphItem.State;
import vistra.core.graph.zobsolete.item.edge.IEdge;
import vistra.core.graph.zobsolete.item.vertex.IVertex;
import edu.uci.ics.jung.graph.ObservableGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * A JUNG observable graph adapted for GRAVIS.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class ObservableGravisGraph extends ObservableGraph<IVertex, IEdge> implements
		IObservableGraph {

	private static final long serialVersionUID = -4250831846033989666L;

	private IGravisGraph gravisGraph;

	/**
	 * @param delegate
	 */
	public ObservableGravisGraph(IGravisGraph delegate) {
		super(delegate);

		this.gravisGraph = delegate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#isEmpty()
	 */
	/**
	 * {@inheritDoc}
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
	/**
	 * {@inheritDoc}
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
	/**
	 * {@inheritDoc}
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
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDescription(String graphName) {
		this.gravisGraph.setDescription(graphName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#getGraphId()
	 */
	/**
	 * {@inheritDoc}
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
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(String graphId) {
		this.gravisGraph.setId(graphId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#getEdgeType()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public EdgeType getEdgeType() {
		return this.gravisGraph.getEdgeType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#setEdgeType(edu.
	 * uci.ics.jung.graph.util.EdgeType)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEdgeType(EdgeType edgeType) {
		this.gravisGraph.setEdgeType(edgeType);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateState(State state, IGraphItem... graphItems) {
		for (IGraphItem item : graphItems) {
			item.setNewState(state);
		}

		this.fireGraphEvent(GraphFactory.createGraphEvent(this, graphItems));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IGraphItemUpdate#updateState(
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem[])
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateState(IGraphItem... graphItems) {
		this.fireGraphEvent(GraphFactory.createGraphEvent(this, graphItems));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#containsVertexId
	 * (java.lang.String)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsVertexId(String vertexId) {
		return this.gravisGraph.containsVertexId(vertexId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#containsEdgeId(java
	 * .lang.String)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsEdgeId(String edgeId) {
		return this.gravisGraph.containsEdgeId(edgeId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#containsItemId(java
	 * .lang.String)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsItemId(String itemId) {
		return this.gravisGraph.containsItemId(itemId);
	}

}
