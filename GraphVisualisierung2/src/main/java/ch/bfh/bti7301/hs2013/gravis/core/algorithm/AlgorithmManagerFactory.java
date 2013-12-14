package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import java.io.File;
import java.util.Properties;

/**
 * An algorithm manager factory.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class AlgorithmManagerFactory {

	/**
	 * A main (no-)constructor.
	 */
	private AlgorithmManagerFactory() {
	}

	/**
	 * Creates an algorithm manager.
	 * 
	 * @param root
	 *            the application root directory
	 * @param p
	 *            the core properties
	 * @return the algorithm manager
	 * @throws Exception
	 */
	public static IAlgorithmManager create(File root, Properties p)
			throws Exception {
		try {
			return new AlgorithmManager(root, p);
		} catch (Exception e) {
			throw e;
		}
	}
}
