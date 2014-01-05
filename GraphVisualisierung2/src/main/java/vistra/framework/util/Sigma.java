package vistra.framework.util;

import java.text.DecimalFormatSymbols;

/**
 * Some signs.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 *         TODO replace by enum
 */
public interface Sigma {

	/**
	 * A sign for an initial state.
	 * 
	 */
	public final static String INFINITY = new DecimalFormatSymbols()
			.getInfinity();

	/**
	 * An array of signs from A to Z in upper case.
	 */
	public final static String[] ALPHABET = { "A", "B", "C", "D", "E", "F",
			"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
			"T", "U", "V", "W", "X", "Y", "Z" };

}
