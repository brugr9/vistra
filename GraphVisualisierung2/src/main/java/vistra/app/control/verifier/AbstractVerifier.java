package vistra.app.control.verifier;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

/**
 * An abstract input verifier.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
abstract class AbstractVerifier extends InputVerifier {

	/**
	 * A field for the last good.
	 */
	private String lastGood;

	/**
	 * Main constructor.
	 * 
	 * @param lastGood
	 *            the last good
	 */
	protected AbstractVerifier(String lastGood) {
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
