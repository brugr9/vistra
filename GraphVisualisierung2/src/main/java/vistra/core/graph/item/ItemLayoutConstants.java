/**
 * 
 */
package vistra.core.graph.item;

/**
 * Constants for the item layout.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class ItemLayoutConstants {

	/* layout */
	public final static float STROKE_WIDTH_DEFAULT = 1.5f;
	public final static float STROKE_WIDTH_BOLD = 3.0f;
	/* vertex */
	public final static double V_HEIGHT_DEFAULT = 40.0;
	public final static double V_WIDTH_DEFAULT = 45.0;
	public final static int V_FONT_SIZE_DEFAULT = 18;
	public final static float V_TAGGED_STROKE = 3.0f;
	/* edge */
	public final static int E_FONT_SIZE_DEFAULT = 18;
	public final static float E_DASH_PHASE = 1.0f;
	public final static float[] E_SOLID = null;
	public final static float[] E_DASHED = new float[] { 12.0f, 10.0f };
	public final static float[] E_DASH_SHORT = new float[] { 1.0f, 8.0f };
	public final static float[] E_DASH_POINT = new float[] { 10.0f, 10.0f,
			1.0f, 10.0f };

	/**
	 * A main (no-)constructor.
	 */
	private ItemLayoutConstants() {
	}
}
