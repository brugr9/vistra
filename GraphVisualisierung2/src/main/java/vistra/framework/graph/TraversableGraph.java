package vistra.framework.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedSet;

import net.datastructures.Entry;
import vistra.framework.algorithm.IAlgorithm;
import vistra.framework.graph.item.IEdge;
import vistra.framework.graph.item.ILayoutVertex;
import vistra.framework.graph.item.IVertex;
import vistra.framework.graph.item.state.IVertexStateHandler;
import vistra.framework.traversal.ITraversal;
import vistra.framework.traversal.step.BackEdgeStep;
import vistra.framework.traversal.step.CrossEdgeStep;
import vistra.framework.traversal.step.DiscardedEdgeStep;
import vistra.framework.traversal.step.ForwardEdgeStep;
import vistra.framework.traversal.step.IStep;
import vistra.framework.traversal.step.InitializedVertexStep;
import vistra.framework.traversal.step.SolutionMemberStep;
import vistra.framework.traversal.step.UpdatedVertexStep;
import vistra.framework.traversal.step.VisitStep;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.GraphDecorator;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.graph.util.Pair;

/**
 * A traversable graph. The graph delegates most of its method calls to a
 * constructor-specified {@code Graph}.
 * <ul>
 * <li>Modifiers are not supported anymore: vertices and edges can neither been
 * added nor removed.
 * <li>In addition, this graph serves with 'step'-methods which an
 * {@code IAlgorithm}-developer can use for traversing over the graph and
 * generating steps of a {@code Traversal}.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see IAlgorithm
 * @see ITraversal
 * @see IStep
 * 
 */
