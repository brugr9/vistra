package vistra.gui.view.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import vistra.gui.IModel;
import vistra.gui.Model;
import vistra.gui.control.IControl.EventSource;
import vistra.gui.view.IView;
import vistra.gui.view.component.adapted.AdaptedVisualizationViewer;

import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;

/**
 * A graph panel.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class GraphPanel extends JPanel implements Observer {

	private static final long serialVersionUID = 177109739873034494L;

	/**
	 * A field for a titled border.
	 */
	private TitledBorder titledBorder;
	/**
	 * A field for an adapted visualization viewer.
	 */
	private AdaptedVisualizationViewer visualizationViewer;
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
	 *            a model as in MVC
	 * @param layout
	 *            the JUNG layout
	 * @param dimension
	 *            the dimension
	 */
	public GraphPanel(JFrame top, Model model, Layout<IVertex, IEdge> layout,
			Dimension dimension) {
		this.setSize(dimension);
		this.titledBorder = BorderFactory
				.createTitledBorder("visualizationPanel");
		this.setBorder(titledBorder);

		/* visualization viewer */
		int width = dimension.width;
		int height = dimension.height - IView.BORDER;
		Dimension visualizerDimension = new Dimension(width, height);
		this.visualizationViewer = new AdaptedVisualizationViewer(top, layout,
				visualizerDimension);
		model.addObserver(this.visualizationViewer);
		this.graphZoomScrollPane = new GraphZoomScrollPane(
				this.visualizationViewer);

		/* this */
		this.add(this.graphZoomScrollPane, BorderLayout.CENTER);

	}

	/**
	 * Updates the panel.
	 */
	@Override
	public void update(Observable o, Object arg) {

		IModel m = (IModel) o;
		ResourceBundle b = m.getResourceBundle();

		try {
			if (arg == EventSource.I18N || arg == EventSource.GRAPH) {
				String title = b.getString("visualization.label") + ": ";
				if (!m.isGraphSaved())
					title += "*";
				title += m.getGraph().getId();
				this.titledBorder.setTitle(title);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					b.getString("app.label"), 1, null);
			e.printStackTrace();
		}

	}

}
