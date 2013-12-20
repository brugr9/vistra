package vistra.core.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

import javax.swing.filechooser.FileNameExtensionFilter;

import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import vistra.gui.view.component.vizualization.transformer.EdgeTransformer;
import vistra.gui.view.component.vizualization.transformer.GraphTransformer;
import vistra.gui.view.component.vizualization.transformer.HyperEdgeTransformer;
import vistra.gui.view.component.vizualization.transformer.VertexTransformer;
import edu.uci.ics.jung.io.GraphIOException;
import edu.uci.ics.jung.io.GraphMLWriter;
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
	 * A field for a GraphMLWriter.
	 */
	private GraphMLWriter graphMLWriter;

	/**
	 * Main constructor.
	 * 
	 * @param p
	 *            the core properties
	 */
	@SuppressWarnings("rawtypes")
	public GraphManager(Properties p) {
		super();
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
		this.graphMLWriter = new GraphMLWriter();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IExtendedGraph getNewGraph() throws Exception {
		try {
			this.graph = null;
			IExtendedGraph newGraph = GraphFactory.create();
			return newGraph;
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
			this.graph = file;
			return this.read(file);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void save(IExtendedGraph graph) throws Exception {
		try {
			this.graphMLWriter.save(graph, new FileWriter(this.graph));
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
	private IExtendedGraph read(final File file) throws GraphException {
		try {
			GraphMLReader2<IExtendedGraph, IVertex, IEdge> graphReader = new GraphMLReader2<>(
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
