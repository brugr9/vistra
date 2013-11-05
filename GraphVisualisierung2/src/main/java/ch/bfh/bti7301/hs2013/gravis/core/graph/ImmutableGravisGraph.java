package ch.bfh.bti7301.hs2013.gravis.core.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections15.BidiMap;
import org.apache.commons.collections15.bidimap.DualHashBidiMap;

import ch.bfh.bti7301.hs2013.gravis.common.IEdge;
import ch.bfh.bti7301.hs2013.gravis.common.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.common.IImmutableGraph;
import ch.bfh.bti7301.hs2013.gravis.common.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.EdgeFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.VertexFactory;
import ch.bfh.bti7301.hs2013.gravis.core.util.ItemComparator;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.graph.util.Pair;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
final class ImmutableGravisGraph implements IImmutableGraph {

	private final IObservableGravisGraph delegate;

	private final List<IVertex> verticesList;
	private final List<IEdge> edgesList;

	private final BidiMap<IVertex, IVertex> verticesMap;
	private final BidiMap<IEdge, IEdge> edgesMap;

	/**
	 * @param graph
	 */
	ImmutableGravisGraph(IObservableGravisGraph graph) {
		this.delegate = graph;
		this.verticesMap = new DualHashBidiMap<>();
		this.edgesMap = new DualHashBidiMap<>();
		this.verticesList = this.getRestrictedSortedVerticesList(
				this.delegate.getVertices(), this.verticesMap);
		this.edgesList = this.getRestrictedSortedEdgesList(
				this.delegate.getEdges(), this.edgesMap);
	}

	/**
	 * @param coll
	 * @param edgesMap
	 * @return List<IEdge>
	 */
	private List<IEdge> getRestrictedSortedEdgesList(Collection<IEdge> coll,
			BidiMap<IEdge, IEdge> edgesMap) {
		List<IEdge> edgesList = new ArrayList<>(coll.size());

		// Adds restricted vertex instances to the vertices list
		for (IEdge edge : coll) {
			if (edgesMap.containsValue(edge)) {
				edgesList.add(edgesMap.getKey(edge));
			} else {
				IEdge restrictedEdge = EdgeFactory
						.createRestrictedGravisEdge(edge);
				edgesMap.put(restrictedEdge, edge);
				edgesList.add(restrictedEdge);
			}
		}

		// Sorts the vertices in lexicographical id order
		Collections.sort(edgesList, new ItemComparator<IEdge>());

		return edgesList;
	}

