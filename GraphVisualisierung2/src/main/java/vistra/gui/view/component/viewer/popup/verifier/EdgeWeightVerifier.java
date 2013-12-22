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
				Double.parseDouble(textField.getText());
			} catch (Exception e) {
				return false;
			}

			return true;
		}

		return false;
	}
}
