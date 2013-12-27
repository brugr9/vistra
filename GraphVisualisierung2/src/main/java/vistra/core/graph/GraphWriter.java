package vistra.core.graph;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.core.graph.transformer.EdgeWeight;
import vistra.core.graph.transformer.VertexCoordX;
import vistra.core.graph.transformer.VertexCoordY;
import vistra.core.graph.transformer.VertexEnd;
import vistra.core.graph.transformer.VertexStart;
import vistra.core.graph.transformer.VertexValue;
import edu.uci.ics.jung.io.GraphMLWriter;

/**
 * An extended GraphMLWriter.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class GraphWriter extends
		GraphMLWriter<IVertexLayout, IEdgeLayout> {

	GraphWriter() {

		this.addVertexData("coord.x", "Vertex x coordinate",
				Integer.toString(GraphMeta.V_LOC_X_DEFAULT), new VertexCoordX());
		this.addVertexData("coord.y", "Vertex y coordinate",
				Integer.toString(GraphMeta.V_LOC_Y_DEFAULT), new VertexCoordY());
		this.addVertexData("start", "Vertex is start",
				Boolean.toString(GraphMeta.V_START_DEFAULT), new VertexStart());
		this.addVertexData("end", "Vertex is end",
				Boolean.toString(GraphMeta.V_END_DEFAULT), new VertexEnd());
		this.addVertexData("value", "Vertex value",
				Double.toString(GraphMeta.V_VALUE_DEFAULT), new VertexValue());
		this.addEdgeData("weight", "Edge weight",
				Double.toString(GraphMeta.E_WEIGHT_DEFAULT), new EdgeWeight());

	}

}
