package vistra.framework;

import java.io.File;
import java.util.Properties;

import javax.swing.filechooser.FileNameExtensionFilter;

import vistra.framework.algorithm.AlgorithmManagerFactory;
import vistra.framework.algorithm.IAlgorithm;
import vistra.framework.algorithm.IAlgorithmManager;
import vistra.framework.graph.GraphManagerFactory;
import vistra.framework.graph.IGraphManager;
import vistra.framework.graph.ILayoutGraph;
import vistra.framework.traversal.ITraversal;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * A manager for accessing the two traversal-parameter 'graph' (operand) and
 * 'algorithm' (operator). This manager delegates method calls to other manager
 * specialized on graphs ({@code IGraphManager}) or algorithms (
 * {@code IAlgorithmManager}) (facade pattern).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class ParameterManager implements IParameterManager {

	/**
	 * A field for a graph manager.
	 */
	private IGraphManager graphManager;

	/**
	 * A field for an algorithm manager.
	 */
	private IAlgorithmManager algorithmManager;

	/**
	 * Main constructor.
	 * 
	 * @param p
	 *            the properties
	 */
	public ParameterManager(Properties p) {
		try {
			this.graphManager = GraphManagerFactory.create(p);
			this.algorithmManager = AlgorithmManagerFactory.create(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FileNameExtensionFilter getGraphFilter() {
		return this.graphManager.getFilter();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ILayoutGraph openGraph(File source) throws ParameterException {
		try {
			return this.graphManager.open(source);
		} catch (Exception e) {
			throw new ParameterException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ILayoutGraph newGraph(EdgeType edgeType) throws ParameterException {
		try {
			return this.graphManager.newGraph(edgeType);
		} catch (Exception e) {
			throw new ParameterException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveGraph() throws ParameterException {
		try {
			this.graphManager.save();
		} catch (Exception e) {
			throw new ParameterException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveGraphAs(File file) throws ParameterException {
		try {
			this.graphManager.saveAs(file);
		} catch (Exception e) {
			throw new ParameterException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addAlgorithm(IAlgorithm algorithm) throws ParameterException {
		try {
			this.algorithmManager.addAvailable(algorithm);
		} catch (Exception e) {
			throw new ParameterException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateSupportedAlgorithms(EdgeType edgeType)
			throws ParameterException {
		try {
			this.algorithmManager.updateSupported(edgeType);
		} catch (Exception e) {
			throw new ParameterException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getSelectableAlgorithmNames() throws ParameterException {
		try {
			return this.algorithmManager.getNamesOfSupported();
		} catch (Exception e) {
			throw new ParameterException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void selectAlgorithm(int index) throws ParameterException {
		try {
			this.algorithmManager.select(index);
		} catch (Exception e) {
			throw new ParameterException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAlgorithmDescription() {
		return this.algorithmManager.getDescription();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ITraversal executeAlgorithm(ILayoutGraph graph) throws Exception {
		try {
			return this.algorithmManager.execute(graph);
		} catch (Exception e) {
			throw e;
		}
	}

}