	/**
	 * @param coll
	 * @param verticesMap
	 * @return List<IVertex>
	 */
	private List<IVertex> getRestrictedSortedVerticesList(
			Collection<IVertex> coll, BidiMap<IVertex, IVertex> verticesMap) {
		List<IVertex> verticesList = new ArrayList<>(coll.size());

		// Adds restricted vertex instances to the vertices list
		for (IVertex vertex : coll) {
			if (verticesMap.containsValue(vertex)) {
				verticesList.add(verticesMap.getKey(vertex));
			} else {
				IVertex restrictedVertex = VertexFactory
						.createRestrictedGravisVertex(vertex);
				verticesMap.put(restrictedVertex, vertex);
				verticesList.add(restrictedVertex);
			}
		}

		// Sorts the vertices in lexicographical id order
		Collections.sort(verticesList, new ItemComparator<IVertex>());

		// moves the start vertex to the first position in the list
		for (int i = 0; i < verticesList.size(); i++) {
			if (verticesList.get(i).isStart()) {
				verticesList.add(0, verticesList.remove(i));
				break;
			}
		}

		return verticesList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGraphItemUpdate#updateState
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.IItem)
	 */
	@Override
	public void updateState(IGraphItem item) {
		IGraphItem original = null;

		if (item instanceof IVertex) {
			original = this.verticesMap.get(item);
		}

		if (item instanceof IEdge) {
			original = this.edgesMap.get(item);
		}

		if (original != null) {
			this.delegate.updateState(original);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return this.delegate.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#containsEdge(
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge)
	 */
	@Override
	public boolean containsEdge(IEdge edge) {
		return this.delegate.containsEdge(edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#containsVertex
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex)
	 */
	@Override
	public boolean containsVertex(IVertex vertex) {
		return this.delegate.containsVertex(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#degree(ch.bfh
	 * .bti7301.hs2013.gravis.core.graph.item.vertex.IVertex)
	 */
	@Override
	public int degree(IVertex vertex) {
		return this.delegate.degree(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#findEdge(ch.bfh
	 * .bti7301.hs2013.gravis.core.graph.item.vertex.IVertex,
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex)
	 */
	@Override
	public IEdge findEdge(IVertex v1, IVertex v2) {
		return this.edgesMap.getKey(this.delegate.findEdge(v1, v2));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#findEdgeSet(ch
	 * .bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex,
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex)
	 */
	@Override
	public Collection<? extends IEdge> findEdgeSet(IVertex v1, IVertex v2) {
		return this.getRestrictedSortedEdgesList(
				this.delegate.findEdgeSet(v1, v2), this.edgesMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getDefaultEdgeType
	 * ()
	 */
	@Override
	public EdgeType getDefaultEdgeType() {
		return this.delegate.getDefaultEdgeType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getEdgeCount()
	 */
	@Override
	public int getEdgeCount() {
		return this.delegate.getEdgeCount();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getEdgeCount(
	 * edu.uci.ics.jung.graph.util.EdgeType)
	 */
	@Override
	public int getEdgeCount(EdgeType edge_type) {
		return this.delegate.getEdgeCount(edge_type);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getEdgeType(ch
	 * .bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge)
	 */
	@Override
	public EdgeType getEdgeType(IEdge edge) {
		return this.delegate.getEdgeType(edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getEdges()
	 */
	@Override
	public Collection<? extends IEdge> getEdges() {
		return this.edgesList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getEdges(edu.
	 * uci.ics.jung.graph.util.EdgeType)
	 */
	@Override
	public Collection<? extends IEdge> getEdges(EdgeType edge_type) {
		return this.getRestrictedSortedEdgesList(
				this.delegate.getEdges(edge_type), this.edgesMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getIncidentCount
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge)
	 */
	@Override
	public int getIncidentCount(IEdge edge) {
		return this.delegate.getIncidentCount(edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getIncidentEdges
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex)
	 */
	@Override
	public Collection<? extends IEdge> getIncidentEdges(IVertex vertex) {
		return this.getRestrictedSortedEdgesList(
				this.delegate.getIncidentEdges(vertex), this.edgesMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getIncidentVertices
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge)
	 */
	@Override
	public Collection<? extends IVertex> getIncidentVertices(IEdge edge) {
		return this.getRestrictedSortedVerticesList(
				this.delegate.getIncidentVertices(edge), this.verticesMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getNeighborCount
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex)
	 */
	@Override
	public int getNeighborCount(IVertex vertex) {
		return this.delegate.getNeighborCount(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getNeighbors(
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex)
	 */
	@Override
	public Collection<? extends IVertex> getNeighbors(IVertex vertex) {
		return this.getRestrictedSortedVerticesList(
				this.delegate.getNeighbors(vertex), this.verticesMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getVertexCount()
	 */
	@Override
	public int getVertexCount() {
		return this.delegate.getVertexCount();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getVertices()
	 */
	@Override
	public Collection<? extends IVertex> getVertices() {
		return this.verticesList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#isIncident(ch
	 * .bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex,
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge)
	 */
	@Override
	public boolean isIncident(IVertex vertex, IEdge edge) {
		return this.delegate.isIncident(vertex, edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#isNeighbor(ch
	 * .bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex,
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex)
	 */
	@Override
	public boolean isNeighbor(IVertex v1, IVertex v2) {
		return this.delegate.isNeighbor(v1, v2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getDest(ch.bfh
	 * .bti7301.hs2013.gravis.core.graph.item.edge.IEdge)
	 */
	@Override
	public IVertex getDest(IEdge directed_edge) {
		return this.verticesMap.getKey(this.delegate.getDest(directed_edge));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getEndpoints(
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge)
	 */
	@Override
	public Pair<? extends IVertex> getEndpoints(IEdge edge) {
		List<IVertex> verticesList = new ArrayList<>();

		// wraps the endpoints into restricted vertex instances
		for (IVertex vertex : this.delegate.getEndpoints(edge)) {
			if (this.verticesMap.containsValue(vertex)) {
				verticesList.add(this.verticesMap.getKey(vertex));
			}
		}

		return new Pair<IVertex>(verticesList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getInEdges(ch
	 * .bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex)
	 */
	@Override
	public Collection<? extends IEdge> getInEdges(IVertex vertex) {
		return this.getRestrictedSortedEdgesList(
				this.delegate.getInEdges(vertex), this.edgesMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getOpposite(ch
	 * .bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex,
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge)
	 */
	@Override
	public IVertex getOpposite(IVertex vertex, IEdge edge) {
		return this.verticesMap.getKey(this.delegate.getOpposite(vertex, edge));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getOutEdges(ch
	 * .bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex)
	 */
	@Override
	public Collection<? extends IEdge> getOutEdges(IVertex vertex) {
		return this.getRestrictedSortedEdgesList(
				this.delegate.getOutEdges(vertex), this.edgesMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getPredecessorCount
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex)
	 */
	@Override
	public int getPredecessorCount(IVertex vertex) {
		return this.delegate.getPredecessorCount(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getPredecessors
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex)
	 */
	@Override
	public Collection<? extends IVertex> getPredecessors(IVertex vertex) {
		return this.getRestrictedSortedVerticesList(
				this.delegate.getPredecessors(vertex), this.verticesMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getSource(ch.
	 * bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge)
	 */
	@Override
	public IVertex getSource(IEdge directed_edge) {
		return this.verticesMap.getKey(this.getSource(directed_edge));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getSuccessorCount
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex)
	 */
	@Override
	public int getSuccessorCount(IVertex vertex) {
		return this.delegate.getSuccessorCount(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#getSuccessors
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex)
	 */
	@Override
	public Collection<? extends IVertex> getSuccessors(IVertex vertex) {
		return this.getRestrictedSortedVerticesList(
				this.delegate.getSuccessors(vertex), this.verticesMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#inDegree(ch.bfh
	 * .bti7301.hs2013.gravis.core.graph.item.vertex.IVertex)
	 */
	@Override
	public int inDegree(IVertex vertex) {
		return this.delegate.inDegree(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#isDest(ch.bfh
	 * .bti7301.hs2013.gravis.core.graph.item.vertex.IVertex,
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge)
	 */
	@Override
	public boolean isDest(IVertex vertex, IEdge edge) {
		return this.delegate.isDest(vertex, edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#isPredecessor
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex,
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex)
	 */
	@Override
	public boolean isPredecessor(IVertex v1, IVertex v2) {
		return this.delegate.isPredecessor(v1, v2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#isSource(ch.bfh
	 * .bti7301.hs2013.gravis.core.graph.item.vertex.IVertex,
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge)
	 */
	@Override
	public boolean isSource(IVertex vertex, IEdge edge) {
		return this.delegate.isSource(vertex, edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#isSuccessor(ch
	 * .bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex,
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex)
	 */
	@Override
	public boolean isSuccessor(IVertex v1, IVertex v2) {
		return this.delegate.isSuccessor(v1, v2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IImmutableGraph#outDegree(ch.
	 * bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex)
	 */
	@Override
	public int outDegree(IVertex vertex) {
		return this.delegate.outDegree(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.common.IImmutableGraph#getStartVertex()
	 */
	@Override
	public IVertex getStartVertex() {
		if (this.verticesList.isEmpty()) {
			return null;
		}

		return this.verticesList.get(0);
	}

}
