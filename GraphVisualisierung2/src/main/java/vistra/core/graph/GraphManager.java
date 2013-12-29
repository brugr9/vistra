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
 * A graph manager. Manages opening and saving (read/write) graphs.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see ExtendedGraph
 * @see ExtendedGraphMLWriter
 */
class GraphManager implements IGraphManager {

	/**
	 * A field for a graph.
	 */
	private IExtendedGraph graph;
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
		this.graph = GraphFactory.create(EdgeType.UNDIRECTED);
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
	public IExtendedGraph newGraph(EdgeType edgeType) throws Exception {
		try {
			this.file = new File("");
			this.graph = GraphFactory.create(edgeType);
			return this.graph;
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
			this.graph = GraphFactory.createGraph();
			this.read(file);
			return this.graph;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * A helper method: Reads in a GraphML-file to the graph.
	 * 
	 * @param file
	 *            the file to read
	 */
	private void read(File file) throws GraphException {
		try {
			GraphMLReader2<IExtendedGraph, IVertexLayout, IEdgeLayout> graphReader = new GraphMLReader2<IExtendedGraph, IVertexLayout, IEdgeLayout>(
					new FileReader(file), this.graphTransformer,
					this.vertexTransformer, this.edgeTransformer,
					this.hyperEdgeTransformer);
			this.graph = graphReader.readGraph();
			this.graph.setName(file.getName());
			graphReader.close();
		} catch (GraphIOException e) {
			throw new GraphException("I/O error in GraphML-file "
					+ file.getName(), e);
		} catch (FileNotFoundException e) {
			throw new GraphException("File not found: " + file.getName(), e);
		} catch (Exception e) {
			throw new GraphException("Exception while reading "
					+ file.getName(), e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save() throws Exception {
		try {
			this.writer.save(this.graph, new FileWriter(this.file));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveAs(File file) throws Exception {
		try {
			this.file = file;
			this.save();
			String name = file.getName();
			this.graph.setName(name);
		} catch (Exception e) {
			throw e;
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
