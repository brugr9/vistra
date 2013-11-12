package ch.bfh.bti7301.hs2013.gravis.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.apache.commons.collections15.Factory;
import org.apache.commons.collections15.Transformer;

import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.EdgeFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.VertexFactory;
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
public class VisualizationPanel extends JPanel implements Observer {

	private static final long serialVersionUID = 177109739873034494L;
	
	private Observer visualizationViewer;
	
	/**
	 * 
	 * @param visualizationViewer
	 */
	public VisualizationPanel(GravisVisualizationViewer visualizationViewer) {
		super();
		
		this.visualizationViewer = visualizationViewer;
		EditingModalGraphMouse<IVertex,IEdge> graphMouse = 
				new EditingModalGraphMouse<>(visualizationViewer.getRenderContext(), 
						new VertexFactory(), new EdgeFactory());

		visualizationViewer.setGraphMouse(graphMouse);
		visualizationViewer.addKeyListener(graphMouse.getModeKeyListener());
		graphMouse.setMode(ModalGraphMouse.Mode.EDITING);
		
		JPanel controls = new JPanel();
		JComboBox modeBox = graphMouse.getModeComboBox();
		controls.add(modeBox);
		this.add(controls, BorderLayout.NORTH);
		
		GraphZoomScrollPane panel = new GraphZoomScrollPane(visualizationViewer);
		this.add(panel, BorderLayout.CENTER);
	}

	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable o, Object arg) {
		this.visualizationViewer.update(o, arg);
		
//		this.repaint();
	}

}
