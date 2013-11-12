package ch.bfh.bti7301.hs2013.gravis.core.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections15.BidiMap;
import org.apache.commons.collections15.bidimap.DualHashBidiMap;
import org.apache.commons.collections15.map.HashedMap;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IRestrictedGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.EdgeFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.VertexFactory;
import ch.bfh.bti7301.hs2013.gravis.core.util.ItemComparator;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.graph.util.Pair;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
final class RestrictedGraph implements IRestrictedGraph {

	private final Graph<IRestrictedVertex, IRestrictedEdge> restrictedGraph;
	private final IObservableGravisGraph observableGravisGraph;

	private final List<IRestrictedVertex> verticesList;
	private final List<IRestrictedEdge> edgesList;

	/**
	 * @param graph
	 */
	RestrictedGraph(IObservableGravisGraph graph) {
		this.observableGravisGraph = graph;
		// TODO bitte an dieser KLasse nichts ändern (pk)
		// TODO use factory method
		this.restrictedGraph = new SparseGraph<>();
		Map<IVertex, IRestrictedVertex> verticesMap = new HashedMap<>();
		
		for (IVertex vertex : graph.getVertices()) {
			IRestrictedVertex restrictedVertex = VertexFactory.createRestrictedVertex(vertex);
			verticesMap.put(vertex, restrictedVertex);
			this.restrictedGraph.addVertex(restrictedVertex);
		}
		
		for (IEdge edge : graph.getEdges()) {
			Collection<IVertex> incidentVertices = graph.getIncidentVertices(edge);
			List<IRestrictedVertex> restrictedIncidentVertices = 
					new ArrayList<>(incidentVertices.size());
			
			for (IRestrictedVertex incidentVertex : incidentVertices) {
				restrictedIncidentVertices.add(verticesMap.get(incidentVertex));
			}		
					
			this.restrictedGraph.addEdge(EdgeFactory.createRestrictedEdge(edge), 
					restrictedIncidentVertices);
		}
		
		this.verticesList = this.getRestrictedSortedVerticesList(
				this.restrictedGraph.getVertices());
		this.edgesList = this.getRestrictedSortedEdgesList(
				this.restrictedGraph.getEdges());
	}

	/**
	 * @param coll
	 * @param edgesMap
	 * @return List<IRestrictedEdge>
	 */
	private List<IRestrictedEdge> getRestrictedSortedEdgesList(
			Collection<? extends IRestrictedEdge> coll) {
		List<IRestrictedEdge> edgesList = new ArrayList<>(coll.size());

		// Adds restricted vertex instances to the vertices list
		for (IRestrictedEdge edge : coll) {
				edgesList.add(edge);
		}

		// Sorts the vertices in lexicographical id order
		Collections.sort(edgesList, new ItemComparator());

		return edgesList;
	}