public class TraversableGraph extends GraphDecorator<IVertex, IEdge> implements
		ITraversableGraph {

	private static final long serialVersionUID = -265489538887703410L;

	/**
	 * A field for a list of steps.
	 */
	List<IStep> steps;

	/**
	 * A field for a solution.
	 */
	StringBuilder solution;

	/**
	 * Main constructor.
	 * 
	 * @param delegate
	 *            the graph to delegate
	 * @param steps
	 *            a list for the steps
	 */
	@SuppressWarnings("unchecked")
	public TraversableGraph(Graph<? extends IVertex, ? extends IEdge> delegate,
			List<IStep> steps, StringBuilder solution) {
		super((Graph<IVertex, IEdge>) delegate);
		this.steps = steps;
		this.solution = solution;
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
	public Collection<IEdge> getInEdges(IVertex v) {
		return this.delegate.getInEdges(v);
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
	public Collection<IEdge> getOutEdges(IVertex v) {
		return this.delegate.getOutEdges(v);
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
	public Collection<IVertex> getPredecessors(IVertex v) {
		return this.delegate.getPredecessors(v);
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
	public Collection<IVertex> getSuccessors(IVertex v) {
		return this.delegate.getSuccessors(v);
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
	public int inDegree(IVertex v) {
		return this.delegate.inDegree(v);
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
	public int outDegree(IVertex v) {
		return this.delegate.outDegree(v);
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
	public int getPredecessorCount(IVertex v) {
		return this.delegate.getPredecessorCount(v);
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
	public int getSuccessorCount(IVertex v) {
		return this.delegate.getSuccessorCount(v);
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
	public boolean isSource(IVertex v, IEdge e) {
		return this.delegate.isSource(v, e);
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
	public boolean isDest(IVertex v, IEdge e) {
		return this.delegate.isDest(v, e);
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
	public Pair<IVertex> getEndpoints(IEdge e) {
		return this.delegate.getEndpoints(e);
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
	public IVertex getOpposite(IVertex v, IEdge e) {
		return this.delegate.getOpposite(v, e);
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
	public boolean containsVertex(IVertex v) {
		return this.delegate.containsVertex(v);
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
	public boolean containsEdge(IEdge e) {
		return this.delegate.containsEdge(e);
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
	public Collection<IVertex> getNeighbors(IVertex v) {
		return this.delegate.getNeighbors(v);
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
	public Collection<IEdge> getIncidentEdges(IVertex v) {
		return this.delegate.getIncidentEdges(v);
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
	public Collection<IVertex> getIncidentVertices(IEdge e) {
		return this.delegate.getIncidentVertices(e);
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
	public boolean isIncident(IVertex v, IEdge e) {
		return this.delegate.isIncident(v, e);
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
	public int degree(IVertex v) {
		return this.delegate.degree(v);
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
	public int getNeighborCount(IVertex v) {
		return this.delegate.getNeighborCount(v);
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
	public int getIncidentCount(IEdge e) {
		return this.delegate.getIncidentCount(e);
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
	public EdgeType getEdgeType(IEdge e) {
		return this.delegate.getEdgeType(e);
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
	 * Executes a step as given and adds it to the list of steps.
	 * 
	 * @param step
	 *            the step
	 * @throws Exception
	 */
	private void add(IStep step) throws Exception {
		try {
			step.execute();
			this.steps.add(step);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Appends a vertex id to the solution.
	 * 
	 * @param id
	 *            the id
	 * @throws Exception
	 */
	private void appendToSolution(String id) throws Exception {
		try {
			if (this.solution.length() == 0)
				this.solution.append("Solution: ");
			else
				this.solution.append(" - ");
			this.solution.append(id);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SortedSet<IVertex> getVerticesSorted() {
		// TODO
		// SortedSet<IVertex> s = new ;
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IVertex getStart() {
		for (IVertex v : this.delegate.getVertices())
			if (v.isStart())
				return v;
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IVertex getEnd() {
		for (IVertex v : this.delegate.getVertices())
			if (v.isEnd())
				return v;
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isVisited(IVertex v) {
		return ((IVertexStateHandler) v).isVisited();
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void stepBackEdge(IEdge e) throws Exception {
		try {
			IStep step = new BackEdgeStep(e);
			this.add(step);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void stepBackEdge(Iterable<IEdge> e) throws Exception {
		try {
			IStep step = new BackEdgeStep(e);
			this.add(step);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void stepCrossEdge(IEdge e) throws Exception {
		try {
			IStep step = new CrossEdgeStep(e);
			this.add(step);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void stepCrossEdge(Iterable<IEdge> e) throws Exception {
		try {
			IStep step = new CrossEdgeStep(e);
			this.add(step);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void stepForwardEdge(IEdge e) throws Exception {
		try {
			IStep step = new ForwardEdgeStep(e);
			this.add(step);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void stepForwardEdge(Iterable<IEdge> e) throws Exception {
		try {
			IStep step = new ForwardEdgeStep(e);
			this.add(step);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void stepDiscardedEdge(IEdge e) throws Exception {
		try {
			IStep step = new DiscardedEdgeStep(e);
			this.add(step);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void stepDiscardedEdge(Iterable<IEdge> e) throws Exception {
		try {
			IStep step = new DiscardedEdgeStep(e);
			this.add(step);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void stepInitializedVertex(Iterable<IVertex> i) throws Exception {
		try {
			IStep step = new InitializedVertexStep(i);
			this.add(step);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void stepInitializedVertex(IVertex s, Iterable<IVertex> i)
			throws Exception {
		try {
			IStep step = new InitializedVertexStep(s, i);
			this.add(step);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void stepUpdatedVertex(IVertex u, Integer value) throws Exception {
		try {
			IStep step = new UpdatedVertexStep(u, value);
			this.add(step);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void stepUpdatedVertex(Entry<Integer, IVertex> u) throws Exception {
		try {
			IStep step = new UpdatedVertexStep(u);
			this.add(step);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void stepVisit(IVertex v) throws Exception {
		try {
			IStep step = new VisitStep(v);
			this.add(step);
			this.appendToSolution(((ILayoutVertex) v).getId());
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void stepVisit(IEdge e) throws Exception {
		try {
			IStep step = new VisitStep(e);
			this.add(step);
			// TODO
			// this.appendToSolution(((ILayoutEdge) e).getId());
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void stepVisit(IVertex v, IEdge e) throws Exception {
		try {
			IStep step = new VisitStep(v, e);
			this.add(step);
			// TODO
			// this.appendToSolution(((ILayoutEdge) e).getId());
			this.appendToSolution(((ILayoutVertex) v).getId());
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void stepSolutionMember(IVertex v) throws Exception {
		try {
			IStep step = new SolutionMemberStep(v);
			this.add(step);
			this.appendToSolution(((ILayoutVertex) v).getId());
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void stepSolutionMember(IVertex v, IEdge e) throws Exception {
		try {
			IStep step = new SolutionMemberStep(v, e);
			this.add(step);
			this.appendToSolution(((ILayoutVertex) v).getId());
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public void stepSolutionMember(Iterable<Entry<IVertex, IEdge>> items)
			throws Exception {
		try {
			IStep step = new SolutionMemberStep(items);
			this.add(step);
		} catch (Exception ex) {
			throw ex;
		}
	}

}
