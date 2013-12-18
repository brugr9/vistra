package vistra.gui.util;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

/**
 * An input verifier for the edge weight.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class EdgeWeightVerifier extends AbstractGravisVerifier {

	/**
	 * Main constructor.
	 * 
	 * @param lastGood
	 */
	public EdgeWeightVerifier(String lastGood) {
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

			try {
				Double.parseDouble(textField.getText());
			} catch (Exception e) {
				return false;
			}

			return true;
		}

		return false;
	}
}
