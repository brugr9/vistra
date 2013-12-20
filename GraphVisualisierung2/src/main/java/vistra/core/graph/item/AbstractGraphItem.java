package vistra.core.graph.item;

import java.awt.Color;

/**
 * An abstract graph item.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class AbstractGraphItem implements IGraphItem {

	/**
	 * A field for an identifier.
	 */
	private String id;

	public AbstractGraphItem() {
		this.id = "";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public float getLineWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLineWidth(float width) {
		// TODO Auto-generated method stub

	}

	@Override
	public Color getLineColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLineColor(Color color) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getFontSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void getFontSize(double size) {
		// TODO Auto-generated method stub

	}

	@Override
	public Color getFontColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFontColor(Color color) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Color getBGColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBGColor(Color color) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValue(double value) {
		// TODO Auto-generated method stub

	}

}
