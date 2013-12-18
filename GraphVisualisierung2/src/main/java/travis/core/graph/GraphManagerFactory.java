package travis.core.graph;

import java.util.Properties;

/**
 * A graph manager factory.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class GraphManagerFactory {

	/**
	 * A main (no-)constructor.
	 */
	private GraphManagerFactory() {
	}

	/**
	 * Creates a graph manager.
	 * 
	 * @param p
	 *            the core properties
	 * @return the graph manager
	 */
	public static IGraphManager create(Properties p)
			throws Exception {

		try {
			return new GraphManager(p);
		} catch (Exception e) {
			throw e;
		}

	}

}
