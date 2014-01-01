package vistra.gui.control.verifier;

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
			String text = ((JTextComponent) input).getText();
			try {
				Integer.parseInt(text);
			} catch (NumberFormatException e) {
				throw e;
			}
			return true;
		}

		return false;
	}
}
