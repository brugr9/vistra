package vistra.core.graph.ml;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.core.graph.ml.transformer.EdgeWeight;
import vistra.core.graph.ml.transformer.VertexCoordX;
import vistra.core.graph.ml.transformer.VertexCoordY;
import vistra.core.graph.ml.transformer.VertexEnd;
import vistra.core.graph.ml.transformer.VertexStart;
import vistra.core.graph.ml.transformer.VertexValue;
import edu.uci.ics.jung.io.GraphMLWriter;

/**
 * An extended GraphMLWriter for writing an extended graph to a GraphML file.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class ExtendedGraphMLWriter extends
		GraphMLWriter<IVertexLayout, IEdgeLayout> {

	// TODO extract
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
		// vertex: x
		this.addVertexData(ExtendedGraphMLWriter.V_LOC_X,
				ExtendedGraphMLWriter.V_LOC_X_COMMENT,
				Integer.toString(ExtendedGraphMLWriter.V_LOC_X_DEFAULT),
				new VertexCoordX());
		// vertex: y
		this.addVertexData(ExtendedGraphMLWriter.V_LOC_Y, V_LOC_Y_COMMENT,
				Integer.toString(ExtendedGraphMLWriter.V_LOC_Y_DEFAULT),
				new VertexCoordY());
		// vertex: start
		this.addVertexData(ExtendedGraphMLWriter.V_START,
				ExtendedGraphMLWriter.V_START_COMMENT,
				Boolean.toString(ExtendedGraphMLWriter.V_START_DEFAULT),
				new VertexStart());
		// vertex: end
		this.addVertexData(ExtendedGraphMLWriter.V_END,
				ExtendedGraphMLWriter.V_END_COMMENT,
				Boolean.toString(ExtendedGraphMLWriter.V_END_DEFAULT),
				new VertexEnd());
		// vertex: value
		this.addVertexData(ExtendedGraphMLWriter.V_VALUE,
				ExtendedGraphMLWriter.V_VALUE_COMMENT,
				ExtendedGraphMLWriter.V_VALUE_DEFAULT, new VertexValue());
		// edge: weight
		this.addEdgeData(ExtendedGraphMLWriter.E_WEIGHT,
				ExtendedGraphMLWriter.E_WEIGHT_COMMENT,
				Integer.toString(ExtendedGraphMLWriter.E_WEIGHT_DEFAULT),
				new EdgeWeight());
	}

}
