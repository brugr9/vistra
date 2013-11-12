package ch.bfh.bti7301.hs2013.gravis.core;

import java.io.File;

import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.maven.shared.utils.io.FileUtils;

import ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm.GraphType;
import ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithmManager;
import ch.bfh.bti7301.hs2013.gravis.core.command.ICommand;
import ch.bfh.bti7301.hs2013.gravis.core.graph.GraphFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IGraphManager;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * This class gives access to all important methods of the core classes (facade
 * pattern).
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class Core implements ICore {

	private IGraphManager graphManager;
	private IAlgorithmManager algorithmManager;
	private ITraversal traversal;
	private IIteratorManager iteratorManager;

	/**
	 * @param graphManager
	 * @param algorithmManager
	 * @param traversal
	 * @param iteratorManager
	 */
	protected Core(IGraphManager graphManager,
			IAlgorithmManager algorithmManager, ITraversal traversal,
			IIteratorManager iteratorManager) {
		this.graphManager = graphManager;
		this.algorithmManager = algorithmManager;
		this.traversal = traversal;
		this.iteratorManager = iteratorManager;
	}

	@Override
	public Graph<IVertex, IEdge> selectGraph(int index) throws Exception {
		try {
			IGravisGraph graph = this.traversal.getGraph();

			graph = this.graphManager.getGraph(index);
			this.traversal.setParameter(graph);
			EdgeType type = graph.getEdgeType();
			// TODO updateAlgorithmList() anpassen für EdgeType
			this.algorithmManager
					.updateAlgorithmList(new GraphType[] { GraphType.DIRECTED });
			return graph;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#importGraph(java.lang.String
	 * )
	 */
	@Override
	public String[] importGraph(File source) throws Exception {

		// copy
		File destinationDirectory = this.graphManager.getWorkbenchDir();
		try {
			FileUtils.copyFileToDirectory(source, destinationDirectory);
		} catch (Exception e) {
			throw e;
		}
		String pathname = destinationDirectory.getPath() + File.separator
				+ source.getName();
		File copy = null;
		try {
			copy = new File(pathname);
		} catch (Exception e) {
			throw e;
		}

		// names
		String[] names = null;
		try {
			boolean ok = this.graphManager.add(copy);
			if (ok)
				names = this.getGraphs();
			return names;
		} catch (Exception e) {
			FileUtils.fileDelete(pathname);
			throw e;
		}

	}

	@Override
	public Graph<IVertex, IEdge> clearGraph(int index) throws Exception {
		try {
			IGravisGraph graph = this.traversal.getGraph();

			// if (graphId == graph.getId()) {
			// graph.clear();
			// return graph;
			// }

			graph = this.graphManager.clearGraph(index);
			this.traversal.setParameter(graph);
			return graph;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#getGraphNames()
	 */
	@Override
	public String[] getGraphs() throws Exception {
		try {
			return this.graphManager.getNames();
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#setAlgorithm(int)
	 */
	@Override
	public void selectAlgorithm(int index) throws Exception {
		try {
			this.traversal.setParameter(this.algorithmManager
					.getAlgorithm(index));
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#importAlgorithm(java.lang
	 * .String)
	 */
	@Override
	public String[] importAlgorithm(File source) throws Exception {

		// copy
		File destinationDirectory = this.algorithmManager.getWorkbenchDir();
		try {
			FileUtils.copyFileToDirectory(source, destinationDirectory);
		} catch (Exception e) {
			throw e;
		}
		String pathname = destinationDirectory.getPath() + File.separator
				+ source.getName();
		File copy = null;
		try {
			copy = new File(pathname);
		} catch (Exception e) {
			throw e;
		}

		// names
		String[] names = null;
		try {
			boolean ok = this.algorithmManager.add(copy);
			if (ok)
				names = this.getGraphs();
			return names;
		} catch (Exception e) {
			FileUtils.fileDelete(pathname);
			throw e;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#getAlgorithmNames()
	 */
	@Override
	public String[] getAlgorithms() throws Exception {
		try {
			return this.algorithmManager.getNames();
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#executeTraverser(ch.bfh
	 * .bti7301.hs2013.gravis.core.graph.IGraphItemStateChangeListener)
	 */
	@Override
	public void executeTraverser(ChangeListener listener) throws Exception {
		try {
			IImmutListIterator<ICommand> listIterator = this.traversal
					.execute(listener);
			this.iteratorManager.setListIterator(listIterator);
		} catch (Exception e) {
			throw e;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#getGraphIteratorSize()
	 */
	@Override
	public int getGraphIteratorSize() {
		return this.iteratorManager.getGraphIteratorSize();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#goToBeginning()
	 */
	@Override
	public void goToBeginning() throws Exception {
		try {
			this.iteratorManager.goToBeginning();
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#goToEnd()
	 */
	@Override
	public void goToEnd() throws Exception {
		try {
			this.iteratorManager.goToEnd();
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#goForward()
	 */
	@Override
	public boolean goForward() throws Exception {
		try {
			return this.iteratorManager.goForward();
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#goBackward()
	 */
	@Override
	public boolean goBackward() throws Exception {
		try {
			return this.iteratorManager.goBackward();
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#deleteGraph()
	 */
	@Override
	public String[] deleteGraph(File file) throws Exception {
		try {
			this.graphManager.deleteGraph(file);
			this.traversal.setParameter(GraphFactory.createIGravisGraph());
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#deleteAlgorithm()
	 */
	@Override
	public String[] deleteAlgorithm(File file) throws Exception {
		try {
			this.algorithmManager.deleteAlgorithm(file);
			this.traversal.setParameter(this.algorithmManager
					.getDefaultAlgorithm());
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

	@Override
	public File getGraphTemplatesDir() {
		return this.graphManager.getTemplatesDir();
	}

	@Override
	public File getGraphWorkbenchDir() {
		return this.graphManager.getWorkbenchDir();
	}

	@Override
	public FileNameExtensionFilter getGraphFilter() {
		return this.graphManager.getFilter();
	}

	@Override
	public File getAlgorithmTemplatesDir() {
		return this.algorithmManager.getTemplatesDir();
	}

	@Override
	public File getAlgorithmWorkbenchDir() {
		return this.algorithmManager.getWorkbenchDir();
	}

	@Override
	public FileNameExtensionFilter getAlgorithmFilter() {
		return this.algorithmManager.getFilter();
	}

}
