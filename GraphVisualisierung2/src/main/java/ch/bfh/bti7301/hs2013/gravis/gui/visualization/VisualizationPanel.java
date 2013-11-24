package ch.bfh.bti7301.hs2013.gravis.gui.visualization;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.EdgeFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.VertexFactory;
import ch.bfh.bti7301.hs2013.gravis.gui.Model;
import ch.bfh.bti7301.hs2013.gravis.gui.IControl.EventSource;
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

		JButton dirGraphBtn = new JButton("Neuer gerichteter Graph");
		JButton undirGraphBtn = new JButton("Neuer ungerichteter Graph");
		
		EditingModalGraphMouse<IVertex, IEdge> graphMouse = new EditingModalGraphMouse<>(
				this.viewer.getRenderContext(), new VertexFactory(),
				new EdgeFactory());
//		DefaultModalGraphMouse<IVertex, IEdge> graphMouse = new DefaultModalGraphMouse<>();
		
//		PluggableGraphMouse graphMouse = new PluggableGraphMouse();
//		graphMouse.add(new EditingGraphMousePlugin<IVertex, IEdge>(new VertexFactory(),
//				new EdgeFactory()));
//		graphMouse.add(new GravisEditingPopupGraphMousePlugin<IVertex, IEdge>(new VertexFactory(),
//				new EdgeFactory()));
//		graphMouse.add(new ScalingGraphMousePlugin(new CrossoverScalingControl(), 0, 1.1f, 0.9f));

		JPanel controls = new JPanel();
		JComboBox modeBox = graphMouse.getModeComboBox();
		modeBox.removeAllItems();
		modeBox.addItem(Mode.PICKING);
		modeBox.addItem(Mode.EDITING);
		modeBox.addItem(Mode.TRANSFORMING);
		modeBox.addItemListener(graphMouse.getModeListener());
		controls.add(dirGraphBtn);
		controls.add(undirGraphBtn);
		controls.add(modeBox);
		this.add(controls, BorderLayout.NORTH);

//		graphMouse.remove(graphMouse.getPopupEditingPlugin());
		graphMouse.setMode(Mode.EDITING);
		
		this.viewer.setGraphMouse(graphMouse);
		this.viewer.addKeyListener(graphMouse.getModeKeyListener());
		
		GraphZoomScrollPane pane = new GraphZoomScrollPane(viewer);
		this.add(pane, BorderLayout.CENTER);
		
		
//		modeBox.setEnabled(false);
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
