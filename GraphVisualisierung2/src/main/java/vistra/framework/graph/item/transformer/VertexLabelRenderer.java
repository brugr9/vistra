package vistra.framework.graph.item.transformer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JComponent;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.ILayoutVertex;
import vistra.framework.util.palette.ColorPalette;
import edu.uci.ics.jung.visualization.renderers.DefaultVertexLabelRenderer;

/**
 * A label renderer: vertex.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexLabelRenderer extends DefaultVertexLabelRenderer {

	private static final long serialVersionUID = 1L;

	/**
	 * A field for a layout transformer.
	 */
	protected Transformer<ILayoutVertex, Color> layoutTransformer;

	/**
	 * Main constructor.
	 */
	public VertexLabelRenderer() {
		super(ColorPalette.cherry);
		this.layoutTransformer = new VertexFontColor();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <V> Component getVertexLabelRendererComponent(JComponent vv,
			Object value, Font font, boolean isSelected, V vertex) {
		super.setForeground(this.layoutTransformer
				.transform((ILayoutVertex) vertex));
		if (isSelected)
			super.setForeground(super.pickedVertexLabelColor);
		super.setBackground(vv.getBackground());
		if (font != null) {
			setFont(font);
		} else {
			setFont(vv.getFont());
		}
		setIcon(null);
		setBorder(noFocusBorder);
		setValue(value);
		return this;
	}

}
