package vistra.app.view.component.mouse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import vistra.app.IModel;
import vistra.app.Model;
import vistra.app.control.ActionListenerI18n.I18nEvent;
import vistra.app.control.state.ParameterStateHandler.ParameterEvent;
import vistra.framework.graph.item.ILayoutEdge;
import vistra.framework.graph.item.ILayoutItem;
import vistra.framework.graph.item.ILayoutVertex;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * An edge pop-up menu.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class EdgePopup extends JPopupMenu implements IItemPopup {

	private static final long serialVersionUID = 3273304014704565148L;

	/**
	 * A field for a visualization viewer.
	 */
	private final VisualizationViewer<ILayoutVertex, ILayoutEdge> viewer;
	/**
	 * A field for a model.
	 */
	private Model model;
	/**
	 * A field for a point.
	 */
	private Point2D point;
	/**
	 * A field for a edge.
	 */
	private ILayoutEdge edge;
	/**
	 * A field for a dialog menu item.
	 */
	private JMenuItem dialog;
	/**
	 * A field for a delete menu item.
	 */
	private JMenuItem delete;

	/**
	 * Main constructor.
	 * 
	 * @param viewer
	 *            the visualization viewer
	 * @param model
	 *            the gui model
	 */
	public EdgePopup(VisualizationViewer<ILayoutVertex, ILayoutEdge> viewer,
			IModel model) {
		super("edgePopup");
		/**/
		this.viewer = viewer;
		this.model = (Model) model;
		this.point = null;
		this.edge = null;
		/**/
		this.dialog = new JMenuItem("dialog");
		this.dialog.addActionListener(new DialogActionListener());
		this.delete = new JMenuItem("delete");
		this.delete.addActionListener(new DeleteActionListener());
		this.delete.setActionCommand(ParameterEvent.delete);
		this.delete.addActionListener(model.getParameterStateHandler());

		/**/
		this.add(this.dialog);
		this.addSeparator();
		this.add(this.delete);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setItem(ILayoutItem item) {
		if (item instanceof ILayoutVertex) {
			this.edge = (ILayoutEdge) item;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPopupLocation(Point2D point) {
		if (point != null)
			this.point = point;
	}

	/**
	 * Updates the pop-up.
	 */
	@Override
	public void update(Observable o, Object arg) {

		IModel m = (IModel) o;
		ResourceBundle b = m.getResourceBundle();

		try {
			if (arg == I18nEvent.I18N) {
				this.setLabel(b.getString("edge.label"));
				this.dialog.setText(b.getString("edit.label"));
				this.delete.setText(b.getString("delete.label"));
			} else {
				this.setEnabled(m.isEditEdgeEnabled());
				this.dialog.setEnabled(m.isEditEdgeEnabled());
				this.delete.setEnabled(m.isEditEdgeEnabled());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					b.getString("app.label"), 1, null);
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private class DialogActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (point != null && edge != null) {
				EdgeDialog dialog = new EdgeDialog((JFrame) model.getTop(),
						viewer, model, edge);
				dialog.setLocation((int) point.getX() + model.getTop().getX(),
						(int) point.getY() + model.getTop().getY());
				dialog.setVisible(true);
			}
		}
	}

	/**
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private class DeleteActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (edge != null) {
				viewer.getPickedEdgeState().pick(edge, false);
				viewer.getGraphLayout().getGraph().removeEdge(edge);
				viewer.repaint();
			}
		}
	}

}
