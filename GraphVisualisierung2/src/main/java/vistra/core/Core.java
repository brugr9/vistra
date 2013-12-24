package vistra.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.filechooser.FileNameExtensionFilter;

import vistra.core.algorithm.AlgorithmManagerFactory;
import vistra.core.algorithm.IAlgorithm;
import vistra.core.algorithm.IAlgorithmManager;
import vistra.core.graph.GraphFactory;
import vistra.core.graph.GraphManagerFactory;
import vistra.core.graph.IExtendedGraph;
import vistra.core.graph.IGraphManager;
import vistra.core.graph.item.edge.IEdgeLayout;
import vistra.core.graph.item.vertex.IVertexLayout;
import vistra.core.traversal.Traversal;
import vistra.core.traversal.step.IStep;
import vistra.util.IBidirectIterator;
import vistra.util.ImmutableBidirectIterator;
import edu.uci.ics.jung.graph.event.GraphEventListener;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * A core, gives access to mainly important methods (facade pattern) and holds
 * an algorithm which can be changed (strategy pattern).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class Core implements ICore {

	/**
	 * A field for a graph manager.
	 */
	private IGraphManager graphManager;

	/**
	 * A field for an algorithm manager.
	 */
	private IAlgorithmManager algorithmManager;

	/**
	 * A field for an algorithm.
	 */
	private IAlgorithm algorithm;

	/**
	 * Main constructor.
	 * 
	 * @param p
	 *            the properties
	 */
	public Core(Properties p) {
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
	public IExtendedGraph openGraph(File source) throws CoreException {
		try {
			return this.graphManager.open(source);
		} catch (Exception e) {
			throw new CoreException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IExtendedGraph getNewGraph(EdgeType edgeType) throws CoreException {
		try {
			return this.graphManager.getNewGraph(edgeType);
		} catch (Exception e) {
			throw new CoreException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(IExtendedGraph graph) throws CoreException {
		try {
			this.graphManager.save(graph);
		} catch (Exception e) {
			throw new CoreException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveAs(IExtendedGraph graph, File file) throws CoreException {
		try {
			this.graphManager.saveAs(graph, file);
		} catch (Exception e) {
			throw new CoreException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getAlgorithms(EdgeType edgeType) throws CoreException {
		try {
			return this.algorithmManager.getNames(edgeType);
		} catch (Exception e) {
			throw new CoreException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IAlgorithm selectAlgorithm(int index) throws CoreException {
		try {
			return this.algorithmManager.select(index);
		} catch (Exception e) {
			throw new CoreException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAlgorithm(IAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Traversal traverse(IExtendedGraph graph) throws CoreException {

		try {
			// the steps
			List<IStep> stepList = new ArrayList<IStep>();
			// the graph
			GraphEventListener<IVertexLayout, IEdgeLayout> listener = GraphFactory
					.createListener(stepList);
			graph.addGraphEventListener(listener);
			// the algorithm
			// TODO this.algorithm.traverse(graph);
			// undo all steps in reverse order
			for (int index = stepList.size() - 1; index > -1; index--)
				stepList.get(index).undo();
			// the traversal
			IBidirectIterator<IStep> stepIterator = new ImmutableBidirectIterator<IStep>(
					stepList);
			return new Traversal(stepIterator);
		} catch (Exception e) {
			throw new CoreException(e);
		}

	}
}