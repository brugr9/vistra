package vistra.gui.view.component.vizualization.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.vertex.IVertex;
import vistra.util.GraphPropertyConstants;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexHeightTransformer implements Transformer<IVertex, String> {

	@Override
	public String transform(IVertex vertex) {
		return String.valueOf(GraphPropertyConstants.V_HEIGHT_DEFAULT);
	}

}
