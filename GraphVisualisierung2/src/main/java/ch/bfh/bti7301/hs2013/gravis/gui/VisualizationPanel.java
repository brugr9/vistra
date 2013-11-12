package ch.bfh.bti7301.hs2013.gravis.gui;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.gui.IControl.EventSource;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.VisualizationViewer;

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
	private VisualizationViewer<IVertex, IEdge> viewer;

	/**
	 * 
	 * @param layout
	 */
	public VisualizationPanel(Layout<IVertex, IEdge> layout) {
		super();
		// panel
		this.titledBorder = BorderFactory
				.createTitledBorder("visualizationPanel");
		this.setBorder(titledBorder);
		// viewer
		this.viewer = new VisualizationViewer<IVertex, IEdge>(layout);

		//
		// EditingModalGraphMouse<IVertex, IEdge> graphMouse = new
		// EditingModalGraphMouse<>(
		// this.viewer.getRenderContext(), new VertexFactory(),
		// new EdgeFactory());
		//
		// this.viewer.setGraphMouse(graphMouse);
		// this.viewer.addKeyListener(graphMouse.getModeKeyListener());
		// graphMouse.setMode(ModalGraphMouse.Mode.EDITING);
		//
		// JPanel controls = new JPanel();
		// JComboBox modeBox = graphMouse.getModeComboBox();
		// controls.add(modeBox);
		// this.add(controls, BorderLayout.NORTH);
		//
		// GraphZoomScrollPane pane = new GraphZoomScrollPane(viewer);
		// this.add(pane, BorderLayout.CENTER);
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

		} else {
			this.update(o, arg);
			// this.repaint();
		}

	}
}
