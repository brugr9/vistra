package vistra.core;

import static vistra.core.graph.GraphFactory.createGravisGraphEventListener;
import static vistra.core.graph.GraphFactory.createObservableGraph;
import static vistra.core.graph.GraphFactory.createRestrictedGraph;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;

import vistra.common.IAlgorithm;
import vistra.core.algorithm.AlgorithmManagerFactory;
import vistra.core.algorithm.IAlgorithmManager;
import vistra.core.graph.GraphManagerFactory;
import vistra.core.graph.IGraphManager;
import vistra.core.graph.IGravisGraph;
import vistra.core.graph.IObservableGravisGraph;
import vistra.core.graph.IRestrictedGraph;
import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import vistra.core.traversal.GravisListIterator;
import vistra.core.traversal.IGravisListIterator;
import vistra.core.traversal.Traversal;
import vistra.core.traversal.step.IStep;
import edu.uci.ics.jung.graph.event.GraphEventListener;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * Application core, gives access to mainly important methods (facade pattern).
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
	 * Main constructor.
	 * 
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
	public IObservableGravisGraph openGraph(File source) throws CoreException {
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
	public IObservableGravisGraph getNewGraph() throws CoreException {
		try {
			return this.graphManager.getNewGraph();
		} catch (Exception e) {
			throw new CoreException(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(IGravisGraph graph) throws CoreException {
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
	public void saveAs(IGravisGraph graph, File file) throws CoreException {
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
	public File getAlgorithmWorkbenchDir() {
		return new File(this.algorithmManager.getWorkbenchDir());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FileNameExtensionFilter getAlgorithmFilter() {
		return this.algorithmManager.getFilter();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EdgeType[] importAlgorithm(File source) throws CoreException {
		try {
			FileUtils.copyFileToDirectory(source,
					this.getAlgorithmWorkbenchDir());
			return this.algorithmManager.add(source);
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
	public EdgeType[] deleteAlgorithm(File file) throws CoreException {

		try {
			if (file.delete())
				return this.algorithmManager.remove(file.getName());
			else
				return null;
		} catch (Exception e) {
			throw new CoreException(e);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Traversal renderTraversal(IGravisGraph graph, IAlgorithm algorithm)
			throws CoreException {

		try {
			// the steps
			List<IStep> steps = new ArrayList<IStep>();
			// the graph
			GraphEventListener<IVertex, IEdge> graphEventListener = createGravisGraphEventListener(steps);
			IObservableGravisGraph observableGraph = createObservableGraph(graph);
			observableGraph.addGraphEventListener(graphEventListener);
			IRestrictedGraph restrictedGraph = createRestrictedGraph(observableGraph);
			// the algorithm
			algorithm.execute(restrictedGraph);
			// undo all steps in reverse order
			for (int index = steps.size() - 1; index > -1; index--)
				steps.get(index).undo();
			// the traversal
			IGravisListIterator<IStep> stepIterator = new GravisListIterator<IStep>(
					steps);
			return new Traversal(stepIterator);
		} catch (Exception e) {
			throw new CoreException(e);
		}

	}

}