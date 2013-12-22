package vistra.core.graph;

import vistra.util.ColorPalette;

/**
 * Metadata properties for GraphML elements.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see ColorPalette
 */
public interface GraphMLMeta {

	// geometry
	// public final static int V_LOC_X_DEFAULT = 0;
	// public final static int V_LOC_Y_DEFAULT = 0;
	public final static String V_LOC_X = "coord.x";
	public final static String V_LOC_Y = "coord.y";
	// quality
	public final static String V_START = "start";
	public final static String V_END = "end";
	public final static String E_WEIGHT = "weight";

	/**/
	public final static double V_HEIGHT_DEFAULT = 40.0;
	public final static double V_WIDTH_DEFAULT = 45.0;
	public final static double E_WEIGHT_DEFAULT = 1.0;
	/**/
	public final static float STROKE_WIDTH_DEFAULT = 1.5f;
	public final static float STROKE_WIDTH_BOLD = 3.0f;
	public final static float V_TAGGED_STROKE = 3.0f;
	public final static float E_TAGGED_STROKE = 5.0f;

}
