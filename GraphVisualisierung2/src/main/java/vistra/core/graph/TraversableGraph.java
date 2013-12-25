package vistra.core.graph;

import java.util.ArrayList;
import java.util.Collection;

import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.GraphDecorator;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.graph.util.Pair;

/**
 * A traversable graph: An implementation of <code>Graph</code> that delegates
 * most of its method calls to a constructor-specified <code>Graph</code>
 * instance.
 * <ul>
 * <li>Modifiers: Vertices and edges can neither been added nor removed.
 * <li>Traversable: The graph serves with step-methods (names start with
 * 'step...') for generating a traversal.
 * </ul>
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class TraversableGraph extends GraphDecorator<IVertex, IEdge> implements
		ITraversableGraph {

	private static final long serialVersionUID = -265489538887703410L;

	/**
	 * Main constructor.
	 * 
	 * @param delegate
	 *            the graph to delegate
	 */
	public TraversableGraph(Graph<IVertex, IEdge> delegate) {
		super(delegate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Graph#getInEdges(java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<IEdge> getInEdges(IVertex vertex) {
		return this.delegate.getInEdges(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Graph#getOutEdges(java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<IEdge> getOutEdges(IVertex vertex) {
		return this.delegate.getOutEdges(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Graph#getPredecessors(java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<IVertex> getPredecessors(IVertex vertex) {
		return this.delegate.getPredecessors(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Graph#getSuccessors(java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<IVertex> getSuccessors(IVertex vertex) {
		return this.delegate.getSuccessors(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Graph#inDegree(java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int inDegree(IVertex vertex) {
		return this.delegate.inDegree(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Graph#outDegree(java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int outDegree(IVertex vertex) {
		return this.delegate.outDegree(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Graph#isPredecessor(java.lang.Object,
	 * java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isPredecessor(IVertex v1, IVertex v2) {
		return this.delegate.isPredecessor(v1, v2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Graph#isSuccessor(java.lang.Object,
	 * java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isSuccessor(IVertex v1, IVertex v2) {
		return this.delegate.isSuccessor(v1, v2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Graph#getPredecessorCount(java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getPredecessorCount(IVertex vertex) {
		return this.delegate.getPredecessorCount(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Graph#getSuccessorCount(java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getSuccessorCount(IVertex vertex) {
		return this.delegate.getSuccessorCount(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Graph#getSource(java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IVertex getSource(IEdge directed_edge) {
		return this.delegate.getSource(directed_edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Graph#getDest(java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IVertex getDest(IEdge directed_edge) {
		return this.delegate.getDest(directed_edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Graph#isSource(java.lang.Object,
	 * java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isSource(IVertex vertex, IEdge edge) {
		return this.delegate.isSource(vertex, edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Graph#isDest(java.lang.Object,
	 * java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDest(IVertex vertex, IEdge edge) {
		return this.delegate.isDest(vertex, edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Graph#addEdge(java.lang.Object,
	 * java.lang.Object, java.lang.Object)
	 */
	/**
	 * Unsupported operation.
	 */
	@Override
	public boolean addEdge(IEdge e, IVertex v1, IVertex v2) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Graph#addEdge(java.lang.Object,
	 * java.lang.Object, java.lang.Object, edu.uci.ics.jung.graph.util.EdgeType)
	 */
	/**
	 * Unsupported operation.
	 */
	@Override
	public boolean addEdge(IEdge e, IVertex v1, IVertex v2, EdgeType edgeType) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Graph#getEndpoints(java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Pair<IVertex> getEndpoints(IEdge edge) {
		return this.delegate.getEndpoints(edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Graph#getOpposite(java.lang.Object,
	 * java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IVertex getOpposite(IVertex vertex, IEdge edge) {
		return this.delegate.getOpposite(vertex, edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#getEdges()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<IEdge> getEdges() {
		return this.delegate.getEdges();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#getVertices()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<IVertex> getVertices() {
		return this.delegate.getVertices();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#containsVertex(java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsVertex(IVertex vertex) {
		return this.delegate.containsVertex(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#containsEdge(java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsEdge(IEdge edge) {
		return this.delegate.containsEdge(edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#getEdgeCount()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getEdgeCount() {
		return this.delegate.getEdgeCount();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#getVertexCount()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getVertexCount() {
		return this.delegate.getVertexCount();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#getNeighbors(java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<IVertex> getNeighbors(IVertex vertex) {
		return this.delegate.getNeighbors(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#getIncidentEdges(java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<IEdge> getIncidentEdges(IVertex vertex) {
		return this.delegate.getIncidentEdges(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uci.ics.jung.graph.Hypergraph#getIncidentVertices(java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<IVertex> getIncidentVertices(IEdge edge) {
		return this.delegate.getIncidentVertices(edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#findEdge(java.lang.Object,
	 * java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IEdge findEdge(IVertex v1, IVertex v2) {
		return this.delegate.findEdge(v1, v2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#findEdgeSet(java.lang.Object,
	 * java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<IEdge> findEdgeSet(IVertex v1, IVertex v2) {
		return this.delegate.findEdgeSet(v1, v2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#addVertex(java.lang.Object)
	 */
	/**
	 * Unsupported operation.
	 */
	@Override
	public boolean addVertex(IVertex vertex) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#addEdge(java.lang.Object,
	 * java.util.Collection)
	 */
	/**
	 * Unsupported operation.
	 */
	@Override
	public boolean addEdge(IEdge edge, Collection<? extends IVertex> vertices) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#addEdge(java.lang.Object,
	 * java.util.Collection, edu.uci.ics.jung.graph.util.EdgeType)
	 */
	/**
	 * Unsupported operation.
	 */
	@Override
	public boolean addEdge(IEdge edge, Collection<? extends IVertex> vertices,
			EdgeType edge_type) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#removeVertex(java.lang.Object)
	 */
	/**
	 * Unsupported operation.
	 */
	@Override
	public boolean removeVertex(IVertex vertex) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#removeEdge(java.lang.Object)
	 */
	/**
	 * Unsupported operation.
	 */
	@Override
	public boolean removeEdge(IEdge edge) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#isNeighbor(java.lang.Object,
	 * java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isNeighbor(IVertex v1, IVertex v2) {
		return this.delegate.isNeighbor(v1, v2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#isIncident(java.lang.Object,
	 * java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isIncident(IVertex vertex, IEdge edge) {
		return this.delegate.isIncident(vertex, edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#degree(java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int degree(IVertex vertex) {
		return this.delegate.degree(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#getNeighborCount(java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getNeighborCount(IVertex vertex) {
		return this.delegate.getNeighborCount(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#getIncidentCount(java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getIncidentCount(IEdge edge) {
		return this.delegate.getIncidentCount(edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#getEdgeType(java.lang.Object)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public EdgeType getEdgeType(IEdge edge) {
		return this.delegate.getEdgeType(edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.graph.Hypergraph#getDefaultEdgeType()
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public EdgeType getDefaultEdgeType() {
		return this.delegate.getDefaultEdgeType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uci.ics.jung.graph.Hypergraph#getEdges(edu.uci.ics.jung.graph.util
	 * .EdgeType)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<IEdge> getEdges(EdgeType edge_type) {
		return this.delegate.getEdges(edge_type);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uci.ics.jung.graph.Hypergraph#getEdgeCount(edu.uci.ics.jung.graph
	 * .util.EdgeType)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getEdgeCount(EdgeType edge_type) {
		return this.delegate.getEdgeCount(edge_type);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EdgeType getEdgeType() {
		ArrayList<IEdge> edges = new ArrayList<IEdge>();
		edges.addAll(this.delegate.getEdges());
		IEdge edge = edges.get(0);
		return this.delegate.getEdgeType(edge);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IVertex getStart() {
		ArrayList<IVertex> vertices = new ArrayList<IVertex>();
		vertices.addAll(this.delegate.getVertices());
		for (IVertex vertex : vertices)
			if (vertex.isStart())
				return vertex;
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IVertex getEnd() {
		ArrayList<IVertex> vertices = new ArrayList<IVertex>();
		vertices.addAll(this.delegate.getVertices());
		for (IVertex vertex : vertices)
			if (vertex.isEnd())
				return vertex;
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stepVisit(IEdge edge, IVertex vertex) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stepBackEdge(IEdge edge) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stepForwardEdge(IEdge edge) {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stepCrossEdge(IEdge edge) {
		// TODO Auto-generated method stub

	}

	@Override
	public void stepDiscardedEdge(IEdge edge) {
		// TODO Auto-generated method stub

	}

}
