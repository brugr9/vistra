package ch.bfh.bti7301.hs2013.gravis.gui;

import java.awt.Dimension;
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.common.IEdge;
import ch.bfh.bti7301.hs2013.gravis.common.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.EdgeColorTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.VertexColorTransformer;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse.Mode;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;

/**
 * A visualization panel.
 * 
 * @author Patrick Kofmel (kofmp1@bfh.ch)
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class VisualizationPanel extends VisualizationViewer<IVertex, IEdge>
		implements Observer {

	private static final long serialVersionUID = 177109739873034494L;

	/**
	 * A field for a titled border.
	 */
	private TitledBorder visualizationPanelBorder;

	public VisualizationPanel(Layout<IVertex, IEdge> layout) {
		super(layout);

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
		this.visualizationPanelBorder = BorderFactory
				.createTitledBorder("visualizationPanel");
		this.setBorder(visualizationPanelBorder);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {

		// TODO bitte an dieser Klasse nichts ändern (pk)

		// if (o instanceof GuiModel && arg instanceof Graph<?, ?>) {
		// GuiModel m = (GuiModel) o;
			if (arg instanceof Graph<?, ?>) {
//				GuiModel m = (GuiModel) o;

			try {
				@SuppressWarnings("unchecked")
				Graph<IVertex, IEdge> graph = (Graph<IVertex, IEdge>) arg;

				Transformer<IVertex,Point2D> pointTransformer = new Transformer<IVertex,Point2D>() {
					@Override
					public Point2D transform(IVertex vertex) {
						return vertex.getLocation();
					}
				};
				
				// TODO add dynamic layout
				Layout<IVertex, IEdge> layout = GuiFactory.createLayout(graph, pointTransformer);
				layout.setSize(new Dimension(250, 350));
				this.setGraphLayout(layout);

				// TODO adjust implementation
				this.getRenderContext().setVertexFillPaintTransformer(
						new VertexColorTransformer());
				this.getRenderContext().setEdgeDrawPaintTransformer(
						new EdgeColorTransformer());

//				this.visualizationPanelBorder.setTitle(m
//						.getVisualizationPanelLabel());
			} catch (Exception e) {
//				JOptionPane.showMessageDialog(null, e.toString(),
//						m.getProgramName(), 1, null);
				e.printStackTrace();
			}
		}

		this.repaint();
	}

}
