package vistra.core.algorithm;

import java.util.ArrayList;
import java.util.Properties;
import vistra.core.algorithm.impl.BFS;
import vistra.core.algorithm.impl.DFS;
import vistra.core.algorithm.impl.DLS;
import vistra.core.algorithm.impl.Default;
import vistra.core.algorithm.impl.Dijkstra;
import vistra.core.algorithm.impl.Kruskal;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An algorithm manager.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class AlgorithmManager implements IAlgorithmManager {

	/**
	 * A field for a list of algorithms available.
	 */
	private ArrayList<IAlgorithm> available;
	/**
	 * A field for a list of supported algorithms.
	 */
	private ArrayList<IAlgorithm> supported;

	/**
	 * Main constructor.
	 * 
	 * @param p
	 *            the properties
	 */
	public AlgorithmManager(Properties p) {
		super();
		this.supported = new ArrayList<IAlgorithm>();
		available = new ArrayList<IAlgorithm>();
		available.add(new Default());
		available.add(new BFS());
		available.add(new DFS());
		available.add(new DLS());
		available.add(new Dijkstra());
		available.add(new Kruskal());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getNames(EdgeType edgeType) throws Exception {
		try {
			/* update algorithmsSupported */
			this.supported.clear();
			EdgeType[] capabilities;
			for (IAlgorithm a : this.available) {
				capabilities = a.getEdgeTypes();
				for (int i = 0; i < capabilities.length; i++) {
					if (capabilities[i] == edgeType) {
						this.supported.add(a);
						break;
					}
				}
			}
			/* get names from algorithmsSupported */
			String[] names = new String[this.supported.size()];
			for (int i = 0; i < names.length; i++) {
				names[i] = this.supported.get(i).getName();
			}
			return names;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public IAlgorithm select(int index) throws Exception {
		try {
			return this.supported.get(index);
		} catch (Exception e) {
			throw e;
		}
	}

}
