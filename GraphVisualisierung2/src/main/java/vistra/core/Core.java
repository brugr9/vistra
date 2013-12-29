package vistra.core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.filechooser.FileNameExtensionFilter;

import vistra.core.algorithm.AlgorithmManagerFactory;
import vistra.core.algorithm.IAlgorithm;
import vistra.core.algorithm.IAlgorithmManager;
import vistra.core.algorithm.impl.BFS;
import vistra.core.algorithm.impl.DFS;
import vistra.core.algorithm.impl.DLS;
import vistra.core.algorithm.impl.Default;
import vistra.core.algorithm.impl.Dijkstra;
import vistra.core.algorithm.impl.Kruskal;
import vistra.core.algorithm.impl.Test;
import vistra.core.graph.GraphManagerFactory;
import vistra.core.graph.IExtendedGraph;
import vistra.core.graph.IGraphManager;
import vistra.core.graph.ITraversableGraph;
import vistra.core.graph.ITraversableGraphEventListener;
import vistra.core.graph.TraversableGraph;
import vistra.core.graph.TraversableGraphEventListener;
import vistra.core.traversal.Traversal;
import vistra.core.traversal.step.IStep;
import vistra.util.IBidirectIterator;
import vistra.util.ImmutableBidirectIterator;
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
			this.algorithmManager.add(new Default());
			this.algorithmManager.add(new Test()); // TODO remove test algorithm
			this.algorithmManager.add(new BFS());
			this.algorithmManager.add(new DFS());
			this.algorithmManager.add(new DLS());
			this.algorithmManager.add(new Dijkstra());
			this.algorithmManager.add(new Kruskal());
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
	public IExtendedGraph newGraph(EdgeType edgeType) throws CoreException {
		try {
			return this.graphManager.newGraph(edgeType);
		} catch (Exception e) {
			throw new CoreException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveGraph() throws CoreException {
		try {
			this.graphManager.save();
		} catch (Exception e) {
			throw new CoreException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveGraphAs(File file) throws CoreException {
		try {
			this.graphManager.saveAs(file);
		} catch (Exception e) {
			throw new CoreException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateSelectableNames(EdgeType edgeType) throws CoreException {
		try {
			this.algorithmManager.updateSelectableList(edgeType);
		} catch (Exception e) {
			throw new CoreException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getSelectableNames() throws CoreException {
		try {
			return this.algorithmManager.getSelectableNames();
		} catch (Exception e) {
			throw new CoreException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void selectAlgorithm(int index) throws CoreException {
		try {
			this.algorithm = this.algorithmManager.select(index);
		} catch (Exception e) {
			throw new CoreException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getAlgorithmDescription() {
		return this.algorithm.getDescription();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Traversal traverse(IExtendedGraph graph) throws CoreException {

		try {
			/* graph and listener */
			List<IStep> stepList = new ArrayList<IStep>();
			ITraversableGraphEventListener listener = new TraversableGraphEventListener(
					stepList);
			ITraversableGraph tg = new TraversableGraph(graph);
			tg.addTraversalEventListener(listener);
			/* algorithm and traversal */
			this.algorithm.traverse(tg);
			IBidirectIterator<IStep> stepIterator = new ImmutableBidirectIterator<IStep>(
					stepList);
			Traversal traversal = new Traversal(stepIterator);
			return traversal;
		} catch (Exception e) {
			throw new CoreException(e);
		}

	}
}