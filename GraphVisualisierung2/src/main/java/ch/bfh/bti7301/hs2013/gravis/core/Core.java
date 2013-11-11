package ch.bfh.bti7301.hs2013.gravis.core;

import java.io.File;

import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm.GraphType;
import ch.bfh.bti7301.hs2013.gravis.common.IEdge;
import ch.bfh.bti7301.hs2013.gravis.common.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithmManager;
import ch.bfh.bti7301.hs2013.gravis.core.command.ICommand;
import ch.bfh.bti7301.hs2013.gravis.core.graph.GraphFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IGraphManager;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#setGraph(int)
	 */
	@Override
	public Graph<IVertex, IEdge> selectGraph(String graphId) throws Exception {
		try {
			IGravisGraph graph = this.traversal.getGraph();

			if (graph.getId() == graphId) {
				return graph;
			}

			graph = this.graphManager.getGraph(graphId);
			this.traversal.setParameter(graph);
			EdgeType type = graph.getEdgeType();
			// TODO updateAlgorithmList() anpassen für EdgeType
			this.algorithmManager.updateAlgorithmList(new GraphType[] { GraphType.DIRECTED });
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
	public Graph<IVertex, IEdge> importGraph(File file) throws Exception {
		try {
			IGravisGraph graph = this.graphManager.importGraph(file);
			this.traversal.setParameter(graph);
			return graph;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Graph<IVertex, IEdge> clearGraph(String graphId) throws Exception {
		try {
			IGravisGraph graph = this.traversal.getGraph();

			if (graphId == graph.getId()) {
				graph.clear();
				return graph;
			}

			graph = this.graphManager.clearGraph(graphId);
			this.traversal.setParameter(graph);
			return graph;
		} catch (Exception e) {
			throw e;
		}
	}

	// /*
	// * (non-Javadoc)
	// *
	// * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#deleteGraph(int)
	// */
	// /**
	// * @deprecated
	// */
	// @Override
	// public void deleteGraph(String graphId) throws Exception {
	//
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#saveGraph(int)
	 */
	@Override
	public boolean saveGraph() throws Exception {
		try {
			IGravisGraph graph = this.traversal.getGraph();
			return this.graphManager.saveGraph(graph);
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#exportGraph(int)
	 */
	@Override
	public Graph<IVertex, IEdge> exportGraph(String graphId, File directory)
			throws Exception {
		try {
			if (directory.isDirectory()
					&& graphId == this.traversal.getGraph().getId()) {
				this.graphManager.exportGraph(graphId, directory);
				return this.traversal.getGraph();

			} else
				// TODO Exception handling
				throw new Exception();
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#getGraphName(int)
	 */
	@Override
	public String getGraphName(String graphId) throws Exception {
		try {
			return this.graphManager.getName(graphId);
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
	public String[] getGraphNames() throws Exception {
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
	public void selectAlgorithm(String algorithmId) throws Exception {
		try {
			this.traversal.setParameter(this.algorithmManager
					.getAlgorithm(algorithmId));
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
	public int importAlgorithm(File file) throws Exception {
		try {
			IAlgorithm algorithm = this.algorithmManager.importAlgorithm(file);
			this.traversal.setParameter(algorithm);
			return algorithm.getId();
		} catch (Exception e) {
			throw e;
		}
	}

	// /*
	// * (non-Javadoc)
	// *
	// * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#deleteAlgorithm(int)
	// */
	// /**
	// * @deprecated
	// */
	// @Override
	// public void deleteAlgorithm(String algorithmId) throws Exception {
	//
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#geAlgorithmName(int)
	 */
	@Override
	public String getAlgorithmName(String algorithmId) throws Exception {
		try {
			return this.algorithmManager.getName(algorithmId);
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#getAlgorithmNames()
	 */
	@Override
	public String[] getAlgorithmNames() throws Exception {
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
	public void deleteGraph(File file) throws Exception {
		try {
			this.graphManager.deleteGraph(file);
			this.traversal.setParameter(GraphFactory.createIGravisGraph());
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#deleteAlgorithm()
	 */
	@Override
	public void deleteAlgorithm(File file) throws Exception {
		try {
			this.algorithmManager.deleteAlgorithm(file);
			this.traversal.setParameter(this.algorithmManager
					.getDefaultAlgorithm());
		} catch (Exception e) {
			throw e;
		}
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
