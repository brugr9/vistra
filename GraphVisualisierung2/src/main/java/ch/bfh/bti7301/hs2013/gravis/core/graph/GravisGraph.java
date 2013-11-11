package ch.bfh.bti7301.hs2013.gravis.core.graph;

import java.util.Collection;

import ch.bfh.bti7301.hs2013.gravis.common.IEdge;
import ch.bfh.bti7301.hs2013.gravis.common.IVertex;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.GraphDecorator;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class GravisGraph extends GraphDecorator<IVertex, IEdge> implements
		IGravisGraph {

	private static final long serialVersionUID = 7604897874620015084L;

	private static int counter = 0;
	
	private String graphDescription;

	private String graphId;

	private EdgeType edgeType;

	/**
	 * @param delegate
	 */
	protected GravisGraph(Graph<IVertex, IEdge> delegate) {
		super(delegate);

		this.graphId = "Graph " + counter++;
		this.graphDescription = "Graph " + counter++;
		this.edgeType = EdgeType.DIRECTED;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#clear()
	 */
	@Override
	public void clear() {
		Collection<IVertex> collection = this.delegate.getVertices();
		IVertex[] vertices = collection.toArray(new IVertex[collection.size()]);

		for (IVertex vertex : vertices) {
			this.delegate.removeVertex(vertex);
		}
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
	public String getDescription() {
		return this.graphDescription;
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
		this.graphDescription = graphName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#getGraphId()
	 */
	@Override
	public String getId() {
		return this.graphId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#setGraphId(int)
	 */
	@Override
	public void setId(String graphId) {
		this.graphId = graphId;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#getEdgeType()
	 */
	@Override
	public EdgeType getEdgeType() {
		return this.edgeType;
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph#setEdgeType(edu.uci.ics.jung.graph.util.EdgeType)
	 */
	@Override
	public void setEdgeType(EdgeType edgeType) {
		this.edgeType = edgeType;
	}

}
