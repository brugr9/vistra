package ch.bfh.bti7301.hs2013.gravis.old;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import ch.bfh.bti7301.hs2013.gravis.common.IEdge;
import ch.bfh.bti7301.hs2013.gravis.common.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.EdgeColorTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.VertexColorTransformer;
import ch.bfh.bti7301.hs2013.gravis.gui.GuiFactory;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

/**
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @deprecated
 */
public class OldVisualizationPanel extends VisualizationViewer<IVertex, IEdge>
		implements Observer {

	private static final long serialVersionUID = 177109739873034494L;

	/**
	 * @param layout
	 */
	public OldVisualizationPanel(Layout<IVertex, IEdge> layout) {
		super(layout);

		// TODO add dynamic layout
		this.setPreferredSize(new Dimension(800, 300));

		this.getRenderContext().setVertexLabelTransformer(
				new ToStringLabeller<IVertex>());
		this.getRenderContext().setEdgeLabelTransformer(
				new ToStringLabeller<IEdge>());
		this.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
		this.getRenderContext().setVertexFillPaintTransformer(
				new VertexColorTransformer());
		DefaultModalGraphMouse<IVertex, IEdge> gm = new DefaultModalGraphMouse<>();
		gm.setMode(Mode.PICKING);
		this.setGraphMouse(gm);
		
		
//		this.getRenderContext().setVertexLabelTransformer(
//				new ToStringLabeller<IVertex>());
//		this.getRenderContext().setEdgeLabelTransformer(
//				new ToStringLabeller<IEdge>());
//		this.getRenderer().getVertexLabelRenderer().setPosition(Position.CNTR);
//
//		DefaultModalGraphMouse<IVertex, IEdge> gm = new DefaultModalGraphMouse<>();
//		gm.setMode(Mode.PICKING);
//		this.setGraphMouse(gm);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable observable, Object obj) {
		if (observable instanceof OldIGravisMainListener
				&& obj instanceof Graph<?, ?>) {

			Graph<IVertex, IEdge> graph = (Graph<IVertex, IEdge>) obj;
			// // TODO solve problems with generics
			// Graph<IVertex, IEdge> graph = (Graph<IVertex, IEdge>) obj;
			//
			// // TODO add dynamic layout
			// Layout<IVertex, IEdge> layout = new CircleLayout<IVertex,
			// IEdge>(graph);
			// layout.setSize(new Dimension(250, 250));
			// this.setGraphLayout(layout);

			// TODO add dynamic layout
			Layout<IVertex, IEdge> layout = GuiFactory.createLayout(graph);
			layout.setSize(new Dimension(250, 350));
			this.setGraphLayout(layout);

			// TODO adjust implementation
			this.getRenderContext().setVertexFillPaintTransformer(
					new VertexColorTransformer());
			this.getRenderContext().setEdgeDrawPaintTransformer(
					new EdgeColorTransformer());

		}

		// TODO adjust implementation
		// this.getRenderContext().setVertexFillPaintTransformer(
		// new ColorTransformer());
		this.repaint();
	}

}
