package vistra.app.view.popup;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import vistra.app.IModel;
import vistra.app.Model;
import vistra.app.control.IControl.ControlEvent;
import vistra.framework.graph.item.EdgeFactory;
import vistra.framework.graph.item.ILayoutEdge;
import vistra.framework.graph.item.ILayoutVertex;
import vistra.framework.graph.item.VertexFactory;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.AnimatedPickingGraphMousePlugin;
import edu.uci.ics.jung.visualization.control.CrossoverScalingControl;
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse;
import edu.uci.ics.jung.visualization.control.LabelEditingGraphMousePlugin;
import edu.uci.ics.jung.visualization.control.ScalingGraphMousePlugin;

/**
 * An adapted JUNG mouse plugin for editing a modal graph.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class Mouse extends EditingModalGraphMouse<ILayoutVertex, ILayoutEdge>
		implements Observer {

	/**
	 * A field for a switch-mode pop-up menu.
	 */
	private ModePopup modePopup;
	/**
	 * A field for a vertex pop-up menu.
	 */
	private VertexPopup vertexPopup;
	/**
	 * A field for an edge pop-up menu.
	 */
	private EdgePopup edgePopup;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            a gui model
	 * @param viewer
	 *            a visualization viewer
	 */
	public Mouse(IModel model,
			VisualizationViewer<ILayoutVertex, ILayoutEdge> viewer) {
		super(viewer.getRenderContext(), new VertexFactory(), new EdgeFactory());

		this.modePopup = new ModePopup(model);
		this.vertexPopup = new VertexPopup(viewer, model);
		this.edgePopup = new EdgePopup(viewer, model);
		((Model) model).addObserver(this.modePopup);
		((Model) model).addObserver(this.vertexPopup);
		((Model) model).addObserver(this.edgePopup);

		this.loadPlugins();
		if (this.popupEditingPlugin instanceof PopupPlugin) {
			((PopupPlugin) this.popupEditingPlugin)
					.setModePopup(this.modePopup);
			((PopupPlugin) this.popupEditingPlugin)
					.setEdgePopup(this.edgePopup);
			((PopupPlugin) this.popupEditingPlugin)
					.setVertexPopup(this.vertexPopup);
		}
		this.setMode(Mode.PICKING); // TODO use?
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void loadPlugins() {
		/* scaling */
		this.scalingPlugin = new ScalingGraphMousePlugin(
				new CrossoverScalingControl(), 0, this.in, this.out);
		this.add(this.scalingPlugin);
		/* picking */
		this.pickingPlugin = new Picking();
		this.animatedPickingPlugin = new AnimatedPickingGraphMousePlugin<ILayoutVertex, ILayoutEdge>();
		/* editing */
		this.popupEditingPlugin = new PopupPlugin(this.vertexFactory,
				this.edgeFactory);
		this.editingPlugin = new Editing(this.vertexFactory, this.edgeFactory);
		this.labelEditingPlugin = new LabelEditingGraphMousePlugin<ILayoutVertex, ILayoutEdge>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setPickingMode() {
		add(this.pickingPlugin);
		add(this.animatedPickingPlugin);
		remove(this.popupEditingPlugin);
		remove(this.editingPlugin);
		remove(this.labelEditingPlugin);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setEditingMode() {
		remove(this.pickingPlugin);
		remove(this.animatedPickingPlugin);
		add(this.popupEditingPlugin);
		add(this.editingPlugin);
		add(this.labelEditingPlugin);
	}

	/**
	 * Updates the mouse.
	 */
	@Override
	public void update(Observable o, Object arg) {

		IModel m = (IModel) o;
		ResourceBundle b = m.getResourceBundle();

		try {
			if (arg == ControlEvent.I18N) {
				this.modePopup.setLabel(b.getString("mode.label"));
				this.vertexPopup.setLabel(b.getString("vertex.label"));
				this.edgePopup.setLabel(b.getString("edge.label"));
			} else {
				this.setMode(m.getMode());
				this.modePopup.setEnabled(m.isSwitchModeEnabled());
				this.vertexPopup.setEnabled(m.isEditVertexEnabled());
				this.edgePopup.setEnabled(m.isEditEdgeEnabled());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					b.getString("app.label"), 1, null);
			e.printStackTrace();
		}

	}
}
