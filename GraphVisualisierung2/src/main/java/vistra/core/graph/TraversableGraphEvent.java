package vistra.core.graph;

import edu.uci.ics.jung.graph.Graph;

/**
 * An abstract traversal event.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @param <V>
 *            the vertex type
 * @param <E>
 *            the edge type
 */
public abstract class TraversableGraphEvent<V, E> {

	protected Graph<V, E> source;
	protected Type type;

	/**
	 * Creates an instance with the specified {@code source} graph and
	 * {@code Type} (vertex/edge addition/removal).
	 */
	public TraversableGraphEvent(Graph<V, E> source, Type type) {
		this.source = source;
		this.type = type;
	}

	/**
	 * Types of graph events.
	 */
	public static enum Type {
		/**/
		VISIT_VERTEX,
		/**/
		DISCOVERY_EDGE, BACK_EDGE, CROSS_EDGE, FORWARD_EDGE, DISCARDED_EDGE, SOLUTION_EDGE,
	}

	/**
	 * An event type pertaining to graph vertices.
	 */
	public static class Vertex<V, E> extends TraversableGraphEvent<V, E> {
		protected V vertex;

		/**
		 * Creates a graph event for the specified graph, vertex, and type.
		 */
		public Vertex(Graph<V, E> source, Type type, V vertex) {
			super(source, type);
			this.vertex = vertex;
		}

		/**
		 * Retrieves the vertex associated with this event.
		 */
		public V getVertex() {
			return vertex;
		}

		@Override
		public String toString() {
			return "TraversalEvent type:" + type + " for " + vertex;
		}

	}

	/**
	 * An event type pertaining to graph edges.
	 */
	public static class Edge<V, E> extends TraversableGraphEvent<V, E> {
		protected E edge;

		/**
		 * Creates a graph event for the specified graph, edge, and type.
		 */
		public Edge(Graph<V, E> source, Type type, E edge) {
			super(source, type);
			this.edge = edge;
		}

		/**
		 * Retrieves the edge associated with this event.
		 */
		public E getEdge() {
			return edge;
		}

		@Override
		public String toString() {
			return "TraversalEvent type:" + type + " for " + edge;
		}

	}

	/**
	 * @return the source
	 */
	public Graph<V, E> getSource() {
		return source;
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}
}
