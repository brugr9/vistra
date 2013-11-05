package ch.bfh.bti7301.hs2013.gravis.core.graph;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.collections15.BidiMap;
import org.apache.commons.io.FileUtils;
import org.xml.sax.SAXException;

import ch.bfh.bti7301.hs2013.gravis.common.IEdge;
import ch.bfh.bti7301.hs2013.gravis.common.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.AbstractParameterManager;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.EdgeFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.VertexFactory;
import ch.bfh.bti7301.hs2013.gravis.core.util.ValueTransformer;
import ch.bfh.bti7301.hs2013.gravis.old.OldApplicationFactory;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.io.GraphMLMetadata;
import edu.uci.ics.jung.io.GraphMLReader;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
class GraphManager extends AbstractParameterManager implements IGraphManager {

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
		try {
			// TODO read from templatesDir as well as from workbenchDir and add
			// TODO validation?
			super.putAll(templatesDir.listFiles());
			super.putAll(workbenchDir.listFiles());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param file
	 * @return IGravisGraph
	 */
	private IGravisGraph loadGraph(final File file) throws Exception {

		// TODO bitte an dieser Methode nichts ändern (pk)

		// TODO validate file against xsd of graphml
		// TODO read GraphName from graphml
		// TODO read GraphType from graphml: <graph id="Sample Graph 1"
		// edgedefault="directed">

		try {
			IGravisGraph newGraph = null;
			newGraph = this.loadGraph(file,
					new GraphMLReader<Graph<IVertex, IEdge>, IVertex, IEdge>(
							new VertexFactory(), new EdgeFactory()));
			return newGraph;
		} catch (SAXException e) {
			throw e;
		} catch (ParserConfigurationException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}

	}

	/**
	 * @param filename
	 * @param graphMLReader
	 * @return IGravisGraph
	 * @throws IOException
	 * @throws Exception
	 */
	private IGravisGraph loadGraph(
			final File file,
			final GraphMLReader<Graph<IVertex, IEdge>, IVertex, IEdge> graphReader)
			throws IOException, Exception {

		// TODO bitte an dieser Methode nichts ändern (pk)

		// TODO File as method parameter

		try {
			IGravisGraph newGraph = GraphFactory.createIGravisGraph();
			// TODO from which directory does graphReader get the file?
			graphReader.load(file.getAbsolutePath(), newGraph);

			BidiMap<IVertex, String> vertexIds = graphReader.getVertexIDs();
			BidiMap<IEdge, String> edgeIds = graphReader.getEdgeIDs();
			Map<String, GraphMLMetadata<IVertex>> vertexMeta = graphReader
					.getVertexMetadata();
			Map<String, GraphMLMetadata<IEdge>> edgeMeta = graphReader
					.getEdgeMetadata();

			for (IVertex vertex : newGraph.getVertices()) {
				vertex.setId(vertexIds.get(vertex));
				// TODO read attribute Ids from file: a0, a3
				vertex.setColor(ValueTransformer.transformColor(vertexMeta
						.get("a0").transformer.transform(vertex)));
				vertex.setStart(ValueTransformer.transformBoolean(vertexMeta
						.get("a3").transformer.transform(vertex)));
			}

			for (IEdge edge : newGraph.getEdges()) {
				edge.setId(edgeIds.get(edge));
				// TODO read attribute Ids from file: a1, a2
				// edge.setColor(ValueTransformer.transformColor(edgeMeta
				// .get("a1").transformer.transform(edge)));
				edge.setWeight(ValueTransformer.transformWeight(edgeMeta
						.get("a2").transformer.transform(edge)));
			}

			return newGraph;

		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * @param file
	 */
	private void storeGraph(File file) {
		// TODO bitte an dieser Methode nichts ändern (pk)

		// TODO write GraphName from graphml
		// TODO write GraphType from graphml: <graph id="Sample Graph 1"
		// edgedefault="directed">
		// TODO to implement
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ch.bfh.bti7301.hs2013.gravis.core.graph.IGraphManager#getGraph(int)
	 */
	@Override
	public IGravisGraph getGraph(String graphId) throws Exception {
		try {
			File file = super.getFile(graphId);

			// return this.loadGraph(file);
			// TODO bitte dummy value auskommentieren und nicht löschen
			return this.loadGraph(new File(
					OldApplicationFactory.IMPORTED_GRAPHS_PATH
							+ "SampleTree1.graphml"));
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
	public IGravisGraph importGraph(File file) throws Exception {
		try {
			if (file.isFile()) {
				FileUtils.copyFileToDirectory(file, this.getWorkbenchDir());
				File theCopy = new File(this.getWorkbenchDir() + file.getName());
				IGravisGraph graph = this.loadGraph(theCopy);
				super.add(graph.getGraphId(), theCopy);
				return graph;
			} else
				throw new IOException(this.getClass().toString()
						+ ": file is not a file.");
		} catch (IOException e) {
			throw e;
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
	public IGravisGraph clearGraph(String graphId) throws Exception {
		try {
			IGravisGraph graph = this.loadGraph(super.getFile(graphId));
			graph.clear();
			return graph;

			// File file = super.getFile(index);
			// if (super.delete(file)) {
			// // TODO update graph-lists
			// // TODO load graph and clear
			// return GraphFactory.createIGravisGraph();
			// } else
			// return null;
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ch.bfh.bti7301.hs2013.gravis.core.graph.IGraphManager#deleteGraph(int)
	 */
	@Override
	public void deleteGraph(String graphId) throws Exception {
		try {
			File file = super.getFile(graphId);
			super.delete(file);
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
	public void deleteGraph(File file) throws Exception {
		try {
			super.delete(file);
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public boolean exportGraph(String graphId, File destinationDir)
			throws Exception {
		try {
			FileUtils.copyFileToDirectory(super.getFile(graphId),
					destinationDir);
			return true;
		} catch (IOException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean saveGraph(IGravisGraph graph) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
