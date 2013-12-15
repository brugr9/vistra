package ch.bfh.bti7301.hs2013.gravis.gui.view.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.gui.IModel;
import ch.bfh.bti7301.hs2013.gravis.gui.Model;
import ch.bfh.bti7301.hs2013.gravis.gui.control.IControl.EventSource;
import ch.bfh.bti7301.hs2013.gravis.gui.view.IView;
import ch.bfh.bti7301.hs2013.gravis.gui.view.component.visualization.GravisVisualizationViewer;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;

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
	 * Main constructor.
	 * 
	 * @param top
	 *            the top frame
	 * @param model
	 *            a gravis model
	 * @param layout
	 *            the JUNG layout
	 * @param dimension
	 *            the dimension
	 */
	public VisualizationPanel(JFrame top, Model model,
			Layout<IVertex, IEdge> layout, Dimension dimension) {
		this.setSize(dimension);
		this.titledBorder = BorderFactory
				.createTitledBorder("visualizationPanel");
		this.setBorder(titledBorder);

		/* visualization viewer */
		int width = dimension.width;
		int height = dimension.height - IView.BORDER;
		Dimension visualizerDimension = new Dimension(width, height);
		this.visualizationViewer = new GravisVisualizationViewer(top, layout,
				visualizerDimension);
		model.addObserver(this.visualizationViewer);
		this.graphZoomScrollPane = new GraphZoomScrollPane(
				this.visualizationViewer);

		/* this */
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
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					b.getString("app.label"), 1, null);
			e.printStackTrace();
		}

	}

	/**
	 * Returns the mode box.
	 * 
	 * @return the mode box
	 */
	public JComboBox<?> getModeComboBox() {
		return this.visualizationViewer.getModeComboBox();
	}

}
