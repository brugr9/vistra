package ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.transformer;

import java.awt.Paint;

import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 */
public class VertexColorTransformer implements Transformer<IVertex, Paint> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.commons.collections15.Transformer#transform(java.lang.
	 * Object)
	 */
	@Override
	public Paint transform(IVertex vertex) {
		return vertex.getCurrentColor();
	}

}