	/**
	 * @param coll
	 * @return List<IRestrictedVertex>
	 */
	private List<IRestrictedVertex> getRestrictedSortedVerticesList(
			Collection <? extends IRestrictedVertex> coll) {
		List<IRestrictedVertex> verticesList = new ArrayList<>(coll.size());

		// Adds restricted vertex instances to the vertices list
		for (IRestrictedVertex vertex : coll) {
			verticesList.add(vertex);
		}

		// Sorts the vertices in lexicographical id order
		Collections.sort(verticesList, new ItemComparator());

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
	public void updateState(IRestrictedGraphItem item) {
//		IGraphItem original = null;
//
//		if (item instanceof IRestrictedVertex) {
//			original = this.verticesMap.get(item);
//		}
//
//		if (item instanceof IRestrictedEdge) {
//			original = this.edgesMap.get(item);
//		}
//
//		if (original != null) {
//			this.restrictedGraph.updateState(original);
//		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
//		return this.restrictedGraph.isEmpty();
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#containsEdge(
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge)
	 */
	@Override
	public boolean containsEdge(IRestrictedEdge edge) {
		return this.restrictedGraph.containsEdge(edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#containsVertex
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex)
	 */
	@Override
	public boolean containsVertex(IRestrictedVertex vertex) {
		return this.restrictedGraph.containsVertex(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#degree(ch.bfh
	 * .bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex)
	 */
	@Override
	public int degree(IRestrictedVertex vertex) {
		return this.restrictedGraph.degree(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#findEdge(ch.bfh
	 * .bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex,
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex)
	 */
	@Override
	public IRestrictedEdge findEdge(IRestrictedVertex v1, IRestrictedVertex v2) {
//		return this.edgesMap.getKey(this.restrictedGraph.findEdge(v1, v2));
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#findEdgeSet(ch
	 * .bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex,
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex)
	 */
	@Override
	public Collection<? extends IRestrictedEdge> findEdgeSet(IRestrictedVertex v1, IRestrictedVertex v2) {
//		return this.getRestrictedSortedEdgesList(
//				this.restrictedGraph.findEdgeSet(v1, v2), this.edgesMap);
		
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getDefaultEdgeType
	 * ()
	 */
	@Override
	public EdgeType getDefaultEdgeType() {
		return this.restrictedGraph.getDefaultEdgeType();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getEdgeCount()
	 */
	@Override
	public int getEdgeCount() {
		return this.restrictedGraph.getEdgeCount();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getEdgeCount(
	 * edu.uci.ics.jung.graph.util.EdgeType)
	 */
	@Override
	public int getEdgeCount(EdgeType edge_type) {
		return this.restrictedGraph.getEdgeCount(edge_type);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getEdgeType(ch
	 * .bfh.bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge)
	 */
	@Override
	public EdgeType getEdgeType(IRestrictedEdge edge) {
		return this.restrictedGraph.getEdgeType(edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getEdges()
	 */
	@Override
	public Collection<? extends IRestrictedEdge> getEdges() {
		return this.edgesList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getEdges(edu.
	 * uci.ics.jung.graph.util.EdgeType)
	 */
	@Override
	public Collection<? extends IRestrictedEdge> getEdges(EdgeType edge_type) {
//		return this.getRestrictedSortedEdgesList(
//				this.restrictedGraph.getEdges(edge_type), this.edgesMap);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getIncidentCount
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge)
	 */
	@Override
	public int getIncidentCount(IRestrictedEdge edge) {
		return this.restrictedGraph.getIncidentCount(edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getIncidentEdges
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex)
	 */
	@Override
	public Collection<? extends IRestrictedEdge> getIncidentEdges(IRestrictedVertex vertex) {
//		return this.getRestrictedSortedEdgesList(
//				this.restrictedGraph.getIncidentEdges(vertex), this.edgesMap);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getIncidentVertices
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge)
	 */
	@Override
	public Collection<? extends IRestrictedVertex> getIncidentVertices(IRestrictedEdge edge) {
//		return this.getRestrictedSortedVerticesList(
//				this.restrictedGraph.getIncidentVertices(edge), this.verticesMap);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getNeighborCount
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex)
	 */
	@Override
	public int getNeighborCount(IRestrictedVertex vertex) {
		return this.restrictedGraph.getNeighborCount(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getNeighbors(
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex)
	 */
	@Override
	public Collection<? extends IRestrictedVertex> getNeighbors(IRestrictedVertex vertex) {
//		return this.getRestrictedSortedVerticesList(
//				this.restrictedGraph.getNeighbors(vertex), this.verticesMap);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getVertexCount()
	 */
	@Override
	public int getVertexCount() {
		return this.restrictedGraph.getVertexCount();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getVertices()
	 */
	@Override
	public Collection<? extends IRestrictedVertex> getVertices() {
		return this.verticesList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#isIncident(ch
	 * .bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex,
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge)
	 */
	@Override
	public boolean isIncident(IRestrictedVertex vertex, IRestrictedEdge edge) {
		return this.restrictedGraph.isIncident(vertex, edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#isNeighbor(ch
	 * .bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex,
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex)
	 */
	@Override
	public boolean isNeighbor(IRestrictedVertex v1, IRestrictedVertex v2) {
		return this.restrictedGraph.isNeighbor(v1, v2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getDest(ch.bfh
	 * .bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge)
	 */
	@Override
	public IRestrictedVertex getDest(IRestrictedEdge directed_edge) {
//		return this.verticesMap.getKey(this.restrictedGraph.getDest(directed_edge));
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getEndpoints(
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge)
	 */
	@Override
	public Pair<? extends IRestrictedVertex> getEndpoints(IRestrictedEdge edge) {
		List<IRestrictedVertex> verticesList = new ArrayList<>();

//		// wraps the endpoints into restricted vertex instances
//		for (IRestrictedVertex vertex : this.restrictedGraph.getEndpoints(edge)) {
//			if (this.verticesMap.containsValue(vertex)) {
//				verticesList.add(this.verticesMap.getKey(vertex));
//			}
//		}
//
//		return new Pair<IRestrictedVertex>(verticesList);
		
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getInEdges(ch
	 * .bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex)
	 */
	@Override
	public Collection<? extends IRestrictedEdge> getInEdges(IRestrictedVertex vertex) {
//		return this.getRestrictedSortedEdgesList(
//				this.restrictedGraph.getInEdges(vertex), this.edgesMap);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getOpposite(ch
	 * .bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex,
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge)
	 */
	@Override
	public IRestrictedVertex getOpposite(IRestrictedVertex vertex, IRestrictedEdge edge) {
//		return this.verticesMap.getKey(this.restrictedGraph.getOpposite(vertex, edge));
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getOutEdges(ch
	 * .bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex)
	 */
	@Override
	public Collection<? extends IRestrictedEdge> getOutEdges(IRestrictedVertex vertex) {
//		return this.getRestrictedSortedEdgesList(
//				this.restrictedGraph.getOutEdges(vertex), this.edgesMap);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getPredecessorCount
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex)
	 */
	@Override
	public int getPredecessorCount(IRestrictedVertex vertex) {
		return this.restrictedGraph.getPredecessorCount(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getPredecessors
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex)
	 */
	@Override
	public Collection<? extends IRestrictedVertex> getPredecessors(IRestrictedVertex vertex) {
//		return this.getRestrictedSortedVerticesList(
//				this.restrictedGraph.getPredecessors(vertex), this.verticesMap);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getSource(ch.
	 * bfh.bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge)
	 */
	@Override
	public IRestrictedVertex getSource(IRestrictedEdge directed_edge) {
//		return this.verticesMap.getKey(this.getSource(directed_edge));
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getSuccessorCount
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex)
	 */
	@Override
	public int getSuccessorCount(IRestrictedVertex vertex) {
		return this.restrictedGraph.getSuccessorCount(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#getSuccessors
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex)
	 */
	@Override
	public Collection<? extends IRestrictedVertex> getSuccessors(IRestrictedVertex vertex) {
//		return this.getRestrictedSortedVerticesList(
//				this.restrictedGraph.getSuccessors(vertex), this.verticesMap);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#inDegree(ch.bfh
	 * .bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex)
	 */
	@Override
	public int inDegree(IRestrictedVertex vertex) {
		return this.restrictedGraph.inDegree(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#isDest(ch.bfh
	 * .bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex,
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge)
	 */
	@Override
	public boolean isDest(IRestrictedVertex vertex, IRestrictedEdge edge) {
		return this.restrictedGraph.isDest(vertex, edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#isPredecessor
	 * (ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex,
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex)
	 */
	@Override
	public boolean isPredecessor(IRestrictedVertex v1, IRestrictedVertex v2) {
		return this.restrictedGraph.isPredecessor(v1, v2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#isSource(ch.bfh
	 * .bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex,
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IRestrictedEdge)
	 */
	@Override
	public boolean isSource(IRestrictedVertex vertex, IRestrictedEdge edge) {
		return this.restrictedGraph.isSource(vertex, edge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#isSuccessor(ch
	 * .bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex,
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex)
	 */
	@Override
	public boolean isSuccessor(IRestrictedVertex v1, IRestrictedVertex v2) {
		return this.restrictedGraph.isSuccessor(v1, v2);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph#outDegree(ch.
	 * bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IRestrictedVertex)
	 */
	@Override
	public int outDegree(IRestrictedVertex vertex) {
		return this.restrictedGraph.outDegree(vertex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.common.IImmutableGraph#getStartVertex()
	 */
	@Override
	public IRestrictedVertex getStartVertex() {
		if (this.verticesList.isEmpty()) {
			return null;
		}

		return this.verticesList.get(0);
	}

}
