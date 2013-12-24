package vistra.gui.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import vistra.core.graph.item.edge.IEdgeLayout;
import vistra.core.graph.item.vertex.IVertexLayout;
import vistra.gui.GuiModel;
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
public class FullView extends DefaultView {

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
	public FullView(Layout<IVertexLayout, IEdgeLayout> layout, GuiModel model,
			IControl control) throws Exception {
		super(layout, model, control);

		/* Component */
		int width = FRAME_WIDTH;
		int height = FRAME_HEIGHT - VISUALISATION_HEIGHT
				- this.menuBar.getHeight();
		this.protocolPanel = new ProtocolPanel(new Dimension(width, height));
		model.addObserver(this.protocolPanel);
		/* this */
		this.add(this.protocolPanel, BorderLayout.SOUTH);
		this.setVisible(true);
	}

}
