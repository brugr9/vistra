package vistra.framework.util.palette;

import java.text.DecimalFormatSymbols;

/**
 * A sigma palette.
 * 
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public enum SigmaPalette {

	/**
	 * Signs from A to Z in upper case.
	 */
	ALPHABET(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
			"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
			"X", "Y", "Z" }),
	/**
	 * Sign for infinity.
	 */
	INFINITY(new String[] { new DecimalFormatSymbols().getInfinity() }),

	;

	/**
	 * The sigma.
	 */
	private String[] s;

	/**
	 * Main constructor.
	 * 
	 * @param s
	 *            a sigma
	 */
	private SigmaPalette(String[] s) {
		this.s = s;
	}

	/**
	 * Returns the sigma.
	 * 
	 * @return the sigma
	 */
	public String[] getSigma() {
		return this.s;
	}

	/**
	 * Signs from A to Z in upper case.
	 */
	public final static String[] alphabet = ALPHABET.getSigma();
	/**
	 * Sign for infinity.
	 */
	public final static String infinity = INFINITY.getSigma()[0];

}
