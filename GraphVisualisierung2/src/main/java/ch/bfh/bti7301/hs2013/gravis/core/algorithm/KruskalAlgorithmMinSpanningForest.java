package ch.bfh.bti7301.hs2013.gravis.core.algorithm;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph;


/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 *
 */
public class KruskalAlgorithmMinSpanningForest extends AbstractAlgorithm {

	public KruskalAlgorithmMinSpanningForest() {
		super();
		super.setName("Kruskal algorithm");
		super.setDescription("Kruskal algorithm: Calculates a minimal spanning tree from a "
				+ "given graph. The graph must be UNDIRECTED.");
		// TODO annotations
		super.setGraphTypes(new GraphType[] {});
		// TODO init id
		super.setId(3);
	}

	/* (non-Javadoc)
	 * @see ch.bfh.bti7301.hs2013.gravis.core.algorithm.AbstractAlgorithm#execute(ch.bfh.bti7301.hs2013.gravis.core.graph.IRestrictedGraph)
	 */
	@Override
	public void execute(IRestrictedGraph graph) throws Exception {
		// TODO bitte an dieser Methode nichts ändern (pk)
		
		
	}

	
}
