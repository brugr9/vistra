package vistra.framework.graph;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

import javax.swing.filechooser.FileNameExtensionFilter;

import vistra.framework.graph.item.IVertex;
import vistra.framework.graph.item.VertexFactory;
import vistra.framework.graph.ml.GraphReader;
import vistra.framework.graph.ml.GraphWriter;
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
			this.file = file;
			this.graph = this.reader.read(new FileReader(this.file));
			this.graph.setName(this.file.getName());
			for (@SuppressWarnings("unused")
			IVertex v : this.graph.getVertices())
				VertexFactory.nextSigma();
			return this.graph;
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
			String name = file.getName();
			String suffix = "."
					+ this.fileNameExtensionFilter.getExtensions()[0];
			if (!name.endsWith(suffix)) {
				File newFile = new File(file.getPath().concat(suffix));
				this.file = newFile;
				name = newFile.getName();
			} else
				this.file = file;
			this.save();
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
