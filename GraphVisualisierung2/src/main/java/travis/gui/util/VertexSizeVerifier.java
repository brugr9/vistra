package travis.gui.util;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

/**
 * An input verifier for the vertex size.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class VertexSizeVerifier extends AbstractGravisVerifier {

	/**
	 * A field for the minimum value.
	 */
	private static final double MIN_VALUE = 10.0;
	/**
	 * A field for the maximum value.
	 */
	private static final double MAX_VALUE = 500.0;

	/**
	 * Main constructor.
	 * 
	 * @param lastGood
	 */
	public VertexSizeVerifier(String lastGood) {
		super(lastGood);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.InputVerifier#verify(javax.swing.JComponent)
	 */
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean verify(JComponent input) {
		if (input instanceof JTextComponent) {
			JTextComponent textField = (JTextComponent) input;
			double value = 0.0;

			try {
				value = Integer.parseInt(textField.getText());
			} catch (Exception e) {
				return false;
			}

			return value >= MIN_VALUE && value <= MAX_VALUE;
		}

		return false;
	}

}
