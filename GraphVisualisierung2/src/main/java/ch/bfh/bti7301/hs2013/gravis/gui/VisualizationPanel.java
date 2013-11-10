package ch.bfh.bti7301.hs2013.gravis.gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import org.apache.commons.collections15.Factory;
import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.common.IEdge;
import ch.bfh.bti7301.hs2013.gravis.common.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.util.EdgeColorTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.PointTransformer;
import ch.bfh.bti7301.hs2013.gravis.core.util.VertexColorTransformer;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.DefaultModalGraphMouse;
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;
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
		
//		final EditingModalGraphMouse<Number,Number> graphMouse = 
//		new EditingModalGraphMouse<Number,Number>(vv.getRenderContext(), 
//				vertexFactory, edgeFactory);
//		vv.setGraphMouse(graphMouse);
//		vv.addKeyListener(graphMouse.getModeKeyListener());
//		graphMouse.setMode(ModalGraphMouse.Mode.EDITING);
		
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
			// GuiModel m = (GuiModel) o;

			try {
				@SuppressWarnings("unchecked")
				Graph<IVertex, IEdge> graph = (Graph<IVertex, IEdge>) arg;

				// TODO add dynamic layout
				Layout<IVertex, IEdge> layout = GuiFactory.createLayout(graph,
						new PointTransformer());
				layout.setSize(new Dimension(250, 350));
				this.setGraphLayout(layout);

				Transformer<IVertex, Shape> vertexSize = new Transformer<IVertex, Shape>() {
					public Shape transform(IVertex vertex) {
						Ellipse2D circle = new Ellipse2D.Double(-15, -15, 30,
								30);
						// if(i == 2) return AffineTransform.getScaleInstance(2,
						// 2).createTransformedShape(circle);
						// else return circle;
						return circle;
					}
				};

				// TODO adjust implementation
				this.getRenderContext().setVertexFillPaintTransformer(
						new VertexColorTransformer());
				this.getRenderContext().setEdgeDrawPaintTransformer(
						new EdgeColorTransformer());
				this.getRenderContext().setVertexShapeTransformer(vertexSize);
				
				// this.setVertexToolTipTransformer(vertexToolTipTransformer);

//				Container content = getContentPane();
//				final GraphZoomScrollPane panel = new GraphZoomScrollPane(vv);
//				content.add(panel);
//				Factory<Number> vertexFactory = new VertexFactory();
//				Factory<Number> edgeFactory = new EdgeFactory();

				// this.visualizationPanelBorder.setTitle(m
				// .getVisualizationPanelLabel());
			} catch (Exception e) {
				// JOptionPane.showMessageDialog(null, e.toString(),
				// m.getProgramName(), 1, null);
				e.printStackTrace();
			}
		}

		this.repaint();
	}

}
