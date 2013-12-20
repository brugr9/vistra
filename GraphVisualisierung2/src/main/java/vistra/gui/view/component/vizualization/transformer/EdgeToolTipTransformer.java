package vistra.gui.view.component.vizualization.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.edge.IEdge;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeToolTipTransformer implements Transformer<IEdge, String> {

	@Override
	public String transform(IEdge edge) {
		return "Kante " + edge.getId();
	}

}
