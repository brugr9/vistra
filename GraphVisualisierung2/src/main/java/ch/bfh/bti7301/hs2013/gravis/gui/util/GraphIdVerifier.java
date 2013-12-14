package ch.bfh.bti7301.hs2013.gravis.gui.util;

import javax.swing.JComponent;
import javax.swing.text.JTextComponent;

/**
 * An input verifier for the graph identifier.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class GraphIdVerifier extends AbstractGravisVerifier {

	/**
	 * Main constructor.
	 * 
	 * @param lastGood
	 */
	public GraphIdVerifier(String lastGood) {
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

			return !textField.getText().trim().isEmpty();
		}

		return false;
	}

}
