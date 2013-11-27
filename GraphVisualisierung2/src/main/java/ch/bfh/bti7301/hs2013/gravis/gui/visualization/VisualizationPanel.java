package ch.bfh.bti7301.hs2013.gravis.gui.visualization;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import ch.bfh.bti7301.hs2013.gravis.core.graph.GraphFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.EdgeFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.VertexFactory;
import ch.bfh.bti7301.hs2013.gravis.gui.Model;
import ch.bfh.bti7301.hs2013.gravis.gui.IControl.EventSource;
import ch.bfh.bti7301.hs2013.gravis.gui.visualization.dialog.GraphPropertyDialog;
import ch.bfh.bti7301.hs2013.gravis.gui.visualization.popup.EdgeMenu;
import ch.bfh.bti7301.hs2013.gravis.gui.visualization.popup.CreateVertexMenu;
import ch.bfh.bti7301.hs2013.gravis.gui.visualization.popup.VertexMenu;
import ch.bfh.bti7301.hs2013.gravis.old.OldIGravisMainListener;
import ch.bfh.bti7301.hs2013.gravis.old.OldMainWindowListener;
import edu.uci.ics.jung.algorithms.layout.AbstractLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.CrossoverScalingControl;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.EditingGraphMousePlugin;
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode;
import edu.uci.ics.jung.visualization.control.PluggableGraphMouse;
import edu.uci.ics.jung.visualization.control.ScalingGraphMousePlugin;
import edu.uci.ics.jung.visualization.layout.ObservableCachingLayout;

