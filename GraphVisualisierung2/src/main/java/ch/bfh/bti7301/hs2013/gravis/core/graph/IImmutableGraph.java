package ch.bfh.bti7301.hs2013.gravis.core.graph;

import java.util.Collection;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.IGraphItem;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.graph.util.Pair;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
// TODO add comments from Graph class in JUNG API doc
public interface IImmutableGraph extends IGraphItemUpdate<IGraphItem> {

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
	public boolean containsEdge(IEdge edge);

	/**
	 * 
	 * @param vertex
	 * @return boolean
	 */
	public boolean containsVertex(IVertex vertex);

	/**
	 * 
	 * @param vertex
	 * @return int
	 */
	public int degree(IVertex vertex);

	/**
	 * 
	 * @param v1
	 * @param v2
	 * @return IEdge
	 */
	public IEdge findEdge(IVertex v1, IVertex v2);

	/**
	 * 
	 * @param v1
	 * @param v2
	 * @return Collection
	 */
	public Collection<? extends IEdge> findEdgeSet(IVertex v1, IVertex v2);

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
	public EdgeType getEdgeType(IEdge edge);

	/**
	 * 
	 * @return Collection
	 */
	public Collection<? extends IEdge> getEdges();

	/**
	 * 
	 * @param edge_type
	 * @return Collection
	 */
	public Collection<? extends IEdge> getEdges(EdgeType edge_type);

	/**
	 * 
	 * @param edge
	 * @return int
	 */
	public int getIncidentCount(IEdge edge);

	/**
	 * 
	 * @param vertex
	 * @return Collection
	 */
	public Collection<? extends IEdge> getIncidentEdges(IVertex vertex);

	/**
	 * 
	 * @param edge
	 * @return Collection
	 */
	public Collection<? extends IVertex> getIncidentVertices(IEdge edge);

	/**
	 * 
	 * @param vertex
	 * @return int
	 */
	public int getNeighborCount(IVertex vertex);

	/**
	 * 
	 * @param vertex
	 * @return Collection
	 */
	public Collection<? extends IVertex> getNeighbors(IVertex vertex);

	/**
	 * 
	 * @return int
	 */
	public int getVertexCount();

	/**
	 * 
	 * @return Collection
	 */
	public Collection<? extends IVertex> getVertices();

	/**
	 * 
	 * @param vertex
	 * @param edge
	 * @return boolean
	 */
	public boolean isIncident(IVertex vertex, IEdge edge);

	/**
	 * 
	 * @param v1
	 * @param v2
	 * @return boolean
	 */
	public boolean isNeighbor(IVertex v1, IVertex v2);

	/**
	 * 
	 * @param directed_edge
	 * @return IVertex
	 */
	public IVertex getDest(IEdge directed_edge);

	/**
	 * 
	 * @param edge
	 * @return Pair
	 */
	public Pair<? extends IVertex> getEndpoints(IEdge edge);

	/**
	 * 
	 * @param vertex
	 * @return Collection
	 */
	public Collection<? extends IEdge> getInEdges(IVertex vertex);

	/**
	 * 
	 * @param vertex
	 * @param edge
	 * @return IVertex
	 */
	public IVertex getOpposite(IVertex vertex, IEdge edge);

	/**
	 * 
	 * @param vertex
	 * @return Collection<IEdge>
	 */
	public Collection<? extends IEdge> getOutEdges(IVertex vertex);

	/**
	 * 
	 * @param vertex
	 * @return int
	 */
	public int getPredecessorCount(IVertex vertex);

	/**
	 * 
	 * @param vertex
	 * @return Collection
	 */
	public Collection<? extends IVertex> getPredecessors(IVertex vertex);

	/**
	 * 
	 * @param directed_edge
	 * @return IVertex
	 */
	public IVertex getSource(IEdge directed_edge);

	/**
	 * 
	 * @param vertex
	 * @return int
	 */
	public int getSuccessorCount(IVertex vertex);

	/**
	 * 
	 * @param vertex
	 * @return Collection
	 */
	public Collection<? extends IVertex> getSuccessors(IVertex vertex);

	/**
	 * 
	 * @param vertex
	 * @return int
	 */
	public int inDegree(IVertex vertex);

	/**
	 * 
	 * @param vertex
	 * @param edge
	 * @return boolean
	 */
	public boolean isDest(IVertex vertex, IEdge edge);

	/**
	 * 
	 * @param v1
	 * @param v2
	 * @return boolean
	 */
	public boolean isPredecessor(IVertex v1, IVertex v2);

	/**
	 * 
	 * @param vertex
	 * @param edge
	 * @return boolean
	 */
	public boolean isSource(IVertex vertex, IEdge edge);

	/**
	 * 
	 * @param v1
	 * @param v2
	 * @return boolean
	 */
	public boolean isSuccessor(IVertex v1, IVertex v2);

	/**
	 * 
	 * @param vertex
	 * @return int
	 */
	public int outDegree(IVertex vertex);

	/**
	 * 
	 * @return IVertex
	 */
	public IVertex getStartVertex();

}
