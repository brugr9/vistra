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
import vistra.gui.IGuiModel;
import vistra.gui.GuiModel;
import vistra.gui.control.IControl.EventSource;
import vistra.gui.view.IView;
import vistra.gui.view.component.viewer.Viewer;
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
	private TitledBorder border;
	/**
	 * A field for a viewer.
	 */
	private Viewer viewer;
	/**
	 * A field for a graph zoom scroll pane.
	 */
	private GraphZoomScrollPane zoom;

	/**
	 * Main constructor.
	 * 
	 * @param top
	 *            the top frame
	 * @param model
	 *            a model as in MVC
	 * @param layout
	 *            a JUNG layout
	 * @param size
	 *            the panel size
	 */
	public GraphPanel(JFrame top, GuiModel model, Layout<IVertex, IEdge> layout,
			Dimension size) {
		this.setSize(size);
		this.border = BorderFactory.createTitledBorder("graphPanel");
		this.setBorder(border);

		/* viewer */
		this.viewer = new Viewer(top, model, layout, new Dimension(size.width,
				size.height - IView.BORDER));
		model.addObserver(this.viewer);
		/* zoom */
		this.zoom = new GraphZoomScrollPane(this.viewer);
		/* this */
		this.add(this.zoom, BorderLayout.CENTER);

	}

	/**
	 * Updates the panel.
	 */
	@Override
	public void update(Observable o, Object arg) {

		IGuiModel m = (IGuiModel) o;
		ResourceBundle b = m.getResourceBundle();

		try {
			if (arg == EventSource.I18N || arg == EventSource.GRAPH) {
				String title = b.getString("graph.label") + ": ";
				if (!m.isGraphSaved())
					title += "*";
				title += m.getGraph().getName();
				this.border.setTitle(title);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					b.getString("app.label"), 1, null);
			e.printStackTrace();
		}

	}

}
