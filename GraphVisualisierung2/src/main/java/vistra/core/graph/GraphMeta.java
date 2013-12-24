package vistra.core.graph;

/**
 * Metadata properties for GraphML elements.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 */
public interface GraphMeta {

	// geometry
	public final static String V_LOC_X = "coord.x";
	public final static String V_LOC_Y = "coord.y";
	public final static int V_LOC_X_DEFAULT = 0;
	public final static int V_LOC_Y_DEFAULT = 0;
	// quality
	public final static String V_START = "start";
	public final static String V_END = "end";
	public final static boolean V_START_DEFAULT = false;
	public final static boolean V_END_DEFAULT = false;
	// value
	public final static String V_VALUE = "value";
	public final static String E_WEIGHT = "weight";
	public final static double V_VALUE_DEFAULT = 0.0;
	public final static double E_WEIGHT_DEFAULT = 1.0;

}
