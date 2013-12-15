package ch.bfh.bti7301.hs2013.gravis.core.util;

import java.awt.Color;

import ch.bfh.bti7301.hs2013.gravis.util.GravisColor;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
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

	public final static String V_COLOR = "vertexColor";
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
	public final static Color V_START_COLOR = GravisColor.YELLOW;
	public final static Color V_END_COLOR = GravisColor.YELLOW;

	public final static Color V_COLOR_DEFAULT = GravisColor.LIGHT_ORANGE;
	public final static Color E_COLOR_DEFAULT = GravisColor.DARK_BLUE;

	public final static Color V_INITIAL_COLOR = GravisColor.LIGHT_BLUE;
	public final static Color E_INITIAL_COLOR = GravisColor.LIGHT_YELLOW;
	public final static Color ACTIVATION_COLOR = GravisColor.RED;
	public final static Color VISIT_COLOR = GravisColor.RED;
	public final static Color SOLUTION_COLOR = GravisColor.LIGHT_GREEN;

	public final static float STROKE_WIDTH_DEFAULT = 1.5f;
	public final static float V_TAGGED_STROKE = 3.0f;
	public final static float E_TAGGED_STROKE = 5.0f;
}
