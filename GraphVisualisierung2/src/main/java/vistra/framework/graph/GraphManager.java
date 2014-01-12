package vistra.framework.graph;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

import javax.swing.filechooser.FileNameExtensionFilter;

import vistra.framework.graph.ml.ExtendedGraphMLReader;
import vistra.framework.graph.ml.ExtendedGraphMLWriter;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * A graph manager. Holds a graph instance and manages e.g. opening and saving
 * (read/write) graphs.
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
	 * A field for an extended GraphML reader.
	 */
	private ExtendedGraphMLReader reader;
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
				p.getProperty("filenameextension.graph.description"),
				p.getProperty("filenameextension.graph"));
		this.fileNameExtensionFilter = filter;
		/* GraphML */
		this.reader = new ExtendedGraphMLReader();
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
			this.graph = this.reader.read(new FileReader(this.file));
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
