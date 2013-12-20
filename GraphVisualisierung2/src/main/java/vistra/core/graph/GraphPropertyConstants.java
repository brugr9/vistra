package vistra.core.graph;

import java.awt.Color;

import vistra.util.VistraColor;

/**
 * Graph properties.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public interface GraphPropertyConstants {

	public static final String GREEN = "green";
	public static final String YELLOW = "yellow";
	public static final String BLUE = "blue";
	public static final String GRAY = "gray";
	public static final String ORANGE = "orange";
	public static final String BLACK = "black";
	public static final String RED = "red";
	public static final String WHITE = "white";
	public static final String ANTIQUE = "antique";

	public final static String E_WEIGHT = "weight";
	public final static String E_COLOR = "edgeColor";
	public final static String G_DESCRIPTION = "description";

	public final static String V_LINE_COLOR = "vertexColor";
	public final static String V_BG_COLOR = "vertexColor";
	public final static String V_LOC_X = "vertexLocation.x";
	public final static String V_LOC_Y = "vertexLocation.y";
	public final static String V_START = "startVertex";
	public final static String V_END = "endVertex";
	public final static String V_WIDTH = "vertexWidth";
	public final static String V_HEIGHT = "vertexHeight";

	public final static boolean V_START_DEFAULT = false;
	public final static boolean V_END_DEFAULT = false;

	public final static int V_LOC_X_DEFAULT = 0;
	public final static int V_LOC_Y_DEFAULT = 0;
	public final static double V_WIDTH_DEFAULT = 40.0;
	public final static double V_HEIGHT_DEFAULT = 40.0;
	public final static double E_WEIGHT_DEFAULT = 1.0;

	/* colors */
	public final static Color V_LINE_DEFAULT = VistraColor.DARK_BLUE;
	public final static Color V_BG_DEFAULT = VistraColor.LIGHT_ORANGE;
	public final static Color V_BG_START = VistraColor.YELLOW;
	public final static Color V_BG_END = VistraColor.YELLOW;
	public final static Color E_LINE_DEFAULT = VistraColor.DARK_BLUE;

	
	public final static Color INITIAL = VistraColor.DARK_BLUE;
	public final static Color ACTIVATED = VistraColor.LIGHT_YELLOW;
	public final static Color VISITED = VistraColor.RED;
	public final static Color SOLUTION = VistraColor.LIGHT_GREEN;

	public final static float LINE_WIDTH_DEFAULT = 1.5f;
	public final static float V_TAGGED_STROKE = 3.0f;
	public final static float E_TAGGED_STROKE = 5.0f;
}
