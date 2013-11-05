package ch.bfh.bti7301.hs2013.gravis.core.graph;

import java.util.Collection;

import ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm.GraphType;
import ch.bfh.bti7301.hs2013.gravis.common.IEdge;
import ch.bfh.bti7301.hs2013.gravis.common.IVertex;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.GraphDecorator;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class GravisGraph extends GraphDecorator<IVertex, IEdge> implements
		IGravisGraph {

	private static final long serialVersionUID = 7604897874620015084L;

	private String graphName;

	private String graphId;

	private GraphType[] graphType;

	/**
	 * @param delegate
	 */
	protected GravisGraph(Graph<IVertex, IEdge> delegate) {
		super(delegate);

		this.graphName = this.toString();
		this.graphId = "";
		this.graphType = new GraphType[] {};
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#clear()
	 */
	@Override
	public void clear() {
		Collection<IVertex> collection = this.delegate.getVertices();
		IVertex[] vertices = this.delegate.getVertices().toArray(
				new IVertex[collection.size()]);

		for (IVertex vertex : vertices) {
			this.delegate.removeVertex(vertex);
		}

		this.setGraphName(this.toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return this.delegate.getVertexCount() == 0
				&& this.delegate.getEdgeCount() == 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#getGraphName()
	 */
	@Override
	public String getGraphName() {
		return this.graphName;
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
		this.graphName = graphName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#getGraphId()
	 */
	@Override
	public String getGraphId() {
		return this.graphId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#setGraphId(int)
	 */
	@Override
	public void setGraphId(String graphId) {
		this.graphId = graphId;
	}

	@Override
	public GraphType[] getType() {
		return this.graphType;
	}

	@Override
	public void setType(GraphType[] graphType) {
		this.setType(graphType);
	}

}
