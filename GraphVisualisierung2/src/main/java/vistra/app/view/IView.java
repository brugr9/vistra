package vistra.app.view;

import java.util.Observer;

/**
 * A view interface.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface IView extends Observer {
	/**
	 * A field for the frame width.
	 */
	public static int FRAME_WIDTH = 1200;
	/**
	 * A field for the visualisation width.
	 */
	public static int VISUALISATION_WIDTH = 920;
	/**
	 * A field for the frame height.
	 */
	public static int FRAME_HEIGHT = 710;
	/**
	 * A field for the visualisation height.
	 */
	public static int VISUALISATION_HEIGHT = 610;
	/**
	 * A field for the border.
	 */
	public static int BORDER = 10;

	/**
	 * View types.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum ViewType {
		DEFAULT, FULL;
	}
}
