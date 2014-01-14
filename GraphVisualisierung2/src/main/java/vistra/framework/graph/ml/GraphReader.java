package vistra.framework.graph.ml;

import java.io.IOException;
import java.io.Reader;

import vistra.framework.graph.ILayoutGraph;
import vistra.framework.graph.item.ILayoutEdge;
import vistra.framework.graph.item.ILayoutVertex;
import edu.uci.ics.jung.io.graphml.GraphMLReader2;

/**
 * A GraphMLReader for reading in an extended graph from a GraphML file.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class GraphReader {

	/**
	 * A field for a graph transformer.
	 */
	private final GraphTransformer graphTransformer;
	/**
	 * A field for a vertex transformer.
	 */
	private final VertexTransformer vertexTransformer;
	/**
	 * A field for a edge transformer.
	 */
	private final EdgeTransformer edgeTransformer;
	/**
	 * A field for a hyper-edge transformer.
	 */
	private final HyperEdgeTransformer hyperEdgeTransformer;

	/**
	 * Main constructor.
	 */
	public GraphReader() {
		this.graphTransformer = new GraphTransformer();
		this.vertexTransformer = new VertexTransformer();
		this.edgeTransformer = new EdgeTransformer();
		this.hyperEdgeTransformer = new HyperEdgeTransformer();
	}

	/**
	 * Reads in a GraphML-file.
	 * 
	 * @param r
	 *            a reader
	 * @return the graph
	 * @throws IOException
	 */
	public ILayoutGraph read(Reader r) throws Exception {
		try {
			GraphMLReader2<ILayoutGraph, ILayoutVertex, ILayoutEdge> mlReader = new GraphMLReader2<ILayoutGraph, ILayoutVertex, ILayoutEdge>(
					r, this.graphTransformer, this.vertexTransformer,
					this.edgeTransformer, this.hyperEdgeTransformer);
			mlReader.init();
			ILayoutGraph graph = mlReader.readGraph();
			mlReader.close();
			return graph;
		} catch (Exception e) {
			throw e;
		}
	}

}
