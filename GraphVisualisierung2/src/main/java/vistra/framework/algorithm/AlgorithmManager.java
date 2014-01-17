package vistra.framework.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import vistra.framework.ParameterException;
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
 * An algorithm manager.
 * <p>
 * An algorithm manager holds two lists:
 * <ul>
 * <li>a list with all algorithms available
 * <li>a list with algorithms supporting an edge type (as a selection out of the
 * algorithms available)
 * </ul>
 * Furthermore, this manager holds an algorithm which can be changed (strategy
 * pattern).
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
final class AlgorithmManager implements IAlgorithmManager {

	/**
	 * A field for a list of algorithms available.
	 */
	private ArrayList<IAlgorithm> available;
	/**
	 * A field for a list of supported algorithms.
	 */
	private ArrayList<IAlgorithm> supported;
	/**
	 * A field for a selected algorithm.
	 */
	private IAlgorithm selected;

	/**
	 * Main constructor.
	 * 
	 * @param p
	 *            the properties
	 */
	AlgorithmManager(Properties p) {
		super();
		this.supported = new ArrayList<IAlgorithm>();
		available = new ArrayList<IAlgorithm>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addAvailable(IAlgorithm algorithm) throws Exception {
		return this.available.add(algorithm);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateSupported(EdgeType edgeType) throws Exception {
		try {
			this.supported.clear();
			EdgeType[] capabilities;
			for (IAlgorithm a : this.available) {
				capabilities = a.getEdgeTypes();
				for (int i = 0; i < capabilities.length; i++) {
					if (capabilities[i] == edgeType) {
						this.supported.add(a);
						break;
					}
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getNamesOfSupported() throws Exception {
		try {
			String[] names = new String[this.supported.size()];
			for (int i = 0; i < names.length; i++) {
				names[i] = this.supported.get(i).getName();
			}
			return names;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IAlgorithm getSupported(int index) throws Exception {
		try {
			return this.supported.get(index);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void select(int index) throws ParameterException {
		try {
			this.selected = this.getSupported(index);
		} catch (Exception e) {
			throw new ParameterException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return this.selected.getDescription();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ITraversal execute(ILayoutGraph graph) throws Exception {
		try {
			/* graph */
			List<IStep> steps = new ArrayList<IStep>();
			StringBuilder solution = new StringBuilder();
			ITraversableGraph g = new TraversableGraph(graph, steps, solution);
			/* algorithm */
			this.selected.traverse(g);
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
			throw e;
		}
	}

}
