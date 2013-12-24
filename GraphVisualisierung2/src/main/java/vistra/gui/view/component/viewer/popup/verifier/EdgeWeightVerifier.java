package vistra.gui.view.component.viewer.popup.verifier;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

/**
 * An edge weight verifier.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgeWeightVerifier extends AbstractVerifier {

	/**
	 * Main constructor.
	 * 
	 * @param lastGood
	 */
	public EdgeWeightVerifier(String lastGood) {
		super(lastGood);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean verify(JComponent input) {
		if (input instanceof JTextComponent) {
			JTextComponent textField = (JTextComponent) input;

			try {
				Integer.parseInt(textField.getText());
			} catch (Exception e) {
				throw new IllegalArgumentException("integer value");
			}

			return true;
		}

		return false;
	}
}
