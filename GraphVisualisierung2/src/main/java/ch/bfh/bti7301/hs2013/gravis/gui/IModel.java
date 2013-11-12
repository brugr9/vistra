/**
 * 
 */
package ch.bfh.bti7301.hs2013.gravis.gui;

/**
 * A model as in MVC.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IModel {

	/**
	 * Disables or enables menu elements.
	 * 
	 * @param enabled
	 */
	public abstract void setMenuEnabled(boolean enabled);

	/**
	 * Disables or enables parameter elements.
	 * 
	 * @param enabled
	 */
	public abstract void setParameterEnabled(boolean enabled);

	/**
	 * Disables or enables player elements.
	 * 
	 * @param enabled
	 */
	public abstract void setPlayerEnabled(boolean enabled);

	/**
	 * Disables or enables the players step-by-step elements.
	 * 
	 * @param enabled
	 */
	public abstract void setStepByStepEnabled(boolean enabled);

}
