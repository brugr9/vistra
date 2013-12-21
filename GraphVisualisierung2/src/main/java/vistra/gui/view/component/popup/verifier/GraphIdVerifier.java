package vistra.gui.view.component.popup.verifier;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

/**
 * An graph identifier verifier.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class GraphIdVerifier extends AbstractVerifier {

	/**
	 * Main constructor.
	 * 
	 * @param lastGood
	 */
	public GraphIdVerifier(String lastGood) {
		super(lastGood);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean verify(JComponent input) {
		if (input instanceof JTextComponent) {
			JTextComponent textField = (JTextComponent) input;

			return !textField.getText().trim().isEmpty();
		}

		return false;
	}

}
