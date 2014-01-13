package vistra.framework.graph.ml;

import vistra.framework.graph.item.IEdgeLayout;
import vistra.framework.graph.item.IVertexLayout;
import vistra.framework.graph.ml.transformer.EdgeId;
import vistra.framework.graph.ml.transformer.EdgeWeight;
import vistra.framework.graph.ml.transformer.VertexCoordX;
import vistra.framework.graph.ml.transformer.VertexCoordY;
import vistra.framework.graph.ml.transformer.VertexEnd;
import vistra.framework.graph.ml.transformer.VertexID;
import vistra.framework.graph.ml.transformer.VertexStart;
import vistra.framework.graph.ml.transformer.VertexValue;
import edu.uci.ics.jung.io.GraphMLWriter;

/**
 * A GraphMLWriter for writing an extended graph to a GraphML file.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class GraphWriter extends
		GraphMLWriter<IVertexLayout, IEdgeLayout> {

	// geometry: x, y
	public final static String V_LOC_X = "coord.x";
	public final static String V_LOC_Y = "coord.y";
	public final static Double V_LOC_X_DEFAULT = 0d;
	public final static Double V_LOC_Y_DEFAULT = 0d;
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
	// name
	public final static String E_NAME = "name";
	public final static String E_NAME_DEFAULT = "";
	public final static String E_NAME_COMMENT = "Edge name";

	/**
	 * Main constructor.
	 */
	public GraphWriter() {
		// vertex: id
		this.setVertexIDs(new VertexID());
		// vertex: x
		this.addVertexData(GraphWriter.V_LOC_X, GraphWriter.V_LOC_X_COMMENT,
				Double.toString(GraphWriter.V_LOC_X_DEFAULT),
				new VertexCoordX());
		// vertex: y
		this.addVertexData(GraphWriter.V_LOC_Y, V_LOC_Y_COMMENT,
				Double.toString(GraphWriter.V_LOC_Y_DEFAULT),
				new VertexCoordY());
		// vertex: start
		this.addVertexData(GraphWriter.V_START, GraphWriter.V_START_COMMENT,
				Boolean.toString(GraphWriter.V_START_DEFAULT),
				new VertexStart());
		// vertex: end
		this.addVertexData(GraphWriter.V_END, GraphWriter.V_END_COMMENT,
				Boolean.toString(GraphWriter.V_END_DEFAULT), new VertexEnd());
		// vertex: value
		this.addVertexData(GraphWriter.V_VALUE, GraphWriter.V_VALUE_COMMENT,
				GraphWriter.V_VALUE_DEFAULT, new VertexValue());
		// edge: name
		this.addEdgeData(GraphWriter.E_NAME, GraphWriter.E_NAME_COMMENT,
				GraphWriter.E_NAME_DEFAULT, new EdgeId());
		// edge: weight
		this.addEdgeData(GraphWriter.E_WEIGHT, GraphWriter.E_WEIGHT_COMMENT,
				Integer.toString(GraphWriter.E_WEIGHT_DEFAULT),
				new EdgeWeight());
	}

}
