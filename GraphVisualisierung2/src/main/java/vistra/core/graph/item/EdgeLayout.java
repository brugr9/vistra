package vistra.core.graph.item;

import java.awt.Color;
import java.awt.Stroke;

/**
 * An edge layout.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeLayout extends Edge implements IEdgeLayout {

	/**
	 * A field for an item layout to work with.
	 */
	private ItemLayout layout;

	/**
	 * Main constructor.
	 */
	public EdgeLayout() {
		super();
		this.layout = new ItemLayout();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setWeight(int weight) {
		this.weight = weight;
		this.setChanged();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(String id) {
		this.layout.setId(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStroke(Stroke storke) {
		this.layout.setStroke(storke);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setStrokeColor(Color color) {
		this.layout.setStrokeColor(color);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFont(int style) {
		this.layout.setFont(style);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFontColor(Color color) {
		this.layout.setFontColor(color);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return this.layout.getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Stroke getStroke() {
		return this.layout.getStroke();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getStrokeColor() {
		return this.layout.getStrokeColor();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getFont() {
		return this.layout.getFont();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getFontColor() {
		return this.layout.getFontColor();
	}

}
