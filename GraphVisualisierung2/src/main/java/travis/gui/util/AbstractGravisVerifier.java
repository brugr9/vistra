package travis.gui.util;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

/**
 * An abstract input verifier adapted for GRAVIS.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
abstract class AbstractGravisVerifier extends InputVerifier {

	private String lastGood;

	/**
	 * Main constructor.
	 * 
	 * @param lastGood
	 */
	protected AbstractGravisVerifier(String lastGood) {
		super();
		this.lastGood = lastGood;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean shouldYieldFocus(JComponent input) {
		if (input instanceof JTextComponent) {
			JTextComponent textField = (JTextComponent) input;
			boolean inputOK = this.verify(input);

			if (inputOK) {
				this.lastGood = textField.getText();
				return true;
			} else {
				textField.setText(this.lastGood);
				return false;
			}
		}

		return false;
	}

}
