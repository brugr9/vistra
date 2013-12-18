package vistra.core.graph;

import java.util.Collection;

import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.GraphDecorator;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * A JUNG graph decorator adapted for GRAVIS.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class GravisGraph extends GraphDecorator<IVertex, IEdge> implements
		IGravisGraph {

	private static final long serialVersionUID = 7604897874620015084L;

	/**
	 * A field for a counter.
	 */
	private static int counter = 0;

	/**
	 * A field for the graph description.
	 */
	private String graphDescription;

	/**
	 * A field for the graph identifier.
	 */
	private String graphId;

	/**
	 * A field for the edge type.
	 */
	private EdgeType edgeType;

	/**
	 * Main constructor.
	 * 
	 * @param delegate
	 *            the graph to delegate
	 */
	protected GravisGraph(Graph<IVertex, IEdge> delegate) {
		super(delegate);

		counter++;
		this.graphId = "Graph " + counter;
		this.graphDescription = "Graph " + counter;
		this.edgeType = EdgeType.DIRECTED;
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
	/**
	 * {@inheritDoc}
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
	/**
	 * {@inheritDoc}
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
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDescription(String graphDescription) {
		this.graphDescription = graphDescription.trim();
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
		return this.graphId;
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
		this.graphId = graphId.trim();
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
		return this.edgeType;
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
		this.edgeType = edgeType;
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
		for (IVertex vertex : this.getVertices()) {
			if (vertex.getId().equals(vertexId.trim())) {
				return true;
			}
		}
		return false;
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
		for (IEdge edge : this.getEdges()) {
			if (edge.getId().equals(edgeId.trim())) {
				return true;
			}
		}
		return false;
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
		return this.containsVertexId(itemId) || this.containsEdgeId(itemId);
	}

}
