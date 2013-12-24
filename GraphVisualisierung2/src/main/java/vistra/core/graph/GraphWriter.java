package vistra.core.graph;

import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import vistra.core.graph.transformer.edge.EdgeWeight;
import vistra.core.graph.transformer.vertex.VertexCoordX;
import vistra.core.graph.transformer.vertex.VertexCoordY;
import vistra.core.graph.transformer.vertex.VertexEnd;
import vistra.core.graph.transformer.vertex.VertexStart;
import vistra.core.graph.transformer.vertex.VertexValue;
import edu.uci.ics.jung.io.GraphMLWriter;

/**
 * An extended GraphMLWriter.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class GraphWriter extends GraphMLWriter<IVertex, IEdge> {

	GraphWriter() {

		this.addVertexData("coord.x", "Vertex x coordinate",
				Integer.toString(GraphMeta.V_LOC_X_DEFAULT),
				new VertexCoordX());
		this.addVertexData("coord.y", "Vertex y coordinate",
				Integer.toString(GraphMeta.V_LOC_Y_DEFAULT),
				new VertexCoordY());
		this.addVertexData("start", "Vertex is start",
				Boolean.toString(GraphMeta.V_START_DEFAULT),
				new VertexStart());
		this.addVertexData("end", "Vertex is end",
				Boolean.toString(GraphMeta.V_END_DEFAULT), new VertexEnd());
		this.addVertexData("value", "Vertex value",
				Double.toString(GraphMeta.V_VALUE_DEFAULT), new VertexValue());
		this.addEdgeData("weight", "Edge weight",
				Double.toString(GraphMeta.E_WEIGHT_DEFAULT), new EdgeWeight());

	}

}
