package vistra.core.graph;

import java.util.ArrayList;
import java.util.Collection;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IItemLayout;
import vistra.core.graph.item.IVertexLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.ObservableGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An extended JUNG observable graph.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class ExtendedGraph extends ObservableGraph<IVertexLayout, IEdgeLayout>
		implements IExtendedGraph {

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
	public ExtendedGraph(Graph<IVertexLayout, IEdgeLayout> delegate) {
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

		ArrayList<IItemLayout> items = new ArrayList<IItemLayout>();
		items.addAll((Collection<? extends IItemLayout>) this.getVertices());
		items.addAll((Collection<? extends IItemLayout>) this.getEdges());
		for (IItemLayout item : items) {
			if (item.getId() == id) {
				return false;
			}
		}
		return true;

	}

}
