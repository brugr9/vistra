package vistra.core.graph;

import java.util.Collection;

import vistra.core.graph.item.IRestrictedGraphItem;
import vistra.core.graph.item.edge.IRestrictedEdge;
import vistra.core.graph.item.vertex.IRestrictedVertex;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.graph.util.Pair;

/**
 * A restricted graph interface.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
// TODO add comments from Graph class in JUNG API doc
public interface IRestrictedGraph extends
		IGraphItemUpdate<IRestrictedGraphItem> {

	/**
	 * 
	 * @return boolean
	 */
	public abstract boolean isEmpty();

	/**
	 * 
	 * @param edge
	 * @return boolean
	 */
	public boolean containsEdge(IRestrictedEdge edge);

	/**
	 * 
	 * @param vertex
	 * @return boolean
	 */
	public boolean containsVertex(IRestrictedVertex vertex);

	/**
	 * 
	 * @param vertex
	 * @return int
	 */
	public int degree(IRestrictedVertex vertex);

	/**
	 * 
	 * @param v1
	 * @param v2
	 * @return IRestrictedEdge
	 */
	public IRestrictedEdge findEdge(IRestrictedVertex v1, IRestrictedVertex v2);

	/**
	 * 
	 * @param v1
	 * @param v2
	 * @return Collection
	 */
	public Collection<? extends IRestrictedEdge> findEdgeSet(
			IRestrictedVertex v1, IRestrictedVertex v2);

	/**
	 * 
	 * @return EdgeType
	 */
	public EdgeType getDefaultEdgeType();

	/**
	 * 
	 * @return int
	 */
	public int getEdgeCount();

	/**
	 * 
	 * @param edge_type
	 * @return int
	 */
	public int getEdgeCount(EdgeType edge_type);

	/**
	 * 
	 * @param edge
	 * @return EdgeType
	 */
	public EdgeType getEdgeType(IRestrictedEdge edge);

	/**
	 * 
	 * @return Collection
	 */
	public Collection<? extends IRestrictedEdge> getEdges();

	/**
	 * 
	 * @param edge_type
	 * @return Collection
	 */
	public Collection<? extends IRestrictedEdge> getEdges(EdgeType edge_type);

	/**
	 * 
	 * @param edge
	 * @return int
	 */
	public int getIncidentCount(IRestrictedEdge edge);

	/**
	 * 
	 * @param vertex
	 * @return Collection
	 */
	public Collection<? extends IRestrictedEdge> getIncidentEdges(
			IRestrictedVertex vertex);

	/**
	 * 
	 * @param edge
	 * @return Collection
	 */
	public Collection<? extends IRestrictedVertex> getIncidentVertices(
			IRestrictedEdge edge);

	/**
	 * 
	 * @param vertex
	 * @return int
	 */
	public int getNeighborCount(IRestrictedVertex vertex);

	/**
	 * 
	 * @param vertex
	 * @return Collection
	 */
	public Collection<? extends IRestrictedVertex> getNeighbors(
			IRestrictedVertex vertex);

	/**
	 * 
	 * @return int
	 */
	public int getVertexCount();

	/**
	 * The first vertex in the collection is the start vertex.
	 * 
	 * @return Collection
	 */
	public Collection<? extends IRestrictedVertex> getVertices();

	/**
	 * 
	 * @param vertex
	 * @param edge
	 * @return boolean
	 */
	public boolean isIncident(IRestrictedVertex vertex, IRestrictedEdge edge);

	/**
	 * 
	 * @param v1
	 * @param v2
	 * @return boolean
	 */
	public boolean isNeighbor(IRestrictedVertex v1, IRestrictedVertex v2);

	/**
	 * 
	 * @param directed_edge
	 * @return IRestrictedVertex
	 */
	public IRestrictedVertex getDest(IRestrictedEdge directed_edge);

	/**
	 * 
	 * @param edge
	 * @return Pair
	 */
	public Pair<? extends IRestrictedVertex> getEndpoints(IRestrictedEdge edge);

	/**
	 * 
	 * @param vertex
	 * @return Collection
	 */
	public Collection<? extends IRestrictedEdge> getInEdges(
			IRestrictedVertex vertex);

	/**
	 * 
	 * @param vertex
	 * @param edge
	 * @return IRestrictedVertex
	 */
	public IRestrictedVertex getOpposite(IRestrictedVertex vertex,
			IRestrictedEdge edge);

	/**
	 * 
	 * @param vertex
	 * @return Collection<IRestrictedEdge>
	 */
	public Collection<? extends IRestrictedEdge> getOutEdges(
			IRestrictedVertex vertex);

	/**
	 * 
	 * @param vertex
	 * @return int
	 */
	public int getPredecessorCount(IRestrictedVertex vertex);

	/**
	 * 
	 * @param vertex
	 * @return Collection
	 */
	public Collection<? extends IRestrictedVertex> getPredecessors(
			IRestrictedVertex vertex);

	/**
	 * 
	 * @param directed_edge
	 * @return IRestrictedVertex
	 */
	public IRestrictedVertex getSource(IRestrictedEdge directed_edge);

	/**
	 * 
	 * @param vertex
	 * @return int
	 */
	public int getSuccessorCount(IRestrictedVertex vertex);

	/**
	 * 
	 * @param vertex
	 * @return Collection
	 */
	public Collection<? extends IRestrictedVertex> getSuccessors(
			IRestrictedVertex vertex);

	/**
	 * 
	 * @param vertex
	 * @return int
	 */
	public int inDegree(IRestrictedVertex vertex);

	/**
	 * 
	 * @param vertex
	 * @param edge
	 * @return boolean
	 */
	public boolean isDest(IRestrictedVertex vertex, IRestrictedEdge edge);

	/**
	 * 
	 * @param v1
	 * @param v2
	 * @return boolean
	 */
	public boolean isPredecessor(IRestrictedVertex v1, IRestrictedVertex v2);

	/**
	 * 
	 * @param vertex
	 * @param edge
	 * @return boolean
	 */
	public boolean isSource(IRestrictedVertex vertex, IRestrictedEdge edge);

	/**
	 * 
	 * @param v1
	 * @param v2
	 * @return boolean
	 */
	public boolean isSuccessor(IRestrictedVertex v1, IRestrictedVertex v2);

	/**
	 * 
	 * @param vertex
	 * @return int
	 */
	public int outDegree(IRestrictedVertex vertex);

	/**
	 * 
	 * @return IRestrictedVertex
	 */
	public IRestrictedVertex getStartVertex();

	/**
	 * 
	 * @return EdgeType
	 */
	public abstract EdgeType getEdgeType();

}
