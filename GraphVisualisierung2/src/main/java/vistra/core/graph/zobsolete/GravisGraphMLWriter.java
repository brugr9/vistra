package vistra.core.graph.zobsolete;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

import org.apache.commons.collections15.Transformer;

import vistra.core.graph.zobsolete.item.edge.IEdge;
import vistra.core.graph.zobsolete.item.vertex.IVertex;
import edu.uci.ics.jung.graph.Hypergraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.io.GraphMLWriter;

/**
 * An adapted JUNG GraphML writer.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
public class GravisGraphMLWriter extends GraphMLWriter<IVertex, IEdge> {

	/**
	 * Main constructor.
	 */
	public GravisGraphMLWriter() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(Hypergraph<IVertex, IEdge> graph, Writer w)
			throws IOException {

		if (!(graph instanceof IGravisGraph)) {
			return;
		}
		IGravisGraph gravisGraph = (IGravisGraph) graph;

		BufferedWriter bw = new BufferedWriter(w);

		// write out boilerplate header
		bw.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		bw.write("<graphml xmlns=\"http://graphml.graphdrawing.org/xmlns\"\n"
				+ "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"  \n");
		bw.write("xsi:schemaLocation=\"http://graphml.graphdrawing.org/xmlns\n");
		bw.write("http://graphml.graphdrawing.org/xmlns/1.0/graphml.xsd\">\n");

		// write out data specifiers, including defaults
		for (String key : this.graph_data.keySet())
			this.writeKeySpecification(key, "graph", this.graph_data.get(key),
					bw);
		for (String key : this.vertex_data.keySet())
			this.writeKeySpecification(key, "node", this.vertex_data.get(key),
					bw);
		for (String key : this.edge_data.keySet())
			this.writeKeySpecification(key, "edge", this.edge_data.get(key), bw);

		// set edge default direction
		bw.write("<graph id=\"" + gravisGraph.getId() + "\" edgedefault=\"");
		// this.directed = !(gravisGraph instanceof UndirectedGraph);

		this.directed = gravisGraph.getEdgeType() == EdgeType.DIRECTED;
		if (this.directed) {
			bw.write("directed\">\n");
		} else {
			bw.write("undirected\">\n");
		}

		// reads description from key-attribute
		// String desc = this.graph_desc.transform(gravisGraph);
		// if (desc != null)
		// bw.write("<desc>" + desc + "</desc>\n");

		// write graph data out if any
		for (String key : this.graph_data.keySet()) {
			Transformer<Hypergraph<IVertex, IEdge>, ?> t = this.graph_data
					.get(key).transformer;
			Object value = t.transform(gravisGraph);
			if (value != null)
				bw.write(format("data", "key", key, value.toString()) + "\n");
		}

		// write vertex information
		this.writeVertexData(gravisGraph, bw);

		// write edge information
		this.writeEdgeData(gravisGraph, bw);

		// close graph
		bw.write("</graph>\n");
		bw.write("</graphml>\n");
		bw.flush();

		bw.close();
	}

}
