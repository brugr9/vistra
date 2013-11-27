package ch.bfh.bti7301.hs2013.gravis.gui.verifier;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class EdgeWeightVerifier extends AbstractGravisVerifier {

	/**
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
