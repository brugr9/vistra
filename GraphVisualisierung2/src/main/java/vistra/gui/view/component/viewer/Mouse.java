package vistra.gui.view.component.viewer;

import java.awt.event.ItemEvent;

import javax.swing.JPopupMenu;

import org.apache.commons.collections15.Factory;

import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import vistra.gui.view.component.viewer.popup.MenuFactory;
import edu.uci.ics.jung.visualization.RenderContext;
import edu.uci.ics.jung.visualization.annotations.AnnotatingGraphMousePlugin;
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
public class Mouse extends EditingModalGraphMouse<IVertex, IEdge> {

	/**
	 * Main constructor.
	 * 
	 * @param rc
	 *            a render context
	 * @param vertexFactory
	 *            a vertex factory
	 * @param edgeFactory
	 *            an edge factory
	 * @param edgePopup
	 *            an edge popup
	 * @param vertexPopup
	 *            a vertex popup
	 * @param createVertexPopup
	 *            a createVertexPopup
	 */
	public Mouse(RenderContext<IVertex, IEdge> rc,
			Factory<IVertex> vertexFactory, Factory<IEdge> edgeFactory,
			JPopupMenu edgePopup, JPopupMenu vertexPopup,
			MenuFactory createVertexPopup) {

		super(rc, vertexFactory, edgeFactory);

		if (this.popupEditingPlugin instanceof PopupPlugin) {
			((PopupPlugin) this.popupEditingPlugin).setEdgePopup(edgePopup);
			((PopupPlugin) this.popupEditingPlugin).setVertexPopup(vertexPopup);
			((PopupPlugin) this.popupEditingPlugin)
					.setVertexCreatePopup(createVertexPopup);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void loadPlugins() {
		// Picking
		this.pickingPlugin = new PickingPlugin();
		this.animatedPickingPlugin = new AnimatedPickingGraphMousePlugin<IVertex, IEdge>();
		this.scalingPlugin = new ScalingGraphMousePlugin(
				new CrossoverScalingControl(), 0, this.in, this.out);
		// Editing
		this.editingPlugin = new EditingPlugin(this.vertexFactory,
				this.edgeFactory);
		this.labelEditingPlugin = new LabelEditingGraphMousePlugin<IVertex, IEdge>();
		this.annotatingPlugin = new AnnotatingGraphMousePlugin<IVertex, IEdge>(
				rc);
		// Popup
		this.popupEditingPlugin = new PopupPlugin(this.vertexFactory,
				this.edgeFactory);
		/**/
		this.add(scalingPlugin);
		this.setMode(Mode.EDITING);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setPickingMode() {
		remove(this.editingPlugin);
		remove(this.annotatingPlugin);
		add(this.pickingPlugin);
		add(this.animatedPickingPlugin);
		add(this.popupEditingPlugin);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setEditingMode() {
		remove(this.pickingPlugin);
		remove(this.animatedPickingPlugin);
		remove(this.labelEditingPlugin);
		remove(this.annotatingPlugin);
		add(this.editingPlugin);
		add(this.popupEditingPlugin);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setAnnotatingMode() {
		remove(this.pickingPlugin);
		remove(this.animatedPickingPlugin);
		remove(this.labelEditingPlugin);
		remove(this.editingPlugin);
		remove(this.popupEditingPlugin);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMode(Mode mode) {
		if (this.mode != mode && mode != Mode.ANNOTATING) {
			this.fireItemStateChanged(new ItemEvent(this,
					ItemEvent.ITEM_STATE_CHANGED, this.mode,
					ItemEvent.DESELECTED));
			this.mode = mode;

			if (this.mode == Mode.PICKING) {
				this.setPickingMode();
			} else if (this.mode == Mode.EDITING) {
				this.setEditingMode();
			}

			if (this.modeBox != null) {
				this.modeBox.setSelectedItem(mode);
			}

			this.fireItemStateChanged(new ItemEvent(this,
					ItemEvent.ITEM_STATE_CHANGED, mode, ItemEvent.SELECTED));
		}
	}

}