package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import java.io.File;
import java.io.IOException;

import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;

import ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm.GraphType;
import ch.bfh.bti7301.hs2013.gravis.core.AbstractParameterManager;

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
			// TODO read from templatesDir as well as from workbenchDir and add
			// TODO validation?
			
			// TODO activate properties
			
//			super.putAll(templatesDir.listFiles());
//			super.putAll(workbenchDir.listFiles());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithmManager#importAlgorithm
	 * (java.lang.String)
	 */
	@Override
	public IAlgorithm importAlgorithm(File file) throws Exception {
		try {
			if (file.isFile()) {
				FileUtils.copyFileToDirectory(file, this.getWorkbenchDir());
				File theCopy = new File(this.getWorkbenchDir() + file.getName());
				IAlgorithm algorithm = AlgorithmFactory.createAlgorithm(file);
				// TODO algorithm.getId()
				super.add(algorithm.getName(), theCopy);
				return algorithm;
				// TODO remove 'fakes'
				// return new AlgorithmDFSRecursive();
				// return new AlgorithmDLSRecursive();
				// return new AlgorithmDijkstra();
			} else
				throw new IOException(this.getClass().toString()
						+ ": file is not a file.");
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithmManager#getAlgorithm
	 * (int)
	 */
	@Override
	public IAlgorithm getAlgorithm(String algorithmId) throws Exception {
		try {
			// File file = super.getFile(algorithmId);
			// return AlgorithmFactory.createAlgorithm(file);
			// TODO bitte dummy value auskommentieren und nicht löschen
			return new AlgorithmDijkstra();
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithmManager#deleteAlgorithm
	 * (int)
	 */
	@Override
	public boolean deleteAlgorithm(String parameterId) throws Exception {
		try {
			File file = super.getFile(parameterId);
			boolean deleted = false;
			if (file.isFile()) {
				deleted = super.delete(file);
				// TODO update algo-lists
			}
			return deleted;
		} catch (Exception e) {
			throw e;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithmManager#
	 * getDefaultAlgorithm()
	 */
	@Override
	public IAlgorithm getDefaultAlgorithm() throws Exception {
		try {
			return new AlgorithmDefault();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void updateAlgorithmList(GraphType[] types) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.algorithm.IAlgorithmManager#deleteAlgorithm
	 * (java.io.File)
	 */
	@Override
	public void deleteAlgorithm(File file) {
		// TODO Auto-generated method stub

	}

}
