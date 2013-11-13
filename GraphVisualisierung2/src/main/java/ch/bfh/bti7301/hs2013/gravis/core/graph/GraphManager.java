package ch.bfh.bti7301.hs2013.gravis.core.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
import ch.bfh.bti7301.hs2013.gravis.core.util.EdgeTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.GraphTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.HyperEdgeTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.ValueTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.VertexTransformer;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.Hypergraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.io.GraphIOException;
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

	private final GraphTransformer graphTransformer = new GraphTransformer();
	private final VertexTransformer vertexTransformer = new VertexTransformer();
	private final EdgeTransformer edgeTransformer = new EdgeTransformer();
	private final HyperEdgeTransformer hyperEdgeTransformer = new HyperEdgeTransformer();
	
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
				GraphMLReader2<IGravisGraph, IVertex, IEdge> graphReader = new GraphMLReader2<>(
						new FileReader(file), this.graphTransformer,
						this.vertexTransformer, this.edgeTransformer,
						this.hyperEdgeTransformer);
				
				IGravisGraph newGraph = graphReader.readGraph();
				
				graphReader.close();
				
				return newGraph;
			} catch (GraphIOException e) {
				throw new GraphException("I/O error in GraphML-file "
						+ file.getName() + "!", e);
			} catch (FileNotFoundException e) {
				throw new GraphException("GraphML-file not found: "
						+ file.getName() + "!", e);
			} catch (Exception e) {
				throw new GraphException("Exception while loading data from GraphML-file "
						+ file.getName() + "!", e);
			}		
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
