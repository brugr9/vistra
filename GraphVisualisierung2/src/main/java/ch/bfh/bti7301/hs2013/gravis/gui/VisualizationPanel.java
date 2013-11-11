package ch.bfh.bti7301.hs2013.gravis.gui;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import ch.bfh.bti7301.hs2013.gravis.common.IEdge;
import ch.bfh.bti7301.hs2013.gravis.common.IVertex;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.EdgeFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.VertexFactory;
import edu.uci.ics.jung.visualization.GraphZoomScrollPane;
import edu.uci.ics.jung.visualization.control.EditingModalGraphMouse;
import edu.uci.ics.jung.visualization.control.ModalGraphMouse;

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
                
                this.repaint();
        }

}