package vistra.gui.view.mouse;

import static vistra.gui.control.IControl.EventSource.I18N;
import static vistra.gui.control.IControl.EventSource.MODE;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vistra.core.graph.item.EdgeFactory;
import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.core.graph.item.VertexFactory;
import vistra.gui.GuiModel;
import vistra.gui.IGuiModel;
import vistra.gui.view.popup.EdgePopup;
import vistra.gui.view.popup.ModePopup;
import vistra.gui.view.popup.VertexPopup;
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
public class Mouse extends EditingModalGraphMouse<IVertexLayout, IEdgeLayout>
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
	 * @param top
	 *            a top frame
	 * @param model
	 *            a gui model
	 * @param viewer
	 *            a visualization viewer
	 */
	public Mouse(JFrame top, IGuiModel model,
			VisualizationViewer<IVertexLayout, IEdgeLayout> viewer) {
		super(viewer.getRenderContext(), new VertexFactory(), new EdgeFactory());

		this.modePopup = new ModePopup(model);
		this.vertexPopup = new VertexPopup(top, viewer, model);
		this.edgePopup = new EdgePopup(top, viewer, model);
		((GuiModel) model).addObserver(this.modePopup);
		((GuiModel) model).addObserver(this.vertexPopup);
		((GuiModel) model).addObserver(this.edgePopup);

		this.loadPlugins();
		if (this.popupEditingPlugin instanceof PopupPlugin) {
			((PopupPlugin) this.popupEditingPlugin)
					.setModePopup(this.modePopup);
			((PopupPlugin) this.popupEditingPlugin)
					.setEdgePopup(this.edgePopup);
			((PopupPlugin) this.popupEditingPlugin)
					.setVertexPopup(this.vertexPopup);
		}
		this.setMode(model.getMode()); // TODO evtl. methode überschreiben
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
		this.pickingPlugin = new PickingPlugin();
		this.animatedPickingPlugin = new AnimatedPickingGraphMousePlugin<IVertexLayout, IEdgeLayout>();
		/* editing */
		this.popupEditingPlugin = new PopupPlugin(this.vertexFactory,
				this.edgeFactory);
		this.editingPlugin = new EditingPlugin(this.vertexFactory,
				this.edgeFactory);
		this.labelEditingPlugin = new LabelEditingGraphMousePlugin<IVertexLayout, IEdgeLayout>();
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

		IGuiModel m = (IGuiModel) o;
		ResourceBundle b = m.getResourceBundle();

		try {
			if (arg == I18N) {
				this.modePopup.setLabel(b.getString("mode.label"));
				this.vertexPopup.setLabel(b.getString("vertex.label"));
				this.edgePopup.setLabel(b.getString("edge.label"));
			} else if (arg == MODE) {
				this.setMode(m.getMode());
				this.modePopup.setEnabled(m.isModeEnabled());
				this.vertexPopup.setEnabled(m.isVertexEnabled());
				this.edgePopup.setEnabled(m.isEdgeEnabled());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					b.getString("app.label"), 1, null);
			e.printStackTrace();
		}

	}
}
