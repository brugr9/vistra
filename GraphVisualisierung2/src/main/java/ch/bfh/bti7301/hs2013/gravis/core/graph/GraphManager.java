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
import ch.bfh.bti7301.hs2013.gravis.core.util.GravisConstants;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.EdgeColorStringTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.EdgeIDTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.EdgeTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.EdgeWeightTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.EndVertexTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.GraphDescriptionTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.GraphTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.HyperEdgeTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.StartVertexTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.VertexColorStringTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.VertexHeightTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.VertexIDTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.VertexLocationXTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.VertexLocationYTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.VertexTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.transformer.VertexWidthTransformer;
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
			throw new GraphException("I/O Exception in GraphML-file "
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
	 * @throws GraphException 
	 */
	private void store(File file, IGravisGraph graph) throws GraphException {
		GravisGraphMLWriter graphWriter = new GravisGraphMLWriter();
		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter(file);
			
			graphWriter.setVertexIDs(new VertexIDTransformer());
			graphWriter.setEdgeIDs(new EdgeIDTransformer());
			
			graphWriter.addGraphData(GravisConstants.G_DESCRIPTION, "", "", 
					new GraphDescriptionTransformer());
			
			graphWriter.addEdgeData(GravisConstants.E_COLOR, "", GravisConstants.BLACK, 
					new EdgeColorStringTransformer());
			graphWriter.addEdgeData(GravisConstants.E_WEIGHT, "", 
					String.valueOf(GravisConstants.E_WEIGHT_DEFAULT), 
					new EdgeWeightTransformer());
			
			graphWriter.addVertexData(GravisConstants.V_COLOR, "", 
					GravisConstants.RED, new VertexColorStringTransformer());
			graphWriter.addVertexData(GravisConstants.V_START, "", 
					String.valueOf(GravisConstants.V_START_DEFAULT), 
					new StartVertexTransformer());
			graphWriter.addVertexData(GravisConstants.V_END, "", 
					String.valueOf(GravisConstants.V_END_DEFAULT), 
					new EndVertexTransformer());
			graphWriter.addVertexData(GravisConstants.V_LOC_X, "", 
					String.valueOf(GravisConstants.V_LOC_X_DEFAULT), 
					new VertexLocationXTransformer());
			graphWriter.addVertexData(GravisConstants.V_LOC_Y, "", 
					String.valueOf(GravisConstants.V_LOC_Y_DEFAULT), 
					new VertexLocationYTransformer());
			graphWriter.addVertexData(GravisConstants.V_WIDTH, "", 
					String.valueOf(GravisConstants.V_WIDTH_DEFAULT), 
					new VertexWidthTransformer());
			graphWriter.addVertexData(GravisConstants.V_HEIGHT, "", 
					String.valueOf(GravisConstants.V_HEIGHT_DEFAULT), 
					new VertexHeightTransformer());
			
			graphWriter.save(graph, writer);

			writer.close();
		} catch (FileNotFoundException e) {
			throw new GraphException("Exception while creating GraphML-file "
					+ file.getName() + "!", e);
		} catch (IOException e) {
			throw new GraphException("I/O Exception while saving GraphML-file "
					+ file.getName() + "!", e);
		} catch (Exception e) {
			throw new GraphException(
					"Exception while storing data to GraphML-file "
							+ file.getName() + "!", e);
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

			// return this
			// .load(new File(
			// "src/main/resources/META-INF/templates/EmptyGraph.graphml"));

//			return this
//					.load(new File(
//							"src/main/resources/META-INF/templates/DijkstraSampleGraph1.graphml"));
//			return this
//					.load(new File(
//							"src/main/resources/META-INF/templates/SaveGraph.graphml"));

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
	public void saveGraph(IGravisGraph graph) throws GraphException {
		// TODO bitte diesen code nur auskommentieren und nicht löschen
		
		// TODO update ParameterManager
		this.store(new File(
				"src/main/resources/META-INF/templates/SaveGraph.graphml"),
				graph);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IGraphManager#exportGraph(ch.
	 * bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph, java.io.File)
	 */
	@Override
	public void exportGraph(IGravisGraph graph, File file) throws GraphException {
		this.store(file, graph);
	}

}
