package vistra.core.graph;

import java.util.List;

import vistra.core.graph.item.IEdge;
import vistra.core.graph.item.IVertex;

/**
 * An abstract traversable-graph event.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public abstract class TraversableGraphEvent {

	/**
	 * A field for the source.
	 */
	protected ITraversableGraph source;
	/**
	 * A field for the type.
	 */
	protected Type type;

	/**
	 * Creates an instance with the specified {@code source} graph and
	 * {@code type}.
	 * 
	 * @param source
	 *            the source
	 * @param type
	 *            the type
	 */
	public TraversableGraphEvent(ITraversableGraph source, Type type) {
		this.source = source;
		this.type = type;
	}

	/**
	 * Types of graph events.
	 */
	public static enum Type {
		/* items */
		UPDATE,
		/* vertices */
		INIT,
		/* edge-vertex */
		VISIT, SOLUTION,
		/* edge */
		BACK_EDGE, FORWARD_EDGE, CROSS_EDGE, DISCARDED_EDGE, SOLUTION_EDGE,
	}

	/**
	 * An event type pertaining to a bunch of vertices.
	 */
	public static class VerticesEvent extends TraversableGraphEvent {

		/**
		 * A field for the vertices.
		 */
		private List<IVertex> vertices;
		/**
		 * A field for a list of values.
		 */
		private List<String> values;

		/**
		 * Main constructor.
		 * 
		 * @param source
		 *            the source
		 * @param type
		 *            the type
		 * @param vertices
		 *            the vertices
		 * @param values
		 *            the values
		 */
		public VerticesEvent(ITraversableGraph source, Type type,
				List<IVertex> vertices, List<String> values) {
			super(source, type);
			this.vertices = vertices;
			this.values = values;
		}

		/**
		 * Returns the vertices.
		 * 
		 * @return the vertices
		 */
		public List<IVertex> getVertices() {
			return this.vertices;
		}

		/**
		 * Returns the values.
		 * 
		 * @return the values
		 */
		public List<String> getValues() {
			return this.values;
		}

	}

	/**
	 * An event type pertaining to an edge and a vertex.
	 */
	public static class EdgeVertexEvent extends TraversableGraphEvent {

		/**
		 * A field for an edge.
		 */
		private IEdge edge;
		/**
		 * A field for a vertex.
		 */
		private IVertex vertex;

		/**
		 * Main constructor.
		 * 
		 * @param source
		 *            the source
		 * @param type
		 *            the type
		 * @param edge
		 *            the edge
		 * @param vertex
		 *            the vertex
		 */
		public EdgeVertexEvent(ITraversableGraph source, Type type, IEdge edge,
				IVertex vertex) {
			super(source, type);
		}

		/**
		 * Returns the edge.
		 * 
		 * @return the edge
		 */
		public IEdge getEdge() {
			return this.edge;
		}

		/**
		 * Returns the vertex.
		 * 
		 * @return the vertex
		 */
		public IVertex getVertex() {
			return this.vertex;
		}
	}

	/**
	 * Returns the source.
	 * 
	 * @return the source
	 */
	public ITraversableGraph getSource() {
		return source;
	}

	/**
	 * Returns the event type.
	 * 
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " type: " + this.type
				+ " for " + this.source;
	}

}
