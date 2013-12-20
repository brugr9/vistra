package vistra.gui.view;

import java.awt.BorderLayout;

import vistra.core.graph.item.edge.IEdge;
import vistra.core.graph.item.vertex.IVertex;
import vistra.gui.Model;
import vistra.gui.control.IControl;
import vistra.gui.view.component.AlgorithmPanel;
import vistra.gui.view.component.GraphPanel;
import vistra.gui.view.component.MenuBar;
import vistra.gui.view.component.ProtocolPanel;
import vistra.gui.view.component.TraversalPanel;
import edu.uci.ics.jung.algorithms.layout.Layout;

/**
 * A view as in MVC.
 * <p>
 * This view instantiates
 * <ul>
 * <li>a {@link MenuBar}
 * <li>a {@link GraphPanel}
 * <li>a controller panel with a {@link AlgorithmPanel} and a
 * {@link TraversalPanel}
 * <li>a {@link ProtocolPanel}
 * </ul>
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class FullView extends MinimalView {

	private static final long serialVersionUID = 1L;

	/**
	 * A field for a protocol panel.
	 */
	private final ProtocolPanel protocolPanel;

	/**
	 * Main constructor.
	 * 
	 * @param model
	 *            a model as in MVC
	 * @param control
	 *            a control as in MVC
	 * @throws Exception
	 */
	public FullView(Layout<IVertex, IEdge> layout, Model model, IControl control)
			throws Exception {
		super(layout, model, control);

		/* Component */
		int width = FRAME_WIDTH - VISUALISATION_WIDTH;
		int height = FRAME_HEIGHT - VISUALISATION_HEIGHT
				- this.menuBar.getHeight();
		this.protocolPanel = new ProtocolPanel(width, height);
		/* observe the model */
		model.addObserver(protocolPanel);
		/* this */
		this.add(this.protocolPanel, BorderLayout.SOUTH);
		control.init();
	}

}
