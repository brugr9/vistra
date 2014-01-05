package vistra.app.view;

import vistra.app.GuiModel;
import vistra.app.control.IControl;
import vistra.app.view.component.AlgorithmPanel;
import vistra.app.view.component.GraphPanel;
import vistra.app.view.component.MenuBar;
import vistra.app.view.component.ToolBar;
import vistra.app.view.component.TraversalPanel;
import vistra.framework.graph.item.IEdgeLayout;
import vistra.framework.graph.item.IVertexLayout;
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
