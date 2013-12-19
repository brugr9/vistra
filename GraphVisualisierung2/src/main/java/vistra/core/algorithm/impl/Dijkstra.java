package vistra.core.algorithm.impl;

import vistra.common.IAlgorithm;
import vistra.core.algorithm.AbstractAlgorithm;
import vistra.core.algorithm.AlgorithmException;
import vistra.core.graph.zobsolete.IRestrictedGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * Dijkstra algorithm.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class Dijkstra extends AbstractAlgorithm implements IAlgorithm {

	/**
	 * A field for a description.
	 */
	private final static String ALGO_DESCRIPTION = "Der Dijkstra-Algorithmus findet den "
			+ "kürzesten Weg zwischen zwei Knoten. Ein Startknoten muss im Graphen vorhanden "
			+ "sein. Ist kein Endknoten vorhanden, so wird der kürteste Weg vom Startknoten "
			+ "zu allen anderen Knoten berechnet. Diese Implementation des Algorithmus "
			+ "funktioniert mit gerichteten oder ungerichteten Kanten. Negative "
			+ "Kantengewichte und Mehrfachkanten sind nicht erlaubt.";

	/**
	 * Main constructor.
	 */
	public Dijkstra() {
		super();
		super.setDescription(ALGO_DESCRIPTION);
		super.setEdgeTypes(new EdgeType[] { EdgeType.UNDIRECTED,
				EdgeType.DIRECTED });
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverse(IRestrictedGraph graph) throws AlgorithmException {
		// TODO
	}

}
