package vistra.core.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import javax.swing.filechooser.FileNameExtensionFilter;

import vistra.core.zobsolete.graph.GravisGraphMLWriter;
import vistra.core.zobsolete.graph.IGravisGraph;
import vistra.core.zobsolete.graph.IObservableGraph;
import vistra.core.zobsolete.graph.item.edge.IEdge;
import vistra.core.zobsolete.graph.item.vertex.IVertex;
import vistra.util.transformer.EdgeTransformer;
import vistra.util.transformer.GraphTransformer;
import vistra.util.transformer.HyperEdgeTransformer;
import vistra.util.transformer.VertexTransformer;
import edu.uci.ics.jung.io.GraphIOException;
import edu.uci.ics.jung.io.graphml.GraphMLReader2;

/**
 * A parameter manager specialized on parameters as files.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class GraphManager implements IGraphManager {

	/**
	 * A field for a default name.
	 */
	private String defaultName;
	/**
	 * A field for a filename extension filter.
	 */
	private FileNameExtensionFilter fileNameExtensionFilter;
	/**
	 * A field for a graph file.
	 */
	private File graph;
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
	 * A field for a hyper edge transformer.
	 */
	private final HyperEdgeTransformer hyperEdgeTransformer;
	/**
	 * A field for a GraphML writer.
	 */
	private GravisGraphMLWriter gravisGraphMLWriter;

	/**
	 * Main constructor.
	 * 
	 * @param p
	 *            the core properties
	 */
	public GraphManager(Properties p) {
		super();
		this.defaultName = p.getProperty("graphname");
		this.graph = null;
		/* filename filter */
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				p.getProperty("extension.graph.description"),
				p.getProperty("extension.graph"));
		this.fileNameExtensionFilter = filter;
		/* transformer */
		this.graphTransformer = new GraphTransformer();
		this.vertexTransformer = new VertexTransformer();
		this.edgeTransformer = new EdgeTransformer();
		this.hyperEdgeTransformer = new HyperEdgeTransformer();
		/* graphML writer */
		this.gravisGraphMLWriter = new GravisGraphMLWriter();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IObservableGraph getNewGraph() throws Exception {
		try {
			this.graph = null;
			IObservableGraph newGraph = GraphFactory
					.createObservableGraph();
			newGraph.setId(this.defaultName);
			return newGraph;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IObservableGraph open(File file) throws Exception {
		try {
			this.graph = file;
			return this.read(file);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(IGravisGraph graph) throws Exception {
		try {
			// TODO
			// this.gravisGraphMLWriter.save(graph, w);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveAs(IGravisGraph graph, File file) throws Exception {
		try {
			this.save(graph);
			graph.setId(file.getName());
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * Creates an instance of graph and reads in a GraphML-file as given.
	 * 
	 * @param file
	 *            the file to load
	 * @return the loaded graph
	 */
	private IObservableGraph read(final File file) throws GraphException {
		try {
			GraphMLReader2<IGravisGraph, IVertex, IEdge> graphReader = new GraphMLReader2<>(
					new FileReader(file), this.graphTransformer,
					this.vertexTransformer, this.edgeTransformer,
					this.hyperEdgeTransformer);

			IGravisGraph graph = graphReader.readGraph();
			graphReader.close();
			return GraphFactory.createObservableGraph(graph);
		} catch (GraphIOException e) {
			throw new GraphException("I/O error in GraphML-file "
					+ file.getName(), e);
		} catch (FileNotFoundException e) {
			throw new GraphException("GraphML-file not found: "
					+ file.getName(), e);
		} catch (Exception e) {
			throw new GraphException(
					"Exception while loading data from GraphML-file "
							+ file.getName(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FileNameExtensionFilter getFilter() {
		return this.fileNameExtensionFilter;
	}

}
