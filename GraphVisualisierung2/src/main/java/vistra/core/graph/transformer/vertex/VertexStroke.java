package vistra.core.graph.transformer.vertex;

import java.awt.BasicStroke;
import java.awt.Stroke;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.item.IVertexLayout;

/**
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexStroke implements Transformer<IVertexLayout, Stroke> {

	@Override
	public Stroke transform(IVertexLayout layout) {
		return new BasicStroke(layout.getLineWidth());
	}

}
