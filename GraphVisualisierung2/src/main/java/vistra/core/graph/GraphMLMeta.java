package vistra.core.graph;

import vistra.util.ColorPalette;

/**
 * Metadata properties for GraphML elements.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * @see ColorPalette
 */
public interface GraphMLMeta {

	/* vertex */
	// geometry
	// public final static int V_LOC_X_DEFAULT = 0;
	// public final static int V_LOC_Y_DEFAULT = 0;
	public final static double V_HEIGHT_DEFAULT = 40.0;
	public final static double V_WIDTH_DEFAULT = 45.0;
	public final static String V_LOC_X = "vertexLocation.x";
	public final static String V_LOC_Y = "vertexLocation.y";
	// public final static String V_WIDTH = "vertexWidth";
	// public final static String V_HEIGHT = "vertexHeight";
	// quality
	public final static String V_START = "startVertex";
	public final static String V_END = "endVertex";
	public final static String V_COLOR = "vertexColor";
	// public final static String V_LINE_COLOR = "vertexLineColor";
	// public final static String V_BG_COLOR = "vertexBgColor";

	/* edge */
	// quality
	public final static double E_WEIGHT_DEFAULT = 1.0;
	public final static String E_WEIGHT = "weight";
	public final static String E_COLOR = "edgeColor";

	/**/
	public final static float STROKE_WIDTH_DEFAULT = 1.5f;
	public final static float STROKE_WIDTH_BOLD = 3.0f;
	public final static float V_TAGGED_STROKE = 3.0f;
	public final static float E_TAGGED_STROKE = 5.0f;

}
