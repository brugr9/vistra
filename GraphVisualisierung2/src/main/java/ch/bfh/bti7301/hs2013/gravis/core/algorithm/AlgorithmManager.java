package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import java.io.File;
import java.io.IOException;

import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;

import ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm.GraphType;
import ch.bfh.bti7301.hs2013.gravis.core.AbstractParameterManager;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class AlgorithmManager extends AbstractParameterManager implements
		IAlgorithmManager {

	/**
	 * Main constructor
	 * 
	 * @param templatesDir
	 *            the templates directory
	 * @param workbenchDir
	 *            the workbench directory
	 * @param filter
	 *            the filename extension filter
	 */
	public AlgorithmManager(File templatesDir, File workbenchDir,
			FileNameExtensionFilter filter) {
		super(templatesDir, workbenchDir, filter);
		try {
			// TODO validation?
			super.putAll(templatesDir.listFiles());
			super.putAll(workbenchDir.listFiles());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean importAlgorithm(File file) throws Exception {
		try {
			AlgorithmFactory.createAlgorithm(file);
			super.add(file);
			return true;
			// TODO remove 'fakes'
			// return new AlgorithmDFSRecursive();
			// return new AlgorithmDLSRecursive();
			// return new AlgorithmDijkstra();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public IAlgorithm getAlgorithm(int index) throws Exception {
		try {
			File file = super.getFile(index);
			return AlgorithmFactory.createAlgorithm(file);
			// TODO bitte dummy value auskommentieren und nicht löschen
			// return new AlgorithmDLSRecursive();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public IAlgorithm getDefaultAlgorithm() throws Exception {
		try {
			return new AlgorithmDefault();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void updateAlgorithmList(EdgeType[] types) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean deleteAlgorithm(File file) throws Exception {
		try {
			FileUtils.deleteQuietly(file);
			return super.remove(file);
		} catch (Exception e) {
			throw e;
		}
	}

}
