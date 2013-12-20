package vistra.gui.view.component.vizualization.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.edge.IEdge;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeWeightNumberTransformer implements Transformer<IEdge, Number> {

	@Override
	public Number transform(IEdge edge) {
		return edge.getWeight();
	}

}
