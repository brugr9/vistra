package vistra.framework.graph.item.transformer;

import java.awt.Stroke;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.ILayoutVertex;

/**
 * A vertex transformer: stroke.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexStroke implements Transformer<ILayoutVertex, Stroke> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Stroke transform(ILayoutVertex layout) {
		return layout.getStroke();
	}

}
