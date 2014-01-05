package vistra.gui.view;

import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.gui.GuiModel;
import vistra.gui.control.IControl;
import vistra.gui.view.component.AlgorithmPanel;
import vistra.gui.view.component.GraphPanel;
import vistra.gui.view.component.MenuBar;
import vistra.gui.view.component.ToolBar;
import vistra.gui.view.component.TraversalPanel;
import edu.uci.ics.jung.algorithms.layout.Layout;

/**
 * A view as in MVC.
 * <p>
 * This view instantiates
 * <ul>
 * <li>a {@link MenuBar}
 * <li>a {@link ToolBar}
 * <li>a {@link GraphPanel}
 * <li>a controller panel with a {@link AlgorithmPanel} and a
 * {@link TraversalPanel}
 * </ul>
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public class FullView extends DefaultView implements IView {

	private static final long serialVersionUID = 1L;

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
		// TODO
		this.setVisible(true);
	}

}
