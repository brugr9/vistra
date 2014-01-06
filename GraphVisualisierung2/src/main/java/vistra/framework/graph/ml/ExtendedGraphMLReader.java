package vistra.framework.graph.ml;

import java.io.IOException;
import java.io.Reader;

import vistra.framework.graph.IExtendedGraph;
import vistra.framework.graph.item.IEdgeLayout;
import vistra.framework.graph.item.IVertexLayout;
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
	 * Main constructor.
	 */
	public ExtendedGraphMLReader() {
		this.graphTransformer = new GraphMetadataTransformer();
		this.vertexTransformer = new VertexMetadataTransformer();
		this.edgeTransformer = new EdgeMetadataTransformer();
		this.hyperEdgeTransformer = new HyperEdgeMetadataTransformer();
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
			GraphMLReader2<IExtendedGraph, IVertexLayout, IEdgeLayout> mlReader = new GraphMLReader2<IExtendedGraph, IVertexLayout, IEdgeLayout>(
					r, this.graphTransformer, this.vertexTransformer,
					this.edgeTransformer, this.hyperEdgeTransformer);
			mlReader.init();
			IExtendedGraph graph = mlReader.readGraph();
			mlReader.close();
			return graph;
		} catch (Exception e) {
			throw e;
		}
	}

}
