package vistra.framework.graph;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.Properties;

import javax.swing.filechooser.FileNameExtensionFilter;

import vistra.framework.graph.item.ILayoutEdge;
import vistra.framework.graph.item.ILayoutVertex;
import vistra.framework.graph.item.transformer.VertexLocation;
import vistra.framework.graph.ml.GraphReader;
import vistra.framework.graph.ml.GraphWriter;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * A graph manager. Holds a graph instance and manages e.g. opening and saving
 * (read/write) graphs.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 * @see LayoutGraph
 * @see GraphReader
 * @see GraphWriter
 */
class GraphManager implements IGraphManager {

	/**
	 * A field for a graph.
	 */
	private ILayoutGraph graph;
	/**
	 * A field for a file.
	 */
	private File file;
	/**
	 * A field for a filename extension filter.
	 */
	private FileNameExtensionFilter fileNameExtensionFilter;
	/**
	 * A field for an extended GraphML reader.
	 */
	private GraphReader reader;
	/**
	 * A field for an extended GraphML writer.
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
		this.file = new File("");
		this.graph = GraphFactory.create(EdgeType.UNDIRECTED);
		/* filename filter */
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				p.getProperty("filenameextension.graph.description"),
				p.getProperty("filenameextension.graph"));
		this.fileNameExtensionFilter = filter;
		/* GraphML */
		this.reader = new GraphReader();
		this.writer = new GraphWriter();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ILayoutGraph newGraph(EdgeType edgeType) throws Exception {
		try {
			if (this.graph != null)
				this.clearGraph(); // TODO nessessary?
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
	public ILayoutGraph open(File file) throws Exception {
		try {
			if (this.graph != null)
				this.clearGraph(); // TODO nessessary?
			this.file = file;
			// TODO temporary layout with VertexLocation
			Layout<ILayoutVertex, ILayoutEdge> layout = new StaticLayout<ILayoutVertex, ILayoutEdge>(
					this.graph);
			layout.setInitializer(new VertexLocation());
			// TODO end
			this.graph = this.reader.read(new FileReader(this.file));
			String name = file.getName();
			this.graph.setName(name);
			return this.graph;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Removes all vertices and edges from the graph.
	 * 
	 * @throws Exception
	 */
	private void clearGraph() throws Exception {
		try {
			Collection<ILayoutEdge> edges = this.graph.getEdges();
			Collection<ILayoutVertex> vertices = this.graph.getVertices();
			for (@SuppressWarnings("unused")
			ILayoutEdge e : edges)
				e = null;
			for (@SuppressWarnings("unused")
			ILayoutVertex v : vertices)
				v = null;
			this.graph = null;
		} catch (Exception e) {
			throw e;
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