/**
 * A visualization panel.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VisualizationPanel extends JPanel implements Observer {

	private static final long serialVersionUID = 177109739873034494L;

	private String shortCuts = "<html>"
			+ "<h3>All Modes:</h3>"
			+ "<ul>"
			+ "<li>Right-click an empty area for <b>Create Vertex</b> popup"
			+ "<li>Right-click on a Vertex for <b>Set Start Vertex, Set End Vertex, Edit Vertex, Delete Vertex</b> popup"
			+ "<li>Right-click on an Edge for <b>Edit Edge, Delete Edge</b> popup"
			+ "<li>Mousewheel scales with a crossover value of 1.0.<p>"
			+ "     - scales the graph layout when the combined scale is greater than 1<p>"
			+ "     - scales the graph view when the combined scale is less than 1"
			+

			"</ul>"
			+ "<h3>Editing Mode:</h3>"
			+ "<ul>"
			+ "<li>Left-click an empty area to create a new Vertex"
			+ "<li>Left-click on a Vertex and drag to another Vertex to create an undirected or directed edge"
			+ "</ul>"
			+ "<h3>Picking Mode:</h3>"
			+ "<ul>"
			+ "<li>Mouse1 on a Vertex selects the vertex"
			+ "<li>Mouse1 elsewhere unselects all Vertices"
			+ "<li>Mouse1+Shift on a Vertex adds/removes Vertex selection"
			+ "<li>Mouse1+drag on a Vertex moves all selected Vertices"
			+ "<li>Mouse1+drag elsewhere selects Vertices in a region"
			+ "<li>Mouse1+Shift+drag adds selection of Vertices in a new region"
			+ "<li>Mouse1+CTRL on a Vertex selects the vertex and centers the display on it"
			+ "</ul>"
			+ "<h3>Transforming Mode:</h3>"
			+ "<ul>"
			+ "<li>Mouse1+drag pans the graph"
			+ "<li>Mouse1+Shift+drag rotates the graph"
			+ "<li>Mouse1+CTRL(or Command)+drag shears the graph"
			+ "<li>Mouse1 double-click on a vertex or edge allows you to edit the label"
			+ "</ul>" + "</html>";
	
	
	/**
	 * A field for a titled border.
	 */
	private TitledBorder titledBorder;

	/**
	 * A field for a visualization viewer.
	 */
	private GravisVisualizationViewer viewer;

	private VertexMenu vertexMenu;
	
	private CreateVertexMenu vertexCreateMenu;

	private EdgeMenu edgeMenu;

	private JButton editGraphBtn;

	/**
	 * @param visualizationViewer
	 */
	public VisualizationPanel(GravisVisualizationViewer visualizationViewer) {
		this(visualizationViewer, null);
	}
	
	/**
	 * 
	 * @param layout
	 */
	public VisualizationPanel(GravisVisualizationViewer viewer, 
			OldMainWindowListener mainWindowListener) {
		super();

		// viewer
		this.viewer = viewer;
		this.setBorder();

		this.vertexMenu = new VertexMenu(this.viewer);
		this.vertexCreateMenu = new CreateVertexMenu(this.viewer);
		this.edgeMenu = new EdgeMenu(this.viewer);

		JPanel controls = new JPanel();
		this.editGraphBtn = new JButton("Graphen bearbeiten...");
		JButton dirGraphBtn = new JButton("Neuer gerichteter Graph");
		JButton undirGraphBtn = new JButton("Neuer ungerichteter Graph");
		JButton shortcutBtn = new JButton("Shortcut Liste");

		EditingModalGraphMouse<IVertex, IEdge> graphMouse = new GravisModalGraphMouse(
				this.viewer.getRenderContext(), new VertexFactory(),
				new EdgeFactory(), this.edgeMenu, this.vertexMenu, this.vertexCreateMenu);
		JComboBox<?> modeBox = graphMouse.getModeComboBox();

		graphMouse.setMode(Mode.PICKING);
		this.viewer.setGraphMouse(graphMouse);
		this.viewer.addKeyListener(graphMouse.getModeKeyListener());

		controls.add(this.editGraphBtn);
		controls.add(dirGraphBtn);
		controls.add(undirGraphBtn);
		controls.add(shortcutBtn);
		controls.add(modeBox);

		this.add(controls, BorderLayout.NORTH);

		GraphZoomScrollPane pane = new GraphZoomScrollPane(viewer);
		this.add(pane, BorderLayout.CENTER);

		dirGraphBtn.setActionCommand(OldIGravisMainListener.EventSource.
				NEW_DIR_GRAPH.toString());
		dirGraphBtn.addActionListener(mainWindowListener);
		
		undirGraphBtn.setActionCommand(OldIGravisMainListener.EventSource.
				NEW_UNDIR_GRAPH.toString());
		undirGraphBtn.addActionListener(mainWindowListener);
		
		shortcutBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(VisualizationPanel.this, 
						VisualizationPanel.this.shortCuts);
			}
		});
		
		// JPopupMenu edgeMenu = new MyMouseMenus.EdgeMenu(frame);
		// JPopupMenu vertexMenu = new MyMouseMenus.VertexMenu();
		// myPlugin.setEdgePopup(edgeMenu);
		// myPlugin.setVertexPopup(vertexMenu);
		// gm.remove(gm.getPopupEditingPlugin()); // Removes the existing popup
		// gm.add(myPlugin); // Add our new plugin to the mouse

		// Point2D p = visualizationViewer.getRenderContext()
		// .getMultiLayerTransformer().inverseTransform(new Point2D(2,2));
		// System.out.println(p);

		// modeBox.setEnabled(false);
	}

	private void setBorder() {
		if (this.viewer.getGraphLayout().getGraph() instanceof IGravisGraph) {
			IGravisGraph graph = (IGravisGraph) this.viewer.getGraphLayout()
					.getGraph();

			// panel
			this.titledBorder = BorderFactory
					.createTitledBorder("Visualization Panel"
							+ (graph == null ? "" : ": " + graph.getId()));
			this.setBorder(this.titledBorder);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof Model) {

			Model m = (Model) o;
			ResourceBundle b = m.getResourceBundle();
			try {
				if (arg == EventSource.I18N)
					b.getString("visualization.label");

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.toString(),
						b.getString("app.label"), 1, null);
				e.printStackTrace();
			}

		}

		this.viewer.update(o, arg);
		this.setBorder();
	}

	/**
	 * @param mainWindow
	 */
	public void setRootFrame(final JFrame rootFrame) {
		this.vertexMenu.setRootFrame(rootFrame);
		this.edgeMenu.setRootFrame(rootFrame);

		this.editGraphBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (VisualizationPanel.this.viewer.getGraphLayout().getGraph() instanceof IGravisGraph) {
					IGravisGraph graph = (IGravisGraph) VisualizationPanel.this.viewer
							.getGraphLayout().getGraph();

					new GraphPropertyDialog(graph, rootFrame).setVisible(true);
					VisualizationPanel.this.setBorder();
				}
			}
		});
	}

}
