package vistra.framework.graph.ml;

import vistra.framework.graph.item.IEdgeLayout;
import vistra.framework.graph.item.IVertexLayout;
import vistra.framework.graph.ml.transformer.EdgeName;
import vistra.framework.graph.ml.transformer.EdgeWeight;
import vistra.framework.graph.ml.transformer.VertexCoordX;
import vistra.framework.graph.ml.transformer.VertexCoordY;
import vistra.framework.graph.ml.transformer.VertexEnd;
import vistra.framework.graph.ml.transformer.VertexID;
import vistra.framework.graph.ml.transformer.VertexStart;
import vistra.framework.graph.ml.transformer.VertexValue;
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
	// name
	public final static String E_NAME = "name";
	public final static String E_NAME_DEFAULT = "";
	public final static String E_NAME_COMMENT = "Edge name";

	/**
	 * Main constructor.
	 */
	public ExtendedGraphMLWriter() {
		// vertex: id
		this.setVertexIDs(new VertexID());
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
		// edge: name
		this.addEdgeData(ExtendedGraphMLWriter.E_NAME,
				ExtendedGraphMLWriter.E_NAME_COMMENT,
				ExtendedGraphMLWriter.E_NAME_DEFAULT, new EdgeName());
		// edge: weight
		this.addEdgeData(ExtendedGraphMLWriter.E_WEIGHT,
				ExtendedGraphMLWriter.E_WEIGHT_COMMENT,
				Integer.toString(ExtendedGraphMLWriter.E_WEIGHT_DEFAULT),
				new EdgeWeight());

	}

}
