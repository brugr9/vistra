package vistra.core.graph.item;

import java.awt.Color;


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
	public void setLineWidth(float width) {
		this.layout.setLineWidth(width);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setDash(float[] dash) {
		this.layout.setDash(dash);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLineColor(Color color) {
		this.layout.setLineColor(color);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFontStyle(int style) {
		this.layout.setFontStyle(style);
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
	public float getLineWidth() {
		return this.layout.getLineWidth();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public float[] getDash() {
		return this.layout.getDash();
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
	public int getFontStyle() {
		return this.layout.getFontStyle();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Color getFontColor() {
		return this.layout.getFontColor();
	}

}
