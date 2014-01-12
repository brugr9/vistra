package vistra.framework.algorithm;

import java.util.ArrayList;
import java.util.Properties;

import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * An algorithm manager.
 * <p>
 * An algorithm manager holds two lists:
 * <ul>
 * <li>a list with all algorithms available
 * <li>a list with algorithms supporting an edge type (as a selection out of the
 * algorithms available)
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
final class AlgorithmManager implements IAlgorithmManager {

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
	AlgorithmManager(Properties p) {
		super();
		this.supported = new ArrayList<IAlgorithm>();
		available = new ArrayList<IAlgorithm>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addAvailable(IAlgorithm algorithm) throws Exception {
		return this.available.add(algorithm);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean removeAvailable(IAlgorithm algorithm) throws Exception {
		this.supported.remove(algorithm);
		return this.available.remove(algorithm);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateSupported(EdgeType edgeType) throws Exception {
		try {
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
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] getNames() throws Exception {
		try {
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
	public IAlgorithm getSupported(int index) throws Exception {
		try {
			return this.supported.get(index);
		} catch (Exception e) {
			throw e;
		}
	}

}
