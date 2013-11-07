package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import java.io.File;
import java.util.Properties;

import javax.swing.filechooser.FileNameExtensionFilter;

import ch.bfh.bti7301.hs2013.gravis.common.IAlgorithm;
import ch.bfh.bti7301.hs2013.gravis.core.util.FileUtil;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class AlgorithmFactory {

	/**
	 * A main (no-)constructor.
	 */
	private AlgorithmFactory() {
	}

	/**
	 * 
	 * @param p
	 *            the core properties
	 * @return a new instance of type IAlgorithmManager
	 * @throws Exception
	 */
	public static IAlgorithmManager createAlgorithmManager(Properties p)
			throws Exception {
		try {
//			File templatesDir = new File(
//					p.getProperty("dir.templates.algorithm"));
//			templatesDir.setReadOnly();
//			File workbenchDir = new File(
//					p.getProperty("dir.workbench.algorithm"));
//			FileNameExtensionFilter filter = new FileNameExtensionFilter(
//					p.getProperty("suffix.algorithm.description"),
//					new String[] { p.getProperty("suffix.algorithm.source"),
//							p.getProperty("suffix.algorithm.binary"),
//							p.getProperty("suffix.algorithm.archive") });
			
			// TODO activate properties
			return new AlgorithmManager(null, null, null);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Instantiates an algorithm in runtime, given as java *.class or *.jar
	 * file. The file has to implement <code>IAlgorithm</code>.
	 * 
	 * @param file
	 *            the algorithm file
	 * @return the algorithm
	 * @throws Exception
	 */
	public static IAlgorithm createAlgorithm(File file) throws Exception {

		try {

			ClassLoader cl = AlgorithmFactory.class.getClassLoader();
			Class<?> c = cl.loadClass(FileUtil.getSuffix(file));
			return (IAlgorithm) c.newInstance();

		} catch (SecurityException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw e;
		} catch (IllegalAccessException e) {
			throw e;
		} catch (InstantiationException e) {
			throw e;
		} catch (ExceptionInInitializerError e) {
			throw e;
		} catch (ClassCastException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}

	}

}
