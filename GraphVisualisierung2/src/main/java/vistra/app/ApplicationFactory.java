package vistra.app;

import java.io.File;
import java.util.Properties;

import vistra.app.control.Control;
import vistra.app.control.IControl;
import vistra.app.view.DefaultView;
import vistra.app.view.FullView;
import vistra.app.view.IView;
import vistra.framework.Core;
import vistra.framework.ICore;
import vistra.framework.graph.item.IEdgeLayout;
import vistra.framework.graph.item.IVertexLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.layout.StaticLayout;

/**
 * An application factory for creating MVC based graphic user interfaces.
 * 
 * @author Roland Bruggmann (brugr9@bfh.ch)
 * 
 */
final class ApplicationFactory {

	/**
	 * A main (no-)constructor.
	 */
	private ApplicationFactory() {
	}

	/**
	 * Creates an application with core and a default graphic user interface
	 * (MVC).
	 * 
	 * @return the view
	 * @throws Exception
	 */
	static IView createApplication() throws Exception {
		try {
			Properties properties = createProperties();
			ICore core = new Core(properties);
			IView view = createGui(core);
			return view;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Creates an application with core and a graphic user interface (MVC) of
	 * given type.
	 * 
	 * @param viewType
	 * @return the view
	 * @throws Exception
	 */
	static IView createApplication(ViewType viewType) throws Exception {
		try {
			Properties properties = createProperties();
			ICore core = new Core(properties);
			IView view = createGui(core, viewType);
			return view;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Creates properties for this application.
	 * 
	 * @throws Exception
	 */
	private static Properties createProperties() throws Exception {

		String propertiesName = ApplicationFactory.class.getPackage().getName()
				.replace(".", File.separator)
				+ File.separator + "Application.properties";

		try {

			Properties properties = null;
			properties = new Properties();
			properties.load(ApplicationFactory.class.getClassLoader()
					.getResourceAsStream(propertiesName));
			return properties;

		} catch (SecurityException e) {
			throw new Exception(ApplicationFactory.class.getName(), e);
		} catch (Exception e) {
			throw new IllegalArgumentException(
					ApplicationFactory.class.getName()
							+ ": \nCannot load properties file "
							+ propertiesName + "\n", e);
		}

	}

	/**
	 * Creates a graphic user interface.
	 * 
	 * @param core
	 *            a core
	 * @return a view as in MVC
	 * @throws Exception
	 */
	static IView createGui(ICore core) throws Exception {
		try {
			return createGui(core, ViewType.DEFAULT);
		} catch (Exception ex) {
			throw ex;
		}
	}

	/**
	 * Creates a graphic user interface.
	 * 
	 * @param core
	 *            a core
	 * @param type
	 *            the view type
	 * @return a view as in MVC
	 * @throws Exception
	 */
	static IView createGui(ICore core, ViewType type) throws Exception {
		try {
			// model and control
			Model model = new Model();
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
	enum ViewType {
		DEFAULT, FULL;
	}

}
