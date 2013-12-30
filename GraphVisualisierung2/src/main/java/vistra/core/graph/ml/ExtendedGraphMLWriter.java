package vistra.core.graph.ml;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.core.graph.item.transformer.EdgeWeight;
import vistra.core.graph.item.transformer.VertexCoordX;
import vistra.core.graph.item.transformer.VertexCoordY;
import vistra.core.graph.item.transformer.VertexEnd;
import vistra.core.graph.item.transformer.VertexStart;
import vistra.core.graph.item.transformer.VertexValue;
import edu.uci.ics.jung.io.GraphMLWriter;

/**
 * An extended GraphMLWriter for writing an extended graph to a GraphML file.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class ExtendedGraphMLWriter extends
		GraphMLWriter<IVertexLayout, IEdgeLayout> {

	// geometry: x, y
	public final static String V_LOC_X = "coord.x";
	public final static String V_LOC_Y = "coord.y";
	public final static int V_LOC_X_DEFAULT = 0;
	public final static int V_LOC_Y_DEFAULT = 0;
	public final static String V_LOC_X_COMMENT = "Vertex x coordinate";
	public final static String V_LOC_Y_COMMENT = "Vertex y coordinate";
	// quality: start, end
	public final static String V_START = "start";
	public final static String V_END = "end";
	public final static boolean V_START_DEFAULT = false;
	public final static boolean V_END_DEFAULT = false;
	public final static String V_START_COMMENT = "Vertex is start";
	public final static String V_END_COMMENT = "Vertex is end";
	// value, weight resp.
	public final static String V_VALUE = "value";
	public final static String E_WEIGHT = "weight";
	public final static String V_VALUE_DEFAULT = "";
	public final static int E_WEIGHT_DEFAULT = 1;
	public final static String V_VALUE_COMMENT = "Vertex value";
	public final static String E_WEIGHT_COMMENT = "Edge weight";

	/**
	 * Main constructor.
	 */
	public ExtendedGraphMLWriter() {
		this.addVertexData(V_LOC_X, V_LOC_X_COMMENT,
				Integer.toString(V_LOC_X_DEFAULT), new VertexCoordX());
		this.addVertexData(V_LOC_Y, V_LOC_Y_COMMENT,
				Integer.toString(V_LOC_Y_DEFAULT), new VertexCoordY());
		this.addVertexData(V_START, V_START_COMMENT,
				Boolean.toString(V_START_DEFAULT), new VertexStart());
		this.addVertexData(V_END, V_END_COMMENT,
				Boolean.toString(V_END_DEFAULT), new VertexEnd());
		this.addVertexData(V_VALUE, V_VALUE_COMMENT, V_VALUE_DEFAULT,
				new VertexValue());
		this.addEdgeData(E_WEIGHT, E_WEIGHT_COMMENT,
				Integer.toString(E_WEIGHT_DEFAULT), new EdgeWeight());
	}

}
