package vistra.gui.view.component.vizualization.transformer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.vertex.IVertex;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexColorStringTransformer implements
		Transformer<IVertex, String> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.commons.collections15.Transformer#transform(java.lang.Object)
	 */
	@Override
	public String transform(IVertex vertex) {
		return ValueTransformer
				.transformColorToString(vertex.getCurrentColor());
	}

}
