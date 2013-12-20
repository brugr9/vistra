package vistra.gui.view.component.vizualization.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.vertex.IVertex;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class StartVertexTransformer implements Transformer<IVertex, String> {

	@Override
	public String transform(IVertex vertex) {
		return String.valueOf(vertex.isStart());
	}

}
