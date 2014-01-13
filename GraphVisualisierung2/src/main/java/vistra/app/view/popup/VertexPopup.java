package vistra.app.view.popup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.ResourceBundle;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import vistra.app.IModel;
import vistra.app.Model;
import vistra.app.control.IControl.ControlEvent;
import vistra.app.control.state.ParameterStateHandler.ParameterEvent;
import vistra.framework.graph.item.IEdgeLayout;
import vistra.framework.graph.item.IItemLayout;
import vistra.framework.graph.item.IVertexLayout;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * A vertex pop-up menu.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VertexPopup extends JPopupMenu implements IItemPopup {

	private static final long serialVersionUID = 3273304014704565148L;

	/**
	 * A field for a visualization viewer.
	 */
	private final VisualizationViewer<IVertexLayout, IEdgeLayout> viewer;
	/**
	 * A field for a model.
	 */
	private Model model;
	/**
	 * A field for a point.
	 */
	@SuppressWarnings("unused")
	private Point2D point;
	/**
	 * A field for a vertex.
	 */
	private IVertexLayout vertex;
	/**
	 * A field for a start check box.
	 */
	private JCheckBoxMenuItem start;
	/**
	 * A field for a finish check box.
	 */
	private JCheckBoxMenuItem end;
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
	public VertexPopup(VisualizationViewer<IVertexLayout, IEdgeLayout> viewer,
			IModel model) {
		super("vertexPopup");
		this.viewer = viewer;
		this.model = (Model) model;
		this.point = null;
		this.vertex = null;

		/**/
		this.start = new JCheckBoxMenuItem("start");
		this.start.setActionCommand(ParameterEvent.start);
		this.start.addActionListener(model.getParameterStateHandler());
		this.start.addActionListener(new StartActionListener());
		//
		this.end = new JCheckBoxMenuItem("end");
		this.end.setActionCommand(ParameterEvent.end);
		this.end.addActionListener(model.getParameterStateHandler());
		this.end.addActionListener(new EndActionListener());
		//
		this.delete = new JMenuItem("delete");
		this.delete.addActionListener(new DeleteActionListener());
		this.delete.setActionCommand(ParameterEvent.delete);
		this.delete.addActionListener(model.getParameterStateHandler());

		/**/
		this.add(this.start);
		this.add(this.end);
		this.addSeparator();
		this.add(this.delete);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setItem(IItemLayout item) {
		if (item instanceof IVertexLayout) {
			this.vertex = (IVertexLayout) item;
			this.start.setSelected(this.vertex.isStart());
			this.end.setSelected(this.vertex.isEnd());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPopupLocation(Point2D point) {
		if (point != null) {
			this.point = point;
		}
	}

	/**
	 * Updates the pop-up.
	 */
	@Override
	public void update(Observable o, Object arg) {

		IModel m = (IModel) o;
		ResourceBundle b = m.getResourceBundle();

		try {
			if (arg == ControlEvent.I18N) {
				this.setLabel(b.getString("vertex.label"));
				this.start.setText(b.getString("start.label"));
				this.end.setText(b.getString("finish.label"));
				this.delete.setText(b.getString("delete.label"));
			} else {
				this.setEnabled(m.isEditVertexEnabled());
				this.start.setEnabled(m.isEditVertexEnabled());
				this.end.setEnabled(m.isEditVertexEnabled());
				this.delete.setEnabled(m.isEditVertexEnabled());
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
	private class StartActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (vertex != null) {
				if (start.isSelected()) {
					IVertexLayout previousStart = model.getStart();
					if (previousStart != null)
						previousStart.setStart(false);
					model.setStart(vertex);

					if (vertex.isEnd()) {
						vertex.setEnd(false);
						model.setEnd(null);
					}
				}
				vertex.setStart(start.isSelected());
				model.notifyObservers();
			}
		}
	}

	/**
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	private class EndActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (vertex != null) {
				if (end.isSelected()) {
					IVertexLayout previousEnd = model.getEnd();
					if (previousEnd != null)
						previousEnd.setEnd(false);
					model.setEnd(vertex);

					if (vertex.isStart()) {
						vertex.setStart(false);
						model.setStart(null);
					}
				}
				vertex.setEnd(end.isSelected());
				model.notifyObservers();
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
			if (vertex != null) {
				viewer.getPickedVertexState().pick(vertex, false);
				if (vertex == model.getStart()) {
					model.setStart(null);
					model.notifyObservers();
				}
				if (vertex == model.getEnd()) {
					model.setEnd(null);
					model.notifyObservers();
				}
				viewer.getGraphLayout().getGraph().removeVertex(vertex);
				viewer.repaint();
			}
		}
	}

}
