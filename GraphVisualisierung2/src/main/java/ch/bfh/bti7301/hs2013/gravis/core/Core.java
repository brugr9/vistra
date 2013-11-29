package ch.bfh.bti7301.hs2013.gravis.core;

import java.io.File;

import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.maven.shared.utils.io.FileUtils;

import ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithmManager;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IGraphManager;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;
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

	/**
	 * @param graphManager
	 * @param algorithmManager
	 * @param traversal
	 * @param iteratorManager
	 */
	protected Core(IGraphManager graphManager,
			IAlgorithmManager algorithmManager, ITraversal traversal) {
		this.graphManager = graphManager;
		this.algorithmManager = algorithmManager;
		this.traversal = traversal;
	}

	@Override
	public IGravisGraph selectGraph(int index) throws Exception {
		try {
			// as shown in sd-select-graph
			IGravisGraph graph = this.graphManager.getGraph(index);
			this.traversal.setParameter(graph);
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

		// as shown in sd-import-graph

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
	public void clearGraph(int index) throws Exception {
		try {
			this.graphManager.clearGraph(index);
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

		// as shown in sd-import-algorithm

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
				names = this.getAlgorithms();
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
			EdgeType type = this.traversal.getGraph().getEdgeType();
			return this.algorithmManager.getNames(type);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public IGravisListIterator<String> executeTraverser(TraversalChangeListener listener)
			throws Exception {
		try {
			return new StepIterator(this.traversal.execute(listener));
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
			// as shown in sd-delete-graph
			// TODO this is a main success scenario
			boolean ok1 = this.graphManager.remove(file);
			boolean ok2 = file.delete();
			String[] names = this.getGraphs();
			return names;
		} catch (Exception ex) {
			throw ex;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#deleteAlgorithm()
	 */
	@Override
	public String[] deleteAlgorithm(File file) throws Exception {

		try {
			// as shown in sd-delete-algorithm
			// TODO this is a main success scenario
			boolean ok1 = this.algorithmManager.remove(file);
			boolean ok2 = file.delete();
			String[] names = this.getAlgorithms();
			return names;
		} catch (Exception ex) {
			throw ex;
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

	@Override
	public void saveGraph(IGravisGraph graph) throws Exception {
		try {
			this.graphManager.saveGraph(graph);
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.ICore#exportGraph(ch.bfh.bti7301.hs2013
	 * .gravis.core.graph.IGravisGraph, java.io.File)
	 */
	@Override
	public void exportGraph(IGravisGraph graph, File file) throws Exception {
		try {
			this.graphManager.exportGraph(graph, file);
		} catch (Exception e) {
			throw e;
		}
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.ICore#selectGraph(ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph)
	 */
	@Override
	public void selectGraph(IGravisGraph graph) {
		try {
			this.traversal.setParameter(graph);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
