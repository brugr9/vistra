package vistra.gui.view.component.vizualization.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.vertex.IVertex;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexToolTipTransformer implements Transformer<IVertex, String> {

	@Override
	public String transform(IVertex vertex) {
		return "Knoten " + vertex.getId() + ": (x = "
				+ new Double(vertex.getLocation().getX()).intValue() + ", y = "
				+ new Double(vertex.getLocation().getY()).intValue() + ")";
	}

}
