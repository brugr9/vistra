package ch.bfh.bti7301.hs2013.gravis.core.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.collections15.BidiMap;
import org.apache.commons.collections15.Transformer;
import org.apache.commons.io.FileUtils;
import org.xml.sax.SAXException;

import ch.bfh.bti7301.hs2013.gravis.core.AbstractParameterManager;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.EdgeFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.VertexFactory;
import ch.bfh.bti7301.hs2013.gravis.core.util.ValueTransformer;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.Hypergraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.io.GraphMLMetadata;
import edu.uci.ics.jung.io.GraphMLReader;
import edu.uci.ics.jung.io.GraphMLWriter;
import edu.uci.ics.jung.io.graphml.GraphMLReader2;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class GraphManager extends AbstractParameterManager implements IGraphManager {

	// TODO read from properties
	private final static String GRAPH_ID = "id";
	
	/**
	 * Main constructor
	 * 
	 * @param templatesDir
	 *            the templates directory
	 * @param workbenchDir
	 *            the workbench directory
	 * @param filter
	 *            the filename extension filter
	 */
	public GraphManager(File templatesDir, File workbenchDir,
			FileNameExtensionFilter filter) {
		super(templatesDir, workbenchDir, filter);
		// try {
		// // TODO validation?
		// for (File file : templatesDir.listFiles()) {
		// super.add(file);
		// }
		// for (File file : workbenchDir.listFiles()) {
		// super.add(file);
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// }

	}

	/**
	 * @param file
	 * @return IGravisGraph
	 */
	private IGravisGraph load(final File file) throws GraphException {
		try {
//			GraphMLReader2<Graph<IVertex, IEdge>, IVertex, IEdge> graphReader = 
//					new GraphMLReader2<>(new Scanner(file), 
//					graphTransformer, vertexTransformer, edgeTransformer, hyperEdgeTransformer);
			
			
			
			return this.read(file,
					new GraphMLReader<Graph<IVertex, IEdge>, IVertex, IEdge>(
							new VertexFactory(), new EdgeFactory()));
		} catch (SAXException e) {
			throw new GraphException("XML parsing error in file " + file.getName() + "!", e);
		} catch (ParserConfigurationException e) {
			throw new GraphException("XML Parser configuration error in file " + 
					file.getName() + "!", e);
		} catch (IOException e) {
			throw new GraphException("Unable to read from file " + file.getName() + "!", e);
		} catch (Exception e) {
			throw new GraphException("Exception while loading data from file " + 
					file.getName() + "!", e);
		}
	}

	/**
	 * @param filename
	 * @param graphMLReader
	 * @return IGravisGraph
	 * @throws IOException
	 * @throws Exception
	 */
	private IGravisGraph read(
			final File file,
			final GraphMLReader<Graph<IVertex, IEdge>, IVertex, IEdge> graphReader)
			throws IOException {

		IGravisGraph newGraph = GraphFactory.createIGravisGraph();
		graphReader.load(file.getAbsolutePath(), newGraph);

		BidiMap<IVertex, String> vertexIds = graphReader.getVertexIDs();
		BidiMap<IEdge, String> edgeIds = graphReader.getEdgeIDs();
		Map<String, GraphMLMetadata<IVertex>> vertexMeta = graphReader
				.getVertexMetadata();
		Map<String, GraphMLMetadata<IEdge>> edgeMeta = graphReader
				.getEdgeMetadata();
		Map<String, GraphMLMetadata<Graph<IVertex, IEdge>>> graphMeta = graphReader
				.getGraphMetadata();
				
		newGraph.setId(graphMeta.get(GRAPH_ID).transformer.transform(newGraph));
		
		System.out.println(graphMeta.get("edgedefault"));
		
		// TODO read edge type from file
		newGraph.setEdgeType(EdgeType.DIRECTED);
		// TODO read graph description from graphml

		for (IVertex vertex : newGraph.getVertices()) {
			vertex.setId(vertexIds.get(vertex));
			// TODO read attribute Ids from file: vertexColor, startVertex,
			// vertexLocation.x, vertexLocation.y
			// TODO read endVertex from graphml
			vertex.setColor(ValueTransformer.transformColor(vertexMeta
					.get("vertexColor").transformer.transform(vertex)));
			vertex.setStart(ValueTransformer.transformBoolean(vertexMeta
					.get("startVertex").transformer.transform(vertex)));

			vertex.setLocation(ValueTransformer.transformLocation(vertexMeta
					.get("vertexLocation.x").transformer.transform(vertex),
					vertexMeta.get("vertexLocation.y").transformer
							.transform(vertex)));

			vertex.setId(vertexIds.get(vertex));
		}

		for (IEdge edge : newGraph.getEdges()) {
			edge.setId(edgeIds.get(edge));
			// TODO read attribute Ids from file: edgeColor, weight
			// edge.setColor(ValueTransformer.transformColor(edgeMeta
			// .get("edgeColor").transformer.transform(edge)));
			edge.setWeight(ValueTransformer.transformWeight(edgeMeta
					.get("weight").transformer.transform(edge)));
		}

		return newGraph;
	}

	/**
	 * @param file
	 */
	private void write(File file, IGravisGraph graph) {
		// TODO write GraphName from graphml
		// TODO write GraphType from graphml: <graph id="Sample Graph 1"
		// edgedefault="directed">
		// TODO to implement

		GraphMLWriter<IVertex, IEdge> graphWriter = new GraphMLWriter<>();
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Transformer<Hypergraph<IVertex, IEdge>, String> graphTransformer = new Transformer<Hypergraph<IVertex, IEdge>, String>() {
			@Override
			public String transform(Hypergraph<IVertex, IEdge> graph) {
				if (graph instanceof IGravisGraph) {
					return ((IGravisGraph) graph).getId();
				}
				return "";
			}
		};

		graphWriter.addGraphData("id", "", "", graphTransformer);
		try {
			graphWriter.save(graph, writer);

			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGraphManager#getGraph(int)
	 */
	@Override
	public IGravisGraph getGraph(int index) throws Exception {
		try {
			// File file = super.getFile(index);
			// return this.load(file);

			// TODO bitte dummy value auskommentieren und nicht löschen (pk)
			return this
					.load(new File(
							"src/main/resources/META-INF/templates/SampleTree1.graphml"));
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IGraphManager#importGraph(java
	 * .lang.String)
	 */
	@Override
	public boolean addGraph(File file) throws Exception {
		try {
			this.load(file);
			return super.add(file);
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IGraphManager#clearGraph(int)
	 */
	@Override
	public IGravisGraph clearGraph(int index) throws Exception {
		try {
			File file = super.getFile(index);
			IGravisGraph graph = this.load(file);
			graph.clear();
			return graph;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IGraphManager#deleteGraph(java
	 * .io.File)
	 */
	@Override
	public String[] deleteGraph(File file) throws Exception {
		try {
			FileUtils.deleteQuietly(file);
			super.remove(file);
			return super.getNames();
		} catch (Exception e) {
			throw e;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IGraphManager#saveGraph(ch.bfh
	 * .bti7301.hs2013.gravis.core.graph.IGravisGraph)
	 */
	@Override
	public void saveGraph(IGravisGraph graph) {
		// TODO bitte diesen code nur auskommentieren und nicht löschen
		this.write(
				new File(
						"src/main/resources/META-INF/templates/SampleTree1_out.graphml"),
				graph);
	}

}
