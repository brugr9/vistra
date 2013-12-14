package ch.bfh.bti7301.hs2013.gravis.gui;

import ch.bfh.bti7301.hs2013.gravis.core.ICore;
import ch.bfh.bti7301.hs2013.gravis.core.graph.GraphFactory;
import ch.bfh.bti7301.hs2013.gravis.core.graph.IGravisGraph;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.edge.IEdge;
import ch.bfh.bti7301.hs2013.gravis.core.graph.item.vertex.IVertex;
import ch.bfh.bti7301.hs2013.gravis.gui.control.Control;
import ch.bfh.bti7301.hs2013.gravis.gui.view.IView;
import ch.bfh.bti7301.hs2013.gravis.gui.view.FullView;
import ch.bfh.bti7301.hs2013.gravis.gui.view.MinimalView;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;

/**
 * A gui factory creating MVC-GUIs.
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
			IGravisGraph graph = GraphFactory.createIGravisGraph();
			Layout<IVertex, IEdge> layout = new StaticLayout<IVertex, IEdge>(
					graph);
			// model and control
			Model model = new Model(graph);
			Control control = new Control(core, model);
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
