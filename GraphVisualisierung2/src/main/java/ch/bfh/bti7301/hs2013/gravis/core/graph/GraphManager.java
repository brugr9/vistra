package ch.bfh.bti7301.hs2013.gravis.core.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.collections15.Transformer;
import org.apache.commons.io.FileUtils;

import ch.bfh.bti7301.hs2013.gravis.core.AbstractParameterManager;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.EdgeTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.GraphTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.HyperEdgeTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.VertexTransformer;
import edu.uci.ics.jung.graph.Hypergraph;
import edu.uci.ics.jung.io.GraphIOException;
import edu.uci.ics.jung.io.GraphMLWriter;
import edu.uci.ics.jung.io.graphml.GraphMLReader2;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class GraphManager extends AbstractParameterManager implements IGraphManager {

	private final GraphTransformer graphTransformer;
	private final VertexTransformer vertexTransformer;
	private final EdgeTransformer edgeTransformer;
	private final HyperEdgeTransformer hyperEdgeTransformer;

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

		this.graphTransformer = new GraphTransformer();
		this.vertexTransformer = new VertexTransformer();
		this.edgeTransformer = new EdgeTransformer();
		this.hyperEdgeTransformer = new HyperEdgeTransformer();

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
			throw new GraphException(
					"Exception while loading data from GraphML-file "
							+ file.getName() + "!", e);
		}
	}

	/**
	 * @param file
	 */
	private void store(File file, IGravisGraph graph) {
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
			
//			return this
//					.load(new File(
//							"src/main/resources/META-INF/templates/EmptyGraph.graphml"));
			
			return this
					.load(new File(
							"src/main/resources/META-INF/templates/DijkstraSampleGraph1.graphml"));
			
//			 return this
//			 .load(new File(
//			 "src/main/resources/META-INF/templates/SampleTree1.graphml"));
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
	public void clearGraph(int index) throws Exception {
		try {
			File file = super.getFile(index);
			IGravisGraph graph = this.load(file);
			graph.clear();
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

	@Override
	public void saveGraph(IGravisGraph graph) {
		// TODO bitte diesen code nur auskommentieren und nicht löschen
		this.store(
				new File(
						"src/main/resources/META-INF/templates/SampleTree1_out.graphml"),
				graph);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IGraphManager#exportGraph(ch.
	 * bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph)
	 */
	@Override
	public void exportGraph(IGravisGraph graph) throws Exception {
		// TODO bitte diesen code nur auskommentieren und nicht löschen
		this.store(
				new File(
						"src/main/resources/META-INF/templates/SampleTree1_out.graphml"),
				graph);
	}

}
