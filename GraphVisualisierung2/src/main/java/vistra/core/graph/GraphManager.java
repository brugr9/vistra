package vistra.core.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

import javax.swing.filechooser.FileNameExtensionFilter;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.core.graph.transformer.EdgeTransformer;
import vistra.core.graph.transformer.GraphTransformer;
import vistra.core.graph.transformer.HyperEdgeTransformer;
import vistra.core.graph.transformer.VertexTransformer;
import edu.uci.ics.jung.graph.util.EdgeType;
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
	 * A field for a filename extension filter.
	 */
	private FileNameExtensionFilter fileNameExtensionFilter;
	/**
	 * A field for a file.
	 */
	private File file;
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
	 * A field for a graph writer.
	 */
	private GraphWriter writer;

	/**
	 * Main constructor.
	 * 
	 * @param p
	 *            the core properties
	 */
	public GraphManager(Properties p) {
		super();
		this.file = null;
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
		this.writer = new GraphWriter();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IExtendedGraph getNewGraph(EdgeType edgeType) throws Exception {
		try {
			this.file = null;
			IExtendedGraph graph = GraphFactory.create(edgeType);
			return graph;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IExtendedGraph open(File file) throws Exception {
		try {
			this.file = file;
			return this.read(file);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(IExtendedGraph graph) throws Exception {
		try {
			this.writer.save(graph, new FileWriter(this.file));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveAs(IExtendedGraph graph, File file) throws Exception {
		try {
			this.file = file;
			this.save(graph);
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
	private IExtendedGraph read(File file) throws GraphException {
		try {
			GraphMLReader2<IExtendedGraph, IVertexLayout, IEdgeLayout> graphReader = new GraphMLReader2<>(
					new FileReader(file), this.graphTransformer,
					this.vertexTransformer, this.edgeTransformer,
					this.hyperEdgeTransformer);

			IExtendedGraph graph = graphReader.readGraph();
			graphReader.close();
			return graph;
		} catch (GraphIOException e) {
			throw new GraphException("I/O error in GraphML-file "
					+ file.getName(), e);
		} catch (FileNotFoundException e) {
			throw new GraphException("File not found: " + file.getName(), e);
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
