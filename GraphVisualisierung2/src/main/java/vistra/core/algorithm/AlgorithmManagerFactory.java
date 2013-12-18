package vistra.core.algorithm;

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
	 * @param p
	 *            the core properties
	 * @return the algorithm manager
	 * @throws Exception
	 */
	public static IAlgorithmManager create(Properties p) throws Exception {
		try {
			return new AlgorithmManager(p);
		} catch (Exception e) {
			throw e;
		}
	}
}
