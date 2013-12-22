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
class AlgorithmManager implements IAlgorithmManager {

	/**
	 * A field for a list of algorithms available.
	 */
	private ArrayList<IAlgorithm> algorithmsAvailable;
	/**
	 * A field for a list of supported algorithms.
	 */
	private ArrayList<IAlgorithm> algorithmsSupported;

	/**
	 * Main constructor.
	 * 
	 * @param p
	 *            the properties
	 */
	public AlgorithmManager(Properties p) {
		super();
		this.algorithmsSupported = new ArrayList<IAlgorithm>();
		this.algorithmsAvailable = new ArrayList<IAlgorithm>();
		this.addAlgorithmsAvailable();
	}

	/**
	 * Adds available algorithms.
	 */
	private void addAlgorithmsAvailable() {
		this.algorithmsAvailable.clear();
		this.algorithmsAvailable.add(new Default());
		this.algorithmsAvailable.add(new BFS());
		this.algorithmsAvailable.add(new DFS());
		this.algorithmsAvailable.add(new DLS());
		this.algorithmsAvailable.add(new Dijkstra());
		this.algorithmsAvailable.add(new Kruskal());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getNames(EdgeType edgeType) throws Exception {
		try {
			/* update algorithmsSupported */
			this.algorithmsSupported.clear();
			EdgeType[] capabilities;
			for (IAlgorithm a : this.algorithmsAvailable) {
				capabilities = a.getEdgeTypes();
				for (int i = 0; i < capabilities.length; i++) {
					if (capabilities[i] == edgeType) {
						this.algorithmsSupported.add(a);
						break;
					}
				}
			}
			/* get names from algorithmsSupported */
			String[] names = new String[this.algorithmsSupported.size()];
			for (int i = 0; i < names.length; i++) {
				names[i] = this.algorithmsSupported.get(i).getName();
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
			return this.algorithmsSupported.get(index);
		} catch (Exception e) {
			throw e;
		}
	}

}
