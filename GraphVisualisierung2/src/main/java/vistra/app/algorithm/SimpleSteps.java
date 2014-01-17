package vistra.app.algorithm;

import java.util.ArrayList;
import java.util.List;

import net.datastructures.Entry;
import net.datastructures.HashTableMap;
import net.datastructures.Map;
import vistra.framework.algorithm.AlgorithmException;
import vistra.framework.algorithm.IAlgorithm;
import vistra.framework.graph.ITraversableGraph;
import vistra.framework.graph.item.IEdge;
import vistra.framework.graph.item.IVertex;

/**
 * An algorithm for step testing.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class SimpleSteps extends DefaultAlgorithm implements IAlgorithm {

	/**
	 * Main constructor.
	 */
	public SimpleSteps() {
		super();
		super.description = "Ein Algorithmus zum Testen der Farben von (min. 5) Knoten und (min. 2) Kanten.";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void traverse(ITraversableGraph g) throws AlgorithmException {
		try {

			Map<IVertex, IEdge> items = new HashTableMap<IVertex, IEdge>();
			List<IVertex> v = new ArrayList<IVertex>(g.getVertices());
			List<IEdge> e = new ArrayList<IEdge>(g.getEdges());

			/* init */
			IVertex v0 = v.get(0);
			v.remove(0);
			g.stepInitializedVertex(v0, v);
			/* value */
			g.stepUpdatedVertex(v.get(0), 5);
			/* visit */
			for (int i = 1; i < v.size(); i++)
				items.put(v.get(i), e.get(i));
			for (Entry<IVertex, IEdge> entry : items.entrySet()) {
				g.stepVisit(entry.getKey(), entry.getValue());
			}
			/* edge */
			g.stepBackEdge(e.get(1));
			g.stepForwardEdge(e.get(2));
			g.stepCrossEdge(e.get(3));
			g.stepDiscardedEdge(e.get(4));
			/* solution */
			g.stepSolutionMember(v.get(4), e.get(0));

		} catch (Exception e) {
			throw new AlgorithmException(e);
		}
	}
}
