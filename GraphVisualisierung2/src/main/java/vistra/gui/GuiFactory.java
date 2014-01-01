package vistra.gui;

import vistra.core.ICore;
import vistra.core.graph.item.IEdgeLayout;
import vistra.core.graph.item.IVertexLayout;
import vistra.gui.control.Control;
import vistra.gui.control.IControl;
import vistra.gui.view.DefaultView;
import vistra.gui.view.FullView;
import vistra.gui.view.IView;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;

/**
 * A factory creating MVC based graphic user interfaces.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
public final class GuiFactory {

	/**
	 * A main (no-)constructor.
	 */
	private GuiFactory() {
	}

	/**
	 * Creates a graphic user interface (MVC).
	 * 
	 * @param core
	 *            a core
	 * @return a view as in MVC
	 * @throws Exception
	 */
	public static IView createGui(ICore core) throws Exception {
		try {
			return createGui(core, ViewType.DEFAULT);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Creates a graphic user interface (MVC).
	 * 
	 * @param core
	 *            a core
	 * @param type
	 *            the view type
	 * @return a view as in MVC
	 * @throws Exception
	 */
	public static IView createGui(ICore core, ViewType type) throws Exception {
		try {
			// model and control
			GuiModel model = new GuiModel();
			IControl control = new Control(core, model);
			// view
			IView view;
			Layout<IVertexLayout, IEdgeLayout> layout = new StaticLayout<IVertexLayout, IEdgeLayout>(
					model.getGraph());
			if (type == ViewType.FULL)
				view = new FullView(layout, model, control);
			else if (type == ViewType.DEFAULT)
				view = new DefaultView(layout, model, control);
			else
				view = new DefaultView(layout, model, control);
			// i18n
			model.getI18nListener().actionPerformed(null);
			return view;
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * View types.
	 * 
	 * @author Roland Bruggmann (brugr9@bfh.ch)
	 * 
	 */
	public enum ViewType {
		DEFAULT, FULL;
	}

}
