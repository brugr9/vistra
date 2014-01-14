package vistra.framework.graph;

import java.util.ArrayList;
import java.util.Collection;

import vistra.framework.graph.item.ILayoutEdge;
import vistra.framework.graph.item.ILayoutItem;
import vistra.framework.graph.item.ILayoutVertex;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.ObservableGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An extended JUNG observable graph.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class LayoutGraph extends ObservableGraph<ILayoutVertex, ILayoutEdge>
		implements ILayoutGraph {

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
	LayoutGraph(Graph<ILayoutVertex, ILayoutEdge> delegate) {
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
	@Override
	public boolean unusedId(String id) {
		Collection<ILayoutItem> items = new ArrayList<ILayoutItem>();
		items.addAll((Collection<? extends ILayoutItem>) this.getVertices());
		items.addAll((Collection<? extends ILayoutItem>) this.getEdges());
		for (ILayoutItem item : items) {
			if (item.getId() == id) {
				return false;
			}
		}
		return true;
	}

}
