/**
 * 
 */
package vistra.framework.util.palette;

/**
 * A palette of constants.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public enum ConstantPalette {

	/**
	 * A second (= 1000 milliseconds).
	 */
	A_SECOND(1000),

	;

	/**
	 * The value.
	 */
	private int value;

	/**
	 * Main constructor.
	 * 
	 * @param value
	 *            a value
	 */
	private ConstantPalette(int value) {
		this.value = value;
	}

	/**
	 * Returns the value.
	 * 
	 * @return the value
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * A second (= 1000 milliseconds).
	 */
	public final static int aSecond = A_SECOND.getValue();

}
