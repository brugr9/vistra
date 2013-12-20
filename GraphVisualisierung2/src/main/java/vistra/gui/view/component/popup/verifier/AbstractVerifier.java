package vistra.gui.view.component.popup.verifier;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

/**
 * An abstract input verifier adapted for GRAVIS.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
abstract class AbstractVerifier extends InputVerifier {

	private String lastGood;

	/**
	 * Main constructor.
	 * 
	 * @param lastGood
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
