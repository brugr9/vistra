package ch.bfh.bti7301.hs2013.gravis.gui.visualization;

import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;

import javax.swing.JComboBox;
import javax.swing.JPopupMenu;

import org.apache.commons.collections15.Factory;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import edu.uci.ics.jung.visualization.RenderContext;
import edu.uci.ics.jung.visualization.annotations.AnnotatingGraphMousePlugin;
import edu.uci.ics.jung.visualization.control.AnimatedPickingGraphMousePlugin;
import edu.uci.ics.jung.visualization.control.CrossoverScalingControl;
import edu.uci.ics.jung.visualization.control.EditingGraphMousePlugin;
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse;
import edu.uci.ics.jung.visualization.control.LabelEditingGraphMousePlugin;
import edu.uci.ics.jung.visualization.control.PickingGraphMousePlugin;
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
	 */
	public GravisModalGraphMouse(RenderContext<IVertex, IEdge> rc,
			Factory<IVertex> vertexFactory, Factory<IEdge> edgeFactory,
			JPopupMenu edgePopup, JPopupMenu vertexPopup) {

		super(rc, vertexFactory, edgeFactory);

		if (this.popupEditingPlugin instanceof GravisPopupGraphMousePlugin) {
			((GravisPopupGraphMousePlugin) this.popupEditingPlugin)
					.setEdgePopup(edgePopup);
			((GravisPopupGraphMousePlugin) this.popupEditingPlugin)
			.setVertexPopup(vertexPopup);
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
		this.pickingPlugin = new PickingGraphMousePlugin<IVertex, IEdge>();
		this.animatedPickingPlugin = new AnimatedPickingGraphMousePlugin<IVertex, IEdge>();
		this.translatingPlugin = new TranslatingGraphMousePlugin(
				InputEvent.BUTTON1_MASK);
		this.scalingPlugin = new ScalingGraphMousePlugin(
				new CrossoverScalingControl(), 0, this.in, this.out);
		this.rotatingPlugin = new RotatingGraphMousePlugin();
		this.shearingPlugin = new ShearingGraphMousePlugin();
		this.editingPlugin = new EditingGraphMousePlugin<IVertex, IEdge>(
				this.vertexFactory, this.edgeFactory);
		this.labelEditingPlugin = new LabelEditingGraphMousePlugin<IVertex, IEdge>();
		this.annotatingPlugin = new AnnotatingGraphMousePlugin<IVertex, IEdge>(rc);
		// GravisPopupGraphMousePlugin class needed
		this.popupEditingPlugin = new GravisPopupGraphMousePlugin(
				this.vertexFactory, this.edgeFactory);
		this.add(scalingPlugin);
		this.setMode(Mode.EDITING);
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
