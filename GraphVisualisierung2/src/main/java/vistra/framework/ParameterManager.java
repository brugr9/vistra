package vistra.framework;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.filechooser.FileNameExtensionFilter;

import vistra.framework.algorithm.AlgorithmManagerFactory;
import vistra.framework.algorithm.IAlgorithm;
import vistra.framework.algorithm.IAlgorithmManager;
import vistra.framework.algorithm.impl.BFS;
import vistra.framework.algorithm.impl.DFSpre;
import vistra.framework.algorithm.impl.DLS;
import vistra.framework.algorithm.impl.Default;
import vistra.framework.algorithm.impl.Dijkstra;
import vistra.framework.algorithm.impl.Kruskal;
import vistra.framework.algorithm.impl.SimpleSteps;
import vistra.framework.graph.GraphManagerFactory;
import vistra.framework.graph.IGraphManager;
import vistra.framework.graph.ILayoutGraph;
import vistra.framework.graph.ITraversableGraph;
import vistra.framework.graph.TraversableGraph;
import vistra.framework.traversal.ITraversal;
import vistra.framework.traversal.Traversal;
import vistra.framework.traversal.step.IStep;
import vistra.framework.util.IBidirectIterator;
import vistra.framework.util.ImmutableBidirectIterator;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * A parameter manager. The manager gives access to the graph and the algorithm
 * by delegating its method calls to manager specialized on graphs or algorithms
 * (facade pattern). Furthermore, this manager holds an algorithm which can be
 * changed (strategy pattern).
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
	 * A field for an algorithm.
	 */
	private IAlgorithm algorithm;

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
			this.algorithmManager.addAvailable(new Default());
			this.algorithmManager.addAvailable(new SimpleSteps()); // TODO
																	// remove
			this.algorithmManager.addAvailable(new BFS());
			this.algorithmManager.addAvailable(new DFSpre());
			this.algorithmManager.addAvailable(new DLS());
			this.algorithmManager.addAvailable(new Dijkstra());
			this.algorithmManager.addAvailable(new Kruskal());
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
	public void updateSelectableAlgorithms(EdgeType edgeType)
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
			return this.algorithmManager.getNames();
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
			this.algorithm = this.algorithmManager.getSupported(index);
		} catch (Exception e) {
			throw new ParameterException(e);
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
	public ITraversal executeAlgorithm(ILayoutGraph graph)
			throws ParameterException {
		try {
			/* graph */
			List<IStep> steps = new ArrayList<IStep>();
			StringBuilder solution = new StringBuilder();
			ITraversableGraph g = new TraversableGraph(graph, steps, solution);
			/* algorithm */
			this.algorithm.traverse(g);
			/* traversal */
			IBidirectIterator<IStep> stepIterator = new ImmutableBidirectIterator<IStep>(
					steps);
			while (stepIterator.hasNext())
				stepIterator.next();
			while (stepIterator.hasPrevious())
				stepIterator.previous().undo();
			ITraversal traversal = new Traversal(stepIterator);
			traversal.setSolution(solution.toString());
			return traversal;
		} catch (Exception e) {
			throw new ParameterException(e);
		}
	}
}