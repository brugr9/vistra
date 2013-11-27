package ch.bfh.bti7301.hs2013.gravis.gui.visualization;

import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;

import javax.swing.JComboBox;
import javax.swing.JPopupMenu;

import org.apache.commons.collections15.Factory;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.gui.visualization.popup.CreateVertexMenu;
import edu.uci.ics.jung.visualization.RenderContext;
import edu.uci.ics.jung.visualization.annotations.AnnotatingGraphMousePlugin;
import edu.uci.ics.jung.visualization.control.AnimatedPickingGraphMousePlugin;
import edu.uci.ics.jung.visualization.control.CrossoverScalingControl;
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse;
import edu.uci.ics.jung.visualization.control.LabelEditingGraphMousePlugin;
import edu.uci.ics.jung.visualization.control.RotatingGraphMousePlugin;
import edu.uci.ics.jung.visualization.control.ScalingGraphMousePlugin;
import edu.uci.ics.jung.visualization.control.ShearingGraphMousePlugin;
import edu.uci.ics.jung.visualization.control.TranslatingGraphMousePlugin;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * 
 */
class GravisModalGraphMouse extends EditingModalGraphMouse<IVertex, IEdge> {

	/**
	 * 
	 * @param rc
	 * @param vertexFactory
	 * @param edgeFactory
	 * @param edgePopup
	 * @param vertexPopup
	 * @param vertexCreatePopup
	 */
	public GravisModalGraphMouse(RenderContext<IVertex, IEdge> rc,
			Factory<IVertex> vertexFactory, Factory<IEdge> edgeFactory,
			JPopupMenu edgePopup, JPopupMenu vertexPopup,
			CreateVertexMenu vertexCreatePopup) {

		super(rc, vertexFactory, edgeFactory);

		if (this.popupEditingPlugin instanceof GravisPopupGraphMousePlugin) {
			((GravisPopupGraphMousePlugin) this.popupEditingPlugin)
					.setEdgePopup(edgePopup);
			((GravisPopupGraphMousePlugin) this.popupEditingPlugin)
					.setVertexPopup(vertexPopup);
			((GravisPopupGraphMousePlugin) this.popupEditingPlugin)
			.setVertexCreatePopup(vertexCreatePopup);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uci.ics.jung.visualization.control.EditingModalGraphMouse#loadPlugins
	 * ()
	 */
	@Override
	protected void loadPlugins() {
		// GravisPickingGraphMousePlugin class used
		this.pickingPlugin = new GravisPickingGraphMousePlugin();
		this.animatedPickingPlugin = new AnimatedPickingGraphMousePlugin<IVertex, IEdge>();
		this.translatingPlugin = new TranslatingGraphMousePlugin(
				InputEvent.BUTTON1_MASK);
		this.scalingPlugin = new ScalingGraphMousePlugin(
				new CrossoverScalingControl(), 0, this.in, this.out);
		this.rotatingPlugin = new RotatingGraphMousePlugin();
		this.shearingPlugin = new ShearingGraphMousePlugin();
		// GravisEditingGraphMousePlugin class used
		this.editingPlugin = new GravisEditingGraphMousePlugin(
				this.vertexFactory, this.edgeFactory);
		this.labelEditingPlugin = new LabelEditingGraphMousePlugin<IVertex, IEdge>();
		this.annotatingPlugin = new AnnotatingGraphMousePlugin<IVertex, IEdge>(
				rc);
		// GravisPopupGraphMousePlugin class used
		this.popupEditingPlugin = new GravisPopupGraphMousePlugin(
				this.vertexFactory, this.edgeFactory);
		this.add(scalingPlugin);
		this.setMode(Mode.EDITING);
	}

	@Override
	protected void setPickingMode() {
		remove(this.translatingPlugin);
		remove(this.rotatingPlugin);
		remove(this.shearingPlugin);
		remove(this.editingPlugin);
		remove(this.annotatingPlugin);
		add(this.pickingPlugin);
		add(this.animatedPickingPlugin);
		add(this.popupEditingPlugin);
	}

	@Override
	protected void setTransformingMode() {
		remove(this.pickingPlugin);
		remove(this.animatedPickingPlugin);
		remove(this.editingPlugin);
		remove(this.annotatingPlugin);
		add(this.translatingPlugin);
		add(this.rotatingPlugin);
		add(this.shearingPlugin);
		add(this.popupEditingPlugin);
	}

	protected void setEditingMode() {
		remove(this.pickingPlugin);
		remove(this.animatedPickingPlugin);
		remove(this.translatingPlugin);
		remove(this.rotatingPlugin);
		remove(this.shearingPlugin);
		remove(this.labelEditingPlugin);
		remove(this.annotatingPlugin);
		add(this.editingPlugin);
		add(this.popupEditingPlugin);
	}

	protected void setAnnotatingMode() {
		remove(this.pickingPlugin);
		remove(this.animatedPickingPlugin);
		remove(this.translatingPlugin);
		remove(this.rotatingPlugin);
		remove(this.shearingPlugin);
		remove(this.labelEditingPlugin);
		remove(this.editingPlugin);
		remove(this.popupEditingPlugin);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uci.ics.jung.visualization.control.EditingModalGraphMouse#setMode
	 * (edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode)
	 */
	@Override
	public void setMode(Mode mode) {
		if (this.mode != mode && mode != Mode.ANNOTATING) {
			this.fireItemStateChanged(new ItemEvent(this,
					ItemEvent.ITEM_STATE_CHANGED, this.mode,
					ItemEvent.DESELECTED));
			this.mode = mode;

			if (mode == Mode.TRANSFORMING) {
				this.setTransformingMode();
			} else if (mode == Mode.PICKING) {
				this.setPickingMode();
			} else if (mode == Mode.EDITING) {
				this.setEditingMode();
			}

			if (this.modeBox != null) {
				this.modeBox.setSelectedItem(mode);
			}

			this.fireItemStateChanged(new ItemEvent(this,
					ItemEvent.ITEM_STATE_CHANGED, mode, ItemEvent.SELECTED));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.uci.ics.jung.visualization.control.EditingModalGraphMouse#getModeComboBox
	 * ()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public JComboBox<Mode> getModeComboBox() {
		if (this.modeBox == null) {
			this.modeBox = new JComboBox<>(new Mode[] { Mode.PICKING,
					Mode.EDITING, Mode.TRANSFORMING });
			this.modeBox.addItemListener(this.getModeListener());
		}
		this.modeBox.setSelectedItem(this.mode);

		return this.modeBox;
	}

}
