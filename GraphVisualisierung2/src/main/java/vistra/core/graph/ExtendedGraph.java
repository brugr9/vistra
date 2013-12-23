package vistra.core.graph;

import java.util.ArrayList;
import java.util.Collection;

import vistra.core.graph.item.IItem;
import vistra.core.graph.item.edge.Edge;
import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import vistra.core.graph.item.vertex.Vertex;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.ObservableGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An extended JUNG observable graph.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class ExtendedGraph extends ObservableGraph<IVertex, IEdge> implements
		IExtendedGraph {

	private static final long serialVersionUID = 7604897874620015084L;

	/**
	 * A field for a name.
	 */
	private String name;

	/**
	 * A field for an edge type.
	 */
	private EdgeType edgeType;

	/**
	 * Main constructor.
	 * 
	 * @param delegate
	 *            the graph to delegate
	 */
	public ExtendedGraph(Graph<IVertex, IEdge> delegate) {
		super(delegate);
		this.edgeType = EdgeType.UNDIRECTED;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EdgeType getEdgeType() {
		return this.edgeType;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEdgeType(EdgeType edgeType) {
		this.edgeType = edgeType;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean containsItemId(String id) {
		ArrayList<IItem> items = new ArrayList<IItem>();
		items.addAll((Collection<? extends IItem>) ((Edge) this.getEdges()));
		items.addAll((Collection<? extends IItem>) ((Vertex) this
				.getVertices()));
		for (IItem item : items) {
			if (item.getId() == id) {
				return true;
			}
		}
		return false;
	}

}
