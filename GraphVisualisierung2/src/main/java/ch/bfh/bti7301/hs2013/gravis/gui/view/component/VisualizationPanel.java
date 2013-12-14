package ch.bfh.bti7301.hs2013.gravis.gui.view.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.EdgeFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.VertexFactory;
import ch.bfh.bti7301.hs2013.gravis.gui.IModel;
import ch.bfh.bti7301.hs2013.gravis.gui.control.IControl.EventSource;
import ch.bfh.bti7301.hs2013.gravis.gui.view.IView;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.GravisModalGraphMouse;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.GravisVisualizationViewer;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.dialog.GraphPropertyDialog;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.popup.EdgeMenu;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.popup.VertexMenu;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.popup.VertexMenuFactory;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode;

/**
 * A visualization panel.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VisualizationPanel extends JPanel implements Observer {

	private static final long serialVersionUID = 177109739873034494L;

	/**
	 * A field for a titled border.
	 */
	private TitledBorder titledBorder;
	/**
	 * A field for a visualization viewer.
	 */
	private GravisVisualizationViewer visualizationViewer;
	/**
	 * A field for a graph zoom scroll pane.
	 */
	private GraphZoomScrollPane graphZoomScrollPane;
	/**
	 * A field for an editing modal graph mouse.
	 */
	private EditingModalGraphMouse<IVertex, IEdge> mouse;
	/**
	 * A field for a controls panel.
	 */
	private JPanel controls;
	/**
	 * A field for a vertex-menu factory.
	 */
	private VertexMenuFactory vertexMenuFactory;
	/**
	 * A field for a vertex menu.
	 */
	private VertexMenu vertexMenu;
	/**
	 * A field for an edge menu.
	 */
	private EdgeMenu edgeMenu;
	/**
	 * A field for an edit graph button.
	 */
	private JButton editGraphButton;
	/**
	 * A field for an edit graph button.
	 */
	private JButton newGraphUndirectedButton;
	/**
	 * A field for an edit graph button.
	 */
	private JButton newGraphDirectedButton;
	/**
	 * A field for an edit graph button.
	 */
	private JButton shortcutsButton;
	/**
	 * A field for an edit mode combo box.
	 */
	private JComboBox<?> editModeComboBox;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            a gravis model
	 * @param layout
	 *            the JUNG layout
	 * @param dimension
	 *            the dimension
	 */
	public VisualizationPanel(IModel model, Layout<IVertex, IEdge> layout,
			Dimension dimension) {
		this.setSize(dimension);
		this.titledBorder = BorderFactory
				.createTitledBorder("visualizationPanel");
		this.setBorder(titledBorder);

		/* visualization viewer */
		int width = dimension.width - IView.BORDER;
		// TODO height
		int height = dimension.height - 30;
		Dimension visualizerDimension = new Dimension(width, height);
		this.visualizationViewer = new GravisVisualizationViewer(layout,
				visualizerDimension);
		this.graphZoomScrollPane = new GraphZoomScrollPane(
				this.visualizationViewer);
		this.mouse = new GravisModalGraphMouse(
				this.visualizationViewer.getRenderContext(),
				new VertexFactory(), new EdgeFactory(), this.edgeMenu,
				this.vertexMenu, this.vertexMenuFactory);
		// TODO this.mouse.setMode(m.getMouseMode());
		this.mouse.setMode(Mode.PICKING);
		this.visualizationViewer.setGraphMouse(this.mouse);
		this.visualizationViewer
				.addKeyListener(this.mouse.getModeKeyListener());

		/* controls */
		this.editGraphButton = new JButton("editGraphButton");
		this.vertexMenu = new VertexMenu(this.visualizationViewer);
		this.vertexMenuFactory = new VertexMenuFactory(this.visualizationViewer);
		this.edgeMenu = new EdgeMenu(this.visualizationViewer);
		this.newGraphUndirectedButton = new JButton("newGraphUndirectedButton");
		this.newGraphDirectedButton = new JButton("newGraphDirectedButton");
		this.shortcutsButton = new JButton("shortcutsButton");
		this.editModeComboBox = this.mouse.getModeComboBox();
		// action command
		this.newGraphUndirectedButton
				.setActionCommand(EventSource.NEW_GRAPH_UNDIRECTED.toString());
		this.newGraphDirectedButton
				.setActionCommand(EventSource.NEW_GRAPH_DIRECTED.toString());
		// listener
		this.newGraphDirectedButton.addActionListener(model
				.getParameterStateHandler());
		this.newGraphUndirectedButton.addActionListener(model
				.getParameterStateHandler());
		this.shortcutsButton.addActionListener(model.getHelpListener());
		// panel
		this.controls = new JPanel();
		this.controls.add(this.editGraphButton);
		this.controls.add(this.newGraphDirectedButton);
		this.controls.add(this.newGraphUndirectedButton);
		this.controls.add(this.shortcutsButton);
		this.controls.add(this.editModeComboBox);

		/* this */
		this.add(this.controls, BorderLayout.NORTH);
		this.add(this.graphZoomScrollPane, BorderLayout.CENTER);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	/**
	 * Updates the panel.
	 */
	@Override
	public void update(Observable o, Object arg) {

		IModel m = (IModel) o;
		ResourceBundle b = m.getResourceBundle();

		try {

			if (arg == EventSource.I18N || arg == EventSource.PARAMETER_CHANGED) {
				String title = b.getString("visualization.label") + ": "
						+ ((IGravisGraph) m.getGraph()).getId();
				if (!m.isGraphSaved())
					title += " *";
				this.titledBorder.setTitle(title);
			}

			this.visualizationViewer.update(o, arg);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					b.getString("app.label"), 1, null);
			e.printStackTrace();
		}

	}

	/**
	 * TODO
	 * 
	 * @param rootFrame
	 */
	public void setRootFrame(final JFrame rootFrame) {
		this.vertexMenu.setRootFrame(rootFrame);
		this.edgeMenu.setRootFrame(rootFrame);

		this.editGraphButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				IGravisGraph graph = (IGravisGraph) VisualizationPanel.this.visualizationViewer
						.getGraphLayout().getGraph();

				new GraphPropertyDialog(graph, rootFrame).setVisible(true);

			}
		});
	}

}
