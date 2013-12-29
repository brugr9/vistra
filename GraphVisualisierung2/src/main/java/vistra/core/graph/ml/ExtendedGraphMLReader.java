package vistra.core.graph.ml;

import java.io.IOException;
import java.io.Reader;
import vistra.core.graph.IExtendedGraph;
import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import edu.uci.ics.jung.io.graphml.GraphMLReader2;

/**
 * An extended GraphMLWriter for reading an extended graph from a GraphML file.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class ExtendedGraphMLReader {

	/**
	 * A field for a graph metadata transformer.
	 */
	private final GraphMetadataTransformer graphTransformer;
	/**
	 * A field for a vertex metadata transformer.
	 */
	private final VertexMetadataTransformer vertexTransformer;
	/**
	 * A field for a edge metadata transformer.
	 */
	private final EdgeMetadataTransformer edgeTransformer;
	/**
	 * A field for a hyper edge metadata transformer.
	 */
	private final HyperEdgeMetadataTransformer hyperEdgeTransformer;
	/**
	 * A field for a delegated reader.
	 */
	private GraphMLReader2<IExtendedGraph, IVertexLayout, IEdgeLayout> delegate;

	/**
	 * Main constructor.
	 */
	public ExtendedGraphMLReader() {
		this.graphTransformer = new GraphMetadataTransformer();
		this.vertexTransformer = new VertexMetadataTransformer();
		this.edgeTransformer = new EdgeMetadataTransformer();
		this.hyperEdgeTransformer = new HyperEdgeMetadataTransformer();
		this.delegate = null;
	}

	/**
	 * Reads a GraphML-file to a graph.
	 * 
	 * @param r
	 *            a reader
	 * @return the graph
	 * @throws IOException
	 */
	public IExtendedGraph read(Reader r) throws Exception {
		try {
			this.delegate = new GraphMLReader2<IExtendedGraph, IVertexLayout, IEdgeLayout>(
					r, this.graphTransformer, this.vertexTransformer,
					this.edgeTransformer, this.hyperEdgeTransformer);
			this.delegate.init();
			IExtendedGraph graph = this.delegate.readGraph();
			this.delegate.close();
			this.delegate = null;
			return graph;
		} catch (Exception e) {
			throw e;
		}
	}

}
