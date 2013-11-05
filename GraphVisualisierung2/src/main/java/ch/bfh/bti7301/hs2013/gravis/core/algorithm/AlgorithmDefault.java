package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

/**
 * A default algorithm implementing the interface <code>IAlgorithm</code> by
 * extending <code>AbstractAlgorithm</code>.
 * <p>
 * Does nothing on execute().
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class AlgorithmDefault extends AbstractAlgorithm {

	/**
	 * Main Constructor.
	 */
	public AlgorithmDefault() {
		super.setName("----------");
		super.setDescription("A default algorithm just implementing the interface"
				+ "IAlgorithm. Does nothing on execute.");
		super.setGraphTypes(new GraphType[] { GraphType.UNDIRECTED,
				GraphType.DIRECTED, GraphType.UNWEIGHTED, GraphType.WEIGHTED,
				GraphType.SINGLEEDGE, GraphType.MULTIEDGE });
	}

}
