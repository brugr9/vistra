package vistra.framework.graph.item.transformer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JComponent;

import org.apache.commons.collections15.Transformer;

import vistra.framework.graph.item.ILayoutEdge;
import vistra.framework.util.palette.ColorPalette;
import edu.uci.ics.jung.visualization.renderers.DefaultEdgeLabelRenderer;

/**
 * A label renderer: edge.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeLabelRenderer extends DefaultEdgeLabelRenderer {

	private static final long serialVersionUID = 1L;
	/**
	 * A field for a layout transformer
	 */
	protected Transformer<ILayoutEdge, Color> layoutTransformer;

	/**
	 * Main constructor.
	 */
	public EdgeLabelRenderer() {
		super(ColorPalette.cherry);
		this.layoutTransformer = new EdgeFontColor();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <E> Component getEdgeLabelRendererComponent(JComponent vv,
			Object value, Font font, boolean isSelected, E edge) {
		super.setForeground(this.layoutTransformer
				.transform((ILayoutEdge) edge));
		if (isSelected)
			setForeground(pickedEdgeLabelColor);
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
