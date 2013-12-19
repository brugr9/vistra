package vistra.core.algorithm.impl;

import vistra.common.IAlgorithm;
import vistra.core.algorithm.AbstractAlgorithm;
import vistra.core.algorithm.AlgorithmException;
import vistra.core.zobsolete.graph.IRestrictedGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * Kruskal, Minimal Spanning Forest.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class Kruskal extends AbstractAlgorithm implements IAlgorithm {

	/**
	 * A field for a description.
	 */
	private final static String ALGO_DESCRIPTION = "Diese Implementation "
			+ "berechnet einen minimalen Spannwald für einen gegebenen Graphen. "
			+ "Der Graph muss ungerichtet sein. Ein Start- und Endknoten muss nicht "
			+ "angegeben werden. Die Kanten der Lösung zeigen neben dem Gewicht auch "
			+ "an, in welcher Reihenfolge sie zur Lösung hinzugefügt wurden.";

	/**
	 * Main constructor.
	 */
	public Kruskal() {
		super();
		super.setDescription(ALGO_DESCRIPTION);
		super.setEdgeTypes(new EdgeType[] { EdgeType.UNDIRECTED });
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverse(IRestrictedGraph graph) throws AlgorithmException {
		// TODO
	}

}
