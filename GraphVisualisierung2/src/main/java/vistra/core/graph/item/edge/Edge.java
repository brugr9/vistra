package vistra.core.graph.item.edge;

import vistra.core.graph.GraphMeta;

/**
 * An edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class Edge extends AbstractEdgeLayout implements IEdge {

	/**
	 * Main constructor.
	 */
	Edge() {
		super(GraphMeta.E_WEIGHT_DEFAULT);
	}

}
