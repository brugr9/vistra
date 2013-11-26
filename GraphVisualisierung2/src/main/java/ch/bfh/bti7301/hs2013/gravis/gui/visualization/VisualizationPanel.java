package ch.bfh.bti7301.hs2013.gravis.gui.visualization;

import java.awt.BorderLayout;
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.TitledBorder;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.EdgeFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.VertexFactory;
import ch.bfh.bti7301.hs2013.gravis.gui.Model;
import ch.bfh.bti7301.hs2013.gravis.gui.IControl.EventSource;
import ch.bfh.bti7301.hs2013.gravis.gui.visualization.popup.VertexMenu;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.CrossoverScalingControl;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.EditingGraphMousePlugin;
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode;
import edu.uci.ics.jung.visualization.control.PluggableGraphMouse;
import edu.uci.ics.jung.visualization.control.ScalingGraphMousePlugin;

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
	private GravisVisualizationViewer viewer;

	/**
	 * 
	 * @param layout
	 */
	public VisualizationPanel(GravisVisualizationViewer visualizationViewer) {
		super();

		// panel
		this.titledBorder = BorderFactory
				.createTitledBorder("Visualization Panel");
		this.setBorder(this.titledBorder);
		// viewer
		this.viewer = visualizationViewer;

		JPanel controls = new JPanel();

		
		EditingModalGraphMouse<IVertex, IEdge> graphMouse = new GravisModalGraphMouse(
				this.viewer.getRenderContext(), new VertexFactory(),
				new EdgeFactory(), new VertexMenu(this.viewer), new VertexMenu(this.viewer));
		JComboBox<Mode> modeBox = graphMouse.getModeComboBox();

		graphMouse.setMode(Mode.PICKING);
		this.viewer.setGraphMouse(graphMouse);
		this.viewer.addKeyListener(graphMouse.getModeKeyListener());

		controls.add(modeBox);
		
		this.add(controls, BorderLayout.NORTH);

		GraphZoomScrollPane pane = new GraphZoomScrollPane(viewer);
		this.add(pane, BorderLayout.CENTER);

//		JPopupMenu edgeMenu = new MyMouseMenus.EdgeMenu(frame);
//		JPopupMenu vertexMenu = new MyMouseMenus.VertexMenu();
//		myPlugin.setEdgePopup(edgeMenu);
//		myPlugin.setVertexPopup(vertexMenu);
//		gm.remove(gm.getPopupEditingPlugin()); // Removes the existing popup
//		gm.add(myPlugin); // Add our new plugin to the mouse

		// Point2D p = visualizationViewer.getRenderContext()
		// .getMultiLayerTransformer().inverseTransform(new Point2D(2,2));
		// System.out.println(p);

		// modeBox.setEnabled(false);
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
	}
}
