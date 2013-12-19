package vistra.gui;

import vistra.core.ICore;
import vistra.core.graph.GraphFactory;
import vistra.core.graph.zobsolete.IObservableGraph;
import vistra.core.graph.zobsolete.item.edge.IEdge;
import vistra.core.graph.zobsolete.item.vertex.IVertex;
import vistra.gui.control.Control;
import vistra.gui.control.IControl;
import vistra.gui.view.FullView;
import vistra.gui.view.IView;
import vistra.gui.view.MinimalView;
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
	 * Creates a gui (MVC).
	 * 
	 * @param core
	 *            a gravis core
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
	 * Creates a gui (MVC).
	 * 
	 * @param core
	 *            a gravis core
	 * @param type
	 *            the view type
	 * @return a view as in MVC
	 * @throws Exception
	 */
	public static IView createGui(ICore core, ViewType type) throws Exception {
		try {
			// graph and layout
			IObservableGraph graph = GraphFactory.createObservableGraph();
			Layout<IVertex, IEdge> layout = new StaticLayout<IVertex, IEdge>(
					graph);
			// model and control
			Model model = new Model(graph);
			IControl control = new Control(core, model);
			// view
			IView view;
			if (type == ViewType.FULL)
				view = new FullView(layout, model, control);
			else if (type == ViewType.MINIMAL)
				view = new MinimalView(layout, model, control);
			else
				view = new FullView(layout, model, control);
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
		DEFAULT, FULL, MINIMAL,
	}

}
