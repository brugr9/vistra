package vistra.core.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

import javax.swing.filechooser.FileNameExtensionFilter;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.core.graph.ml.EdgeMetadataTransformer;
import vistra.core.graph.ml.ExtendedGraphMLWriter;
import vistra.core.graph.ml.GraphMetadataTransformer;
import vistra.core.graph.ml.HyperEdgeMetadataTransformer;
import vistra.core.graph.ml.VertexMetadataTransformer;
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
	 * A field for a file.
	 */
	private File file;
	/**
	 * A field for a filename extension filter.
	 */
	private FileNameExtensionFilter fileNameExtensionFilter;
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
	 * A field for an extended GraphML writer.
	 */
	private ExtendedGraphMLWriter writer;

	/**
	 * Main constructor.
	 * 
	 * @param p
	 *            the core properties
	 */
	public GraphManager(Properties p) {
		super();
		this.file = new File("");
		/* filename filter */
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				p.getProperty("extension.graph.description"),
				p.getProperty("extension.graph"));
		this.fileNameExtensionFilter = filter;
		/* transformer */
		this.graphTransformer = new GraphMetadataTransformer();
		this.vertexTransformer = new VertexMetadataTransformer();
		this.edgeTransformer = new EdgeMetadataTransformer();
		this.hyperEdgeTransformer = new HyperEdgeMetadataTransformer();
		/* graphML writer */
		this.writer = new ExtendedGraphMLWriter();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IExtendedGraph getNewGraph(EdgeType edgeType) throws Exception {
		try {
			this.file = new File("");
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
