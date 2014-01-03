package vistra.core.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import vistra.core.algorithm.IAlgorithm;
import vistra.core.graph.TraversableGraphEvent.EdgeVertexEvent;
import vistra.core.graph.TraversableGraphEvent.Type;
import vistra.core.graph.TraversableGraphEvent.VerticesEvent;
import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.IVertex;
import vistra.core.graph.item.state.IVertexStateHandler;
import vistra.core.traversal.Traversal;
import vistra.core.traversal.step.IStep;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.GraphDecorator;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.graph.util.Pair;

/**
 * An implementation of {@code Graph} that delegates most of its method calls to
 * a constructor-specified {@code Graph} instance. Modifiers are not supported
 * anymore: vertices and edges can neither been added nor removed.
 * <p>
 * In addition, this graph serves with some 'step'-methods which an
 * {@code IAlgorithm}-developer can use for generating steps of a traversal.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see IAlgorithm
 * @see IStep
 * @see Traversal
 * 
 */
public class TraversableGraph extends GraphDecorator<IVertex, IEdge> implements
		ITraversableGraph {

	private static final long serialVersionUID = -265489538887703410L;

	/**
	 * A field for a list of listeners.
	 */
	List<ITraversableGraphEventListener> listenerList = Collections
			.synchronizedList(new LinkedList<ITraversableGraphEventListener>());

	/**
	 * Main constructor.
	 * 
	 * @param delegate
	 *            the graph to delegate
	 */
	@SuppressWarnings("unchecked")
	public TraversableGraph(Graph<? extends IVertex, ? extends IEdge> delegate) {
		super((Graph<IVertex, IEdge>) delegate);
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
	public boolean isVisited(IVertex vertex) {
		IVertexStateHandler handler = (IVertexStateHandler) vertex;
		return handler.isVisited();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addTraversalEventListener(
			ITraversableGraphEventListener listener) {
		this.listenerList.add(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeTraversalEventListener(
			ITraversableGraphEventListener listener) {
		this.listenerList.remove(listener);
	}

	/**
	 * Fires an event.
	 * 
	 * @param evt
	 *            the event
	 */
	private void fireEvent(TraversableGraphEvent evt) {
		for (ITraversableGraphEventListener listener : listenerList) {
			listener.handleTraversableGraphEvent(evt);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stepInitVertices(List<IVertex> vertices) {
		this.fireEvent(new VerticesEvent(this, Type.INIT, vertices, null));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stepUpdateVertices(List<IVertex> vertices, List<String> values) {
		this.fireEvent(new VerticesEvent(this, Type.UPDATE, vertices, values));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stepVisitVertex(IEdge edge, IVertex vertex) {
		this.fireEvent(new EdgeVertexEvent(this, Type.VISIT, edge, vertex));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stepSolutionVertex(IEdge edge, IVertex vertex) {
		this.fireEvent(new EdgeVertexEvent(this, Type.SOLUTION, edge, vertex));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stepDiscoveryEdge(IEdge edge) {
		this.fireEvent(new EdgeVertexEvent(this, Type.DISCOVERY_EDGE, edge,
				null));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stepBackEdge(IEdge edge) {
		this.fireEvent(new EdgeVertexEvent(this, Type.BACK_EDGE, edge, null));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stepForwardEdge(IEdge edge) {
		this.fireEvent(new EdgeVertexEvent(this, Type.FORWARD_EDGE, edge, null));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stepCrossEdge(IEdge edge) {
		this.fireEvent(new EdgeVertexEvent(this, Type.CROSS_EDGE, edge, null));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stepDiscardedEdge(IEdge edge) {
		this.fireEvent(new EdgeVertexEvent(this, Type.DISCARDED_EDGE, edge,
				null));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stepSolutionEdge(IEdge edge) {
		this.fireEvent(new EdgeVertexEvent(this, Type.SOLUTION_EDGE, edge, null));
	}

